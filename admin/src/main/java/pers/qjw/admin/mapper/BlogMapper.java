package pers.qjw.admin.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static pers.qjw.admin.mapper.BlogDynamicSqlSupport.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import pers.qjw.admin.model.Blog;

@Mapper
public interface BlogMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, title, summary, publishDate, blogColumn, views, tags, comments, blogImg, blogState, admireState, commentState, recommendState, reprintState, createTime, content);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Blog> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Blog> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BlogResult")
    Optional<Blog> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BlogResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="summary", property="summary", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_date", property="publishDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="blog_column", property="blogColumn", jdbcType=JdbcType.VARCHAR),
        @Result(column="views", property="views", jdbcType=JdbcType.INTEGER),
        @Result(column="tags", property="tags", jdbcType=JdbcType.VARCHAR),
        @Result(column="comments", property="comments", jdbcType=JdbcType.VARCHAR),
        @Result(column="blog_img", property="blogImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="blog_state", property="blogState", jdbcType=JdbcType.TINYINT),
        @Result(column="admire_state", property="admireState", jdbcType=JdbcType.TINYINT),
        @Result(column="comment_state", property="commentState", jdbcType=JdbcType.TINYINT),
        @Result(column="recommend_state", property="recommendState", jdbcType=JdbcType.TINYINT),
        @Result(column="reprint_state", property="reprintState", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Blog> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, blog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, blog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Blog record) {
        return MyBatis3Utils.insert(this::insert, record, blog, c ->
            c.map(id).toProperty("id")
            .map(title).toProperty("title")
            .map(summary).toProperty("summary")
            .map(publishDate).toProperty("publishDate")
            .map(blogColumn).toProperty("blogColumn")
            .map(views).toProperty("views")
            .map(tags).toProperty("tags")
            .map(comments).toProperty("comments")
            .map(blogImg).toProperty("blogImg")
            .map(blogState).toProperty("blogState")
            .map(admireState).toProperty("admireState")
            .map(commentState).toProperty("commentState")
            .map(recommendState).toProperty("recommendState")
            .map(reprintState).toProperty("reprintState")
            .map(createTime).toProperty("createTime")
            .map(content).toProperty("content")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Blog> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, blog, c ->
            c.map(id).toProperty("id")
            .map(title).toProperty("title")
            .map(summary).toProperty("summary")
            .map(publishDate).toProperty("publishDate")
            .map(blogColumn).toProperty("blogColumn")
            .map(views).toProperty("views")
            .map(tags).toProperty("tags")
            .map(comments).toProperty("comments")
            .map(blogImg).toProperty("blogImg")
            .map(blogState).toProperty("blogState")
            .map(admireState).toProperty("admireState")
            .map(commentState).toProperty("commentState")
            .map(recommendState).toProperty("recommendState")
            .map(reprintState).toProperty("reprintState")
            .map(createTime).toProperty("createTime")
            .map(content).toProperty("content")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Blog record) {
        return MyBatis3Utils.insert(this::insert, record, blog, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(title).toPropertyWhenPresent("title", record::getTitle)
            .map(summary).toPropertyWhenPresent("summary", record::getSummary)
            .map(publishDate).toPropertyWhenPresent("publishDate", record::getPublishDate)
            .map(blogColumn).toPropertyWhenPresent("blogColumn", record::getBlogColumn)
            .map(views).toPropertyWhenPresent("views", record::getViews)
            .map(tags).toPropertyWhenPresent("tags", record::getTags)
            .map(comments).toPropertyWhenPresent("comments", record::getComments)
            .map(blogImg).toPropertyWhenPresent("blogImg", record::getBlogImg)
            .map(blogState).toPropertyWhenPresent("blogState", record::getBlogState)
            .map(admireState).toPropertyWhenPresent("admireState", record::getAdmireState)
            .map(commentState).toPropertyWhenPresent("commentState", record::getCommentState)
            .map(recommendState).toPropertyWhenPresent("recommendState", record::getRecommendState)
            .map(reprintState).toPropertyWhenPresent("reprintState", record::getReprintState)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(content).toPropertyWhenPresent("content", record::getContent)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Blog> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, blog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Blog> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, blog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Blog> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, blog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Blog> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, blog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Blog record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(title).equalTo(record::getTitle)
                .set(summary).equalTo(record::getSummary)
                .set(publishDate).equalTo(record::getPublishDate)
                .set(blogColumn).equalTo(record::getBlogColumn)
                .set(views).equalTo(record::getViews)
                .set(tags).equalTo(record::getTags)
                .set(comments).equalTo(record::getComments)
                .set(blogImg).equalTo(record::getBlogImg)
                .set(blogState).equalTo(record::getBlogState)
                .set(admireState).equalTo(record::getAdmireState)
                .set(commentState).equalTo(record::getCommentState)
                .set(recommendState).equalTo(record::getRecommendState)
                .set(reprintState).equalTo(record::getReprintState)
                .set(createTime).equalTo(record::getCreateTime)
                .set(content).equalTo(record::getContent);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Blog record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(title).equalToWhenPresent(record::getTitle)
                .set(summary).equalToWhenPresent(record::getSummary)
                .set(publishDate).equalToWhenPresent(record::getPublishDate)
                .set(blogColumn).equalToWhenPresent(record::getBlogColumn)
                .set(views).equalToWhenPresent(record::getViews)
                .set(tags).equalToWhenPresent(record::getTags)
                .set(comments).equalToWhenPresent(record::getComments)
                .set(blogImg).equalToWhenPresent(record::getBlogImg)
                .set(blogState).equalToWhenPresent(record::getBlogState)
                .set(admireState).equalToWhenPresent(record::getAdmireState)
                .set(commentState).equalToWhenPresent(record::getCommentState)
                .set(recommendState).equalToWhenPresent(record::getRecommendState)
                .set(reprintState).equalToWhenPresent(record::getReprintState)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(content).equalToWhenPresent(record::getContent);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Blog record) {
        return update(c ->
            c.set(title).equalTo(record::getTitle)
            .set(summary).equalTo(record::getSummary)
            .set(publishDate).equalTo(record::getPublishDate)
            .set(blogColumn).equalTo(record::getBlogColumn)
            .set(views).equalTo(record::getViews)
            .set(tags).equalTo(record::getTags)
            .set(comments).equalTo(record::getComments)
            .set(blogImg).equalTo(record::getBlogImg)
            .set(blogState).equalTo(record::getBlogState)
            .set(admireState).equalTo(record::getAdmireState)
            .set(commentState).equalTo(record::getCommentState)
            .set(recommendState).equalTo(record::getRecommendState)
            .set(reprintState).equalTo(record::getReprintState)
            .set(createTime).equalTo(record::getCreateTime)
            .set(content).equalTo(record::getContent)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Blog record) {
        return update(c ->
            c.set(title).equalToWhenPresent(record::getTitle)
            .set(summary).equalToWhenPresent(record::getSummary)
            .set(publishDate).equalToWhenPresent(record::getPublishDate)
            .set(blogColumn).equalToWhenPresent(record::getBlogColumn)
            .set(views).equalToWhenPresent(record::getViews)
            .set(tags).equalToWhenPresent(record::getTags)
            .set(comments).equalToWhenPresent(record::getComments)
            .set(blogImg).equalToWhenPresent(record::getBlogImg)
            .set(blogState).equalToWhenPresent(record::getBlogState)
            .set(admireState).equalToWhenPresent(record::getAdmireState)
            .set(commentState).equalToWhenPresent(record::getCommentState)
            .set(recommendState).equalToWhenPresent(record::getRecommendState)
            .set(reprintState).equalToWhenPresent(record::getReprintState)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(content).equalToWhenPresent(record::getContent)
            .where(id, isEqualTo(record::getId))
        );
    }
}