package org.fabrelab.sitefactory.dal.dataobject;
import java.io.Serializable;
import java.util.*;
public class UserRelationDO implements Serializable {
    private static final long serialVersionUID = 135010509466182379L;
    private java.lang.Long id;
    private java.util.Date gmtCreate;
    private java.util.Date gmtModify;
    private java.lang.Long creatorId;
    private java.lang.Long modifierId;
    private java.lang.Long userId;
    private java.lang.Long relatedId;
    private java.lang.String relatedType;
    private java.lang.String relationData;
    private java.lang.String relation;
    public UserRelationDO() {
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
    public java.lang.Long getUserId() {
        return userId;
    }
    public void setUserId(java.lang.Long userId) {
        this.userId = userId;
    }
    public java.lang.Long getRelatedId() {
        return relatedId;
    }
    public void setRelatedId(java.lang.Long relatedId) {
        this.relatedId = relatedId;
    }
    public java.lang.String getRelatedType() {
        return relatedType;
    }
    public void setRelatedType(java.lang.String relatedType) {
        this.relatedType = relatedType;
    }
    public java.lang.String getRelationData() {
        return relationData;
    }
    public void setRelationData(java.lang.String relationData) {
        this.relationData = relationData;
    }
    public java.lang.String getRelation() {
        return relation;
    }
    public void setRelation(java.lang.String relation) {
        this.relation = relation;
    }
}
