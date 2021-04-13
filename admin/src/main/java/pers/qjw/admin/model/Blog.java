package pers.qjw.admin.model;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String title;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String summary;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date publishDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String blogColumn;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer views;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String tags;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String comments;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String blogImg;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte blogState;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte admireState;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte commentState;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte recommendState;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte reprintState;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String content;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTitle() {
        return title;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTitle(String title) {
        this.title = title;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getSummary() {
        return summary;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getPublishDate() {
        return publishDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getBlogColumn() {
        return blogColumn;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBlogColumn(String blogColumn) {
        this.blogColumn = blogColumn;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getViews() {
        return views;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setViews(Integer views) {
        this.views = views;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTags() {
        return tags;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTags(String tags) {
        this.tags = tags;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getComments() {
        return comments;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setComments(String comments) {
        this.comments = comments;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getBlogImg() {
        return blogImg;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBlogImg(String blogImg) {
        this.blogImg = blogImg;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getBlogState() {
        return blogState;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBlogState(Byte blogState) {
        this.blogState = blogState;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getAdmireState() {
        return admireState;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAdmireState(Byte admireState) {
        this.admireState = admireState;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getCommentState() {
        return commentState;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCommentState(Byte commentState) {
        this.commentState = commentState;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getRecommendState() {
        return recommendState;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRecommendState(Byte recommendState) {
        this.recommendState = recommendState;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getReprintState() {
        return reprintState;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setReprintState(Byte reprintState) {
        this.reprintState = reprintState;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getContent() {
        return content;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", summary=").append(summary);
        sb.append(", publishDate=").append(publishDate);
        sb.append(", blogColumn=").append(blogColumn);
        sb.append(", views=").append(views);
        sb.append(", tags=").append(tags);
        sb.append(", comments=").append(comments);
        sb.append(", blogImg=").append(blogImg);
        sb.append(", blogState=").append(blogState);
        sb.append(", admireState=").append(admireState);
        sb.append(", commentState=").append(commentState);
        sb.append(", recommendState=").append(recommendState);
        sb.append(", reprintState=").append(reprintState);
        sb.append(", createTime=").append(createTime);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}