package org.fabrelab.sitefactory.dal.dataobject;
import java.io.Serializable;
import java.util.*;
public class SitePermissionDO implements Serializable {
    private static final long serialVersionUID = 135010509466182379L;
    private java.lang.Long id;
    private java.lang.Long siteId;
    private java.lang.String permission;
    private java.lang.String userCondition;
    private java.util.Date gmtCreate;
    private java.util.Date gmtModify;
    private java.lang.Long creatorId;
    private java.lang.Long modifierId;
    public SitePermissionDO() {
        super();
    }
    public java.lang.Long getId() {
        return id;
    }
    public void setId(java.lang.Long id) {
        this.id = id;
    }
    public java.lang.Long getSiteId() {
        return siteId;
    }
    public void setSiteId(java.lang.Long siteId) {
        this.siteId = siteId;
    }
    public java.lang.String getPermission() {
        return permission;
    }
    public void setPermission(java.lang.String permission) {
        this.permission = permission;
    }
    public java.lang.String getUserCondition() {
        return userCondition;
    }
    public void setUserCondition(java.lang.String userCondition) {
        this.userCondition = userCondition;
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
}
