package pers.qjw.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pers.qjw.admin.config.Constants;
import pers.qjw.admin.exception.PersistenceFailedException;
import pers.qjw.admin.exception.UserIllegalArgumentException;
import pers.qjw.admin.mapper.*;
import pers.qjw.admin.model.Blog;
import pers.qjw.admin.model.BlogColumn;
import pers.qjw.admin.model.Tags;
import pers.qjw.admin.service.ArticlesService;

import java.io.File;
import java.util.*;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isLike;

@Service
@AllArgsConstructor
public class ArticlesServiceImpl implements ArticlesService {

    private final BlogMapper blogMapper;

    private final BlogColumnMapper BlogColumnMapper;

    private final TagsMapper tagsMapper;

    // 持久化图片
    private String persistenceImg(MultipartFile photo) {
        String newFileName = null;
        String oldFileName = photo.getOriginalFilename();
        if (!Objects.isNull(oldFileName)) {
            String[] arr = oldFileName.split("\\.");
            oldFileName = arr[arr.length - 1];
            newFileName = UUID.randomUUID().toString().replace("-", "") + "." + oldFileName;
            String path = System.getProperty("user.dir") + "\\images\\";
            File file = new File(path + newFileName);
            try {
                if (file.createNewFile()) {
                    photo.transferTo(file);
                }
            } catch (Exception ignored) {
            }
        }
        return newFileName;
    }

    // 检查专栏，如果专栏不存在则新键，如果存在则维护 专栏的使用次数(有多少博客属于该专栏)
    private void checkColumn(String BlogColumn) {
        Optional<BlogColumn> optional = BlogColumnMapper.selectOne(c -> c.where(BlogColumnDynamicSqlSupport.name, isEqualTo(BlogColumn)));
        if (optional.isPresent()) {
            BlogColumn temp = optional.get();
            BlogColumnMapper.update(c ->
                    c.set(BlogColumnDynamicSqlSupport.blogCount).equalTo(temp.getBlogCount() + 1)
                            .where(BlogColumnDynamicSqlSupport.id, isEqualTo(temp.getId())));
        } else {
            BlogColumn newBlogColumn = new BlogColumn();
            newBlogColumn.setName(BlogColumn);
            newBlogColumn.setCreateTime(new Date());
            newBlogColumn.setBlogCount(1);
            int flag = BlogColumnMapper.insert(newBlogColumn);
            if (flag != 1) {
                throw new PersistenceFailedException(HttpStatus.INTERNAL_SERVER_ERROR, "新专栏持久化失败");
            }
        }
    }

    // 检查标签，如果标签不存在则新键，如果存在则维护 标签的使用次数(有多少博客添加了改标签)
    private void checkTags(String tags) {
        String[] tagArr = tags.split(",");
        for (String temp : tagArr) {
            Optional<Tags> optional = tagsMapper.selectOne(c -> c.where(TagsDynamicSqlSupport.name, isEqualTo(temp)));
            if (optional.isEmpty()) {
                Tags newTags = new Tags();
                newTags.setName(temp);
                newTags.setBlogCount(1);
                newTags.setCreateTime(new Date());
                tagsMapper.insert(newTags);
            } else {
                Tags tags1 = optional.get();
                tagsMapper.update(c ->
                        c.set(TagsDynamicSqlSupport.blogCount).equalTo(tags1.getBlogCount() + 1)
                                .where(BlogColumnDynamicSqlSupport.id, isEqualTo(tags1.getId())));
            }
        }
    }

    private void checkByte(Byte data) {
        if (Objects.isNull(data) ||
                (!Objects.equals(data, Byte.parseByte("1")) &&
                        !Objects.equals(data, Byte.parseByte("0")))
        ) {
            throw new UserIllegalArgumentException(HttpStatus.BAD_REQUEST, "未上完整传数据或上传了违规数据");
        }
    }

    private void checkString(String data) {
        if (Strings.isNullOrEmpty(data)) {
            throw new UserIllegalArgumentException(HttpStatus.BAD_REQUEST, "未上完整传数据或上传了违规数据");
        }
    }

