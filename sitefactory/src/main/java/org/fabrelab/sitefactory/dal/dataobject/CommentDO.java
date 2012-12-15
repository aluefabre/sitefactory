package org.fabrelab.sitefactory.dal.dataobject;
import java.io.Serializable;
import java.util.*;
public class CommentDO implements Serializable {
    private static final long serialVersionUID = 135010509466182379L;
    private java.lang.Long id;
    private java.util.Date gmtCreate;
    private java.lang.Long creatorId;
    private java.util.Date gmtModify;
    private java.lang.Long modifierId;
    private java.lang.String content;
    private java.lang.Integer rate;
    public CommentDO() {
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
    public java.lang.Long getCreatorId() {
        return creatorId;
    }
    public void setCreatorId(java.lang.Long creatorId) {
        this.creatorId = creatorId;
    }
    public java.util.Date getGmtModify() {
        return gmtModify;
    }
    public void setGmtModify(java.util.Date gmtModify) {
        this.gmtModify = gmtModify;
    }
    public java.lang.Long getModifierId() {
        return modifierId;
    }
    public void setModifierId(java.lang.Long modifierId) {
        this.modifierId = modifierId;
    }
    public java.lang.String getContent() {
        return content;
    }
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    public java.lang.Integer getRate() {
        return rate;
    }
    public void setRate(java.lang.Integer rate) {
        this.rate = rate;
    }
}
