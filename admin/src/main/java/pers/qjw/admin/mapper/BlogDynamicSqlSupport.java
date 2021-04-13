package pers.qjw.admin.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class BlogDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Blog blog = new Blog();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = blog.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> title = blog.title;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> summary = blog.summary;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> publishDate = blog.publishDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> blogColumn = blog.blogColumn;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> views = blog.views;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> tags = blog.tags;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> comments = blog.comments;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> blogImg = blog.blogImg;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> blogState = blog.blogState;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> admireState = blog.admireState;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> commentState = blog.commentState;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> recommendState = blog.recommendState;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> reprintState = blog.reprintState;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = blog.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> content = blog.content;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Blog extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);

        public final SqlColumn<String> summary = column("summary", JDBCType.VARCHAR);

        public final SqlColumn<Date> publishDate = column("publish_date", JDBCType.TIMESTAMP);

        public final SqlColumn<String> blogColumn = column("blog_column", JDBCType.VARCHAR);

        public final SqlColumn<Integer> views = column("views", JDBCType.INTEGER);

        public final SqlColumn<String> tags = column("tags", JDBCType.VARCHAR);

        public final SqlColumn<String> comments = column("comments", JDBCType.VARCHAR);

        public final SqlColumn<String> blogImg = column("blog_img", JDBCType.VARCHAR);

        public final SqlColumn<Byte> blogState = column("blog_state", JDBCType.TINYINT);

        public final SqlColumn<Byte> admireState = column("admire_state", JDBCType.TINYINT);

        public final SqlColumn<Byte> commentState = column("comment_state", JDBCType.TINYINT);

        public final SqlColumn<Byte> recommendState = column("recommend_state", JDBCType.TINYINT);

        public final SqlColumn<Byte> reprintState = column("reprint_state", JDBCType.TINYINT);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> content = column("content", JDBCType.LONGVARCHAR);

        public Blog() {
            super("blog");
        }
    }
}