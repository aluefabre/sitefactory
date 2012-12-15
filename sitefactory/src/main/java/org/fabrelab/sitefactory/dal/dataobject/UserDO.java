package org.fabrelab.sitefactory.dal.dataobject;
import java.io.Serializable;
import java.util.*;
public class UserDO implements Serializable {
    private static final long serialVersionUID = 135010509466182379L;
    private java.lang.Long id;
    private java.util.Date gmtCreate;
    private java.util.Date gmtModify;
    private java.lang.Long creatorId;
    private java.lang.Long modifierId;
    private java.lang.String name;
    private java.lang.String email;
    private java.lang.String password;
    private java.lang.String profession;
    private java.lang.String company;
    private java.lang.String location;
    public UserDO() {
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
    public java.lang.String getName() {
        return name;
    }
    public void setName(java.lang.String name) {
        this.name = name;
    }
    public java.lang.String getEmail() {
        return email;
    }
    public void setEmail(java.lang.String email) {
        this.email = email;
    }
    public java.lang.String getPassword() {
        return password;
    }
    public void setPassword(java.lang.String password) {
        this.password = password;
    }
    public java.lang.String getProfession() {
        return profession;
    }
    public void setProfession(java.lang.String profession) {
        this.profession = profession;
    }
    public java.lang.String getCompany() {
        return company;
    }
    public void setCompany(java.lang.String company) {
        this.company = company;
    }
    public java.lang.String getLocation() {
        return location;
    }
    public void setLocation(java.lang.String location) {
        this.location = location;
    }
}