    private void checkPhoto(MultipartFile photo) {
        // 检查图片数据
        if (Objects.isNull(photo)) {
            throw new UserIllegalArgumentException(HttpStatus.BAD_REQUEST, "未上传封面图片");
        }
    }

    // 检查数据是否合规
    private void checkData(Blog blog) {
        // 检查标题数据
        checkString(blog.getTitle());
        // 检查摘要数据
        checkString(blog.getSummary());
        // 检查标签数据
        checkString(blog.getTags());
        // 检查专栏数据
        checkString(blog.getBlogColumn());
        // 检查 Admire 数据
        checkByte(blog.getAdmireState());
        // 检查文章状态数据
        checkByte(blog.getBlogState());
        // 检查推荐状态
        checkByte(blog.getRecommendState());
        // 检查转载状态
        checkByte(blog.getReprintState());
    }

    @Override
    // 持久化文章
    public void createArticles(MultipartFile photo, Blog blog) {
        checkPhoto(photo);
        // 检查数据
        checkData(blog);
        // 记录时间，用于设置文章发布时间和创建时间
        Date now = new Date();
        // 判断文章有没有发布
        if (blog.getBlogState() == Constants.BLOG_STATE_RELEASE) {
            // 设置发布时间
            blog.setPublishDate(now);
        }
        // 设置文章创建时间
        blog.setCreateTime(now);
        // 获取文章封面图片名字,并持久化图片
        String newFileName = persistenceImg(photo);
        // 设置文章封面图片地址
        blog.setBlogImg("/images/" + newFileName);
        // 检查专栏，如果专栏不存在则新键，如果存在则维护 专栏的使用次数(有多少博客属于该专栏)
        checkColumn(blog.getBlogColumn());
        // 持久化文章
        int flag = blogMapper.insert(blog);
        if (flag != 1) {
            throw new PersistenceFailedException(HttpStatus.INTERNAL_SERVER_ERROR, "文章未添加进数据库");
        }
        // 检查标签，如果有新标签就持久化
        checkTags(blog.getTags());
    }

    @Override
    // 获取指定范围内的所有文章
    public List<Blog> getArticles(String page, String number, String columnSelect, String tagsSelect) {
        Map<String, Integer> data = checkData(page, number);
        PageHelper.startPage(data.get(page), data.get(number));
        List<Blog> list;
        if (Strings.isNullOrEmpty(columnSelect) && Strings.isNullOrEmpty(tagsSelect)) {
            // 没有条件筛选
            list = blogMapper.select(c -> c);
        } else if (!Strings.isNullOrEmpty(columnSelect) && !Strings.isNullOrEmpty(tagsSelect)) {
            // 专栏 和 标签 双重筛选
            list = blogMapper.select(c -> c
                    .where(BlogDynamicSqlSupport.blogColumn, isEqualTo(columnSelect))
                    .and(BlogDynamicSqlSupport.tags, isLike("%" + tagsSelect + "%")));
        } else if (!Strings.isNullOrEmpty(columnSelect)) {
            // 仅对 专栏 进行了筛选
            list = blogMapper.select(c -> c
                    .where(BlogDynamicSqlSupport.blogColumn, isEqualTo(columnSelect)));
        } else {
            // 仅对 标签 进行了筛选
            list = blogMapper.select(c -> c.where(BlogDynamicSqlSupport.tags, isLike("%" + tagsSelect + "%")));
        }
        PageInfo<Blog> pageInfo = new PageInfo<>(list);
        return pageInfo.getList();
    }

