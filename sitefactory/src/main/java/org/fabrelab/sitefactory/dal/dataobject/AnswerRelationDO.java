package org.fabrelab.sitefactory.dal.dataobject;
import java.io.Serializable;
import java.util.*;
public class AnswerRelationDO implements Serializable {
    private static final long serialVersionUID = 135010509466182379L;
    private java.lang.Long id;
    private java.util.Date gmtCreate;
    private java.util.Date gmtModify;
    private java.lang.Long creatorId;
    private java.lang.Long modifierId;
    private java.lang.Long relatedId;
    private java.lang.Long answerId;
    private java.lang.String relation;
    private java.lang.String relatedType;
    public AnswerRelationDO() {
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
    public java.lang.Long getRelatedId() {
        return relatedId;
    }
    public void setRelatedId(java.lang.Long relatedId) {
        this.relatedId = relatedId;
    }
    public java.lang.Long getAnswerId() {
        return answerId;
    }
    public void setAnswerId(java.lang.Long answerId) {
        this.answerId = answerId;
    }
    public java.lang.String getRelation() {
        return relation;
    }
    public void setRelation(java.lang.String relation) {
        this.relation = relation;
    }
    public java.lang.String getRelatedType() {
        return relatedType;
    }
    public void setRelatedType(java.lang.String relatedType) {
        this.relatedType = relatedType;
    }
}
