package pers.qjw.admin.interceptor;

import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import pers.qjw.admin.config.Constants;
import pers.qjw.admin.exception.UserIllegalArgumentException;
import pers.qjw.admin.mapper.BlogDynamicSqlSupport;
import pers.qjw.admin.mapper.BlogMapper;
import pers.qjw.admin.model.Blog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Objects;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@AllArgsConstructor
public class AccessRecordInterceptor implements HandlerInterceptor {

    private final BlogMapper blogMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        String method = request.getMethod();
        // 筛掉get意外的方法
        if (Objects.equals(method, "GET")) {
            // 没有登录的游客每请求一次文章就算浏览了一次文章
            String token = request.getHeader(Constants.AUTHORIZATION);
            if (Strings.isNullOrEmpty(token) || "null".equals(token)) {
                // 从uri里获取文章id
                String[] uri = request.getRequestURI().split("/");
                int id;
                try {
                    id = Integer.parseInt(uri[uri.length - 1]);
                } catch (Exception e) {
                    throw new UserIllegalArgumentException(HttpStatus.BAD_REQUEST, "未找到指定资源");
                }

                Optional<Blog> optional = blogMapper.selectOne(c -> c.where(BlogDynamicSqlSupport.id, isEqualTo(id)));
                if (optional.isPresent()) {
                    Blog blog = optional.get();
                    // 更新数据
                    if (Objects.isNull(blog.getViews())) {
                        blog.setViews(0);
                    }
                    blogMapper.update(c -> c.set(BlogDynamicSqlSupport.views).equalTo(blog.getViews() + 1)
                            .where(BlogDynamicSqlSupport.id, isEqualTo(id)));
                } else {
                    throw new UserIllegalArgumentException(HttpStatus.BAD_REQUEST, "未找到指定资源");
                }
            }
        }
        return true;
    }

}
