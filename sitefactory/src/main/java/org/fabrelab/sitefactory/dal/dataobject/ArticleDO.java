package org.fabrelab.sitefactory.dal.dataobject;
import java.io.Serializable;
import java.util.*;
public class ArticleDO implements Serializable {
    private static final long serialVersionUID = 135010509466182379L;
    private java.lang.Long id;
    private java.util.Date gmtCreate;
    private java.util.Date gmtModify;
    private java.lang.Long creatorId;
    private java.lang.Long modifierId;
    private java.lang.String title;
    private java.lang.Long contentId;
    private java.lang.String type;
    public ArticleDO() {
        super();
    }
    public java.lang.Long getId() {
        return id;
    }
    public void setId(java.lang.Long id) {
        this.id = id;
    }
    public java.util.Date getGmtCreate() {
        return gmtCreate;
    }
    public void setGmtCreate(java.util.Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
    public java.util.Date getGmtModify() {
        return gmtModify;
    }
    public void setGmtModify(java.util.Date gmtModify) {
        this.gmtModify = gmtModify;
    }
    public java.lang.Long getCreatorId() {
        return creatorId;
    }
    public void setCreatorId(java.lang.Long creatorId) {
        this.creatorId = creatorId;
    }
    public java.lang.Long getModifierId() {
        return modifierId;
    }
    public void setModifierId(java.lang.Long modifierId) {
        this.modifierId = modifierId;
    }
    public java.lang.String getTitle() {
        return title;
    }
    public void setTitle(java.lang.String title) {
        this.title = title;
    }
    public java.lang.Long getContentId() {
        return contentId;
    }
    public void setContentId(java.lang.Long contentId) {
        this.contentId = contentId;
    }
    public java.lang.String getType() {
        return type;
    }
    public void setType(java.lang.String type) {
        this.type = type;
    }
}