    @Override
    // 获取指定id的文章
    public Blog getArticles(String id) {
        int newId;
        try {
            newId = Integer.parseInt(id);
        } catch (Exception e) {
            throw new UserIllegalArgumentException(HttpStatus.BAD_REQUEST, "id不合规");
        }
        Optional<Blog> optional = blogMapper.selectOne(c -> c.where(BlogColumnDynamicSqlSupport.id, isEqualTo(newId)));
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new UserIllegalArgumentException(HttpStatus.BAD_REQUEST, "没有找到文章");
        }
    }

    @Override
    public void updateArticles(MultipartFile photo, Blog blog) {
        // 检查数据
        checkData(blog);
        // 检查是否更新了封面
        if (!Objects.isNull(photo)) {
            String newFileName = persistenceImg(photo);
            blog.setBlogImg("/images/" + newFileName);
        }
        // 记录时间，用于设置文章发布时间
        Date now = new Date();
        // 判断文章有没有由未发布转成发布
        boolean flag = whetherChange(blog);
        if (flag) {
            // 设置发布时间
            blog.setPublishDate(now);
        }
        // 检查专栏
        checkColumn(blog.getBlogColumn());
        // 检查标签
        checkTags(blog.getTags());
        // 持久化
        blogMapper.update(c -> c
                .set(BlogDynamicSqlSupport.title).equalTo(blog.getTitle())
                .set(BlogDynamicSqlSupport.summary).equalTo(blog.getSummary())
                .set(BlogDynamicSqlSupport.content).equalTo(blog.getContent())
                .set(BlogDynamicSqlSupport.publishDate).equalTo(blog.getPublishDate())
                .set(BlogDynamicSqlSupport.blogColumn).equalTo(blog.getBlogColumn())
                .set(BlogDynamicSqlSupport.tags).equalTo(blog.getTags())
                .set(BlogDynamicSqlSupport.blogImg).equalTo(blog.getBlogImg())
                .set(BlogDynamicSqlSupport.blogState).equalTo(blog.getBlogState())
                .set(BlogDynamicSqlSupport.admireState).equalTo(blog.getAdmireState())
                .set(BlogDynamicSqlSupport.recommendState).equalTo(blog.getRecommendState())
                .set(BlogDynamicSqlSupport.reprintState).equalTo(blog.getReprintState())
                .where(BlogColumnDynamicSqlSupport.id, isEqualTo(blog.getId())));
    }

    @Override
    public void deleteArticles(String id) {
        checkString(id);
        int newId;
        try {
            newId = Integer.parseInt(id);
        } catch (Exception e) {
            throw new UserIllegalArgumentException(HttpStatus.BAD_REQUEST, "错误的id");
        }
        int flag = blogMapper.delete(c -> c.where(BlogDynamicSqlSupport.id,isEqualTo(newId)));
        if (flag != 1) {
            throw new UserIllegalArgumentException(HttpStatus.BAD_REQUEST, "错误的id");
        }
    }

    private boolean whetherChange(Blog blog) {
        if (blog.getBlogState() == Constants.BLOG_STATE_NOT_RELEASE) {
            return false;
        }
        Optional<Blog> optional = blogMapper.selectOne(c -> c.where(BlogColumnDynamicSqlSupport.id, isEqualTo(blog.getId())));
        if (optional.isPresent()) {
            return optional.get().getBlogState() == Constants.BLOG_STATE_NOT_RELEASE;
        }
        throw new UserIllegalArgumentException(HttpStatus.BAD_REQUEST, "用户修改了文章id");
    }

    private Map<String, Integer> checkData(String page, String number) {
        if (Strings.isNullOrEmpty(page) ||
                Strings.isNullOrEmpty(number)
        ) {
            throw new UserIllegalArgumentException(HttpStatus.BAD_REQUEST, "未上完整传数据或上传了违规数据");
        }
        int newPage, newNumber;
        try {
            newPage = Integer.parseInt(page);
            newNumber = Integer.parseInt(number);
        } catch (Exception e) {
            throw new UserIllegalArgumentException(HttpStatus.BAD_REQUEST, "未上完整传数据或上传了违规数据");
        }
        if (newPage < 0 || newNumber <= 0) {
            throw new UserIllegalArgumentException(HttpStatus.BAD_REQUEST, "未上完整传数据或上传了违规数据");
        }
        Map<String, Integer> result = new HashMap<>();
        result.put(page, newPage);
        result.put(number, newNumber);
        return result;
    }


}
