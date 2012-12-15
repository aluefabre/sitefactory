package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class UserDAOImpl extends SqlMapClientDaoSupport implements UserDAO {

    public java.lang.Long insert(UserDO userDO) {
        Object id = getSqlMapClientTemplate().insert("User.insert", userDO);
        return (java.lang.Long) id;
    }


    public Integer update(UserDO userDO) {
        int result = getSqlMapClientTemplate().update("User.update", userDO);
        return result;
    }


    public UserDO findByPrimaryKey(java.lang.Long id) {
        UserDO userDO = (UserDO) getSqlMapClientTemplate().queryForObject("User.findByPrimaryKey", id);
        return userDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("User.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(UserDO userDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("User.countByExample", userDO);
        return count;
    }


    public List<UserDO> listByExample(UserDO userDO) {
        List<UserDO> list = getSqlMapClientTemplate().queryForList("User.listByExample", userDO);
        return list;
    }


    public List<UserDO> pageByExample(UserDO userDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", userDO.getId());
        params.put("gmtCreate", userDO.getGmtCreate());
        params.put("gmtModify", userDO.getGmtModify());
        params.put("creatorId", userDO.getCreatorId());
        params.put("modifierId", userDO.getModifierId());
        params.put("name", userDO.getName());
        params.put("email", userDO.getEmail());
        params.put("password", userDO.getPassword());
        params.put("profession", userDO.getProfession());
        params.put("company", userDO.getCompany());
        params.put("location", userDO.getLocation());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<UserDO> list = getSqlMapClientTemplate().queryForList("User.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(UserDO userDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("User.deleteByExample", userDO);
        return count;
    }


    public List<UserDO> listByRelation(UserRelationDO userRelationDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", userRelationDO.getRelation()); 
        params.put("relatedType", userRelationDO.getRelatedType()); 
        params.put("relatedId", userRelationDO.getRelatedId()); 
        List<UserDO> list = getSqlMapClientTemplate().queryForList("User.listByRelation", params);
        return list;
    }


    public List<UserDO> pageByRelation(UserRelationDO userRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", userRelationDO.getRelation()); 
        params.put("relatedType", userRelationDO.getRelatedType()); 
        params.put("relatedId", userRelationDO.getRelatedId()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<UserDO> list = getSqlMapClientTemplate().queryForList("User.pageByRelation", params);
        return list;
    }


    public List<UserDO> pageByRelationAndExample(UserRelationDO userRelationDO, UserDO userDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", userRelationDO.getRelation()); 
        params.put("relatedType", userRelationDO.getRelatedType()); 
        params.put("relatedId", userRelationDO.getRelatedId()); 
        params.put("id", userDO.getId()); 
        params.put("gmtCreate", userDO.getGmtCreate()); 
        params.put("gmtModify", userDO.getGmtModify()); 
        params.put("creatorId", userDO.getCreatorId()); 
        params.put("modifierId", userDO.getModifierId()); 
        params.put("name", userDO.getName()); 
        params.put("email", userDO.getEmail()); 
        params.put("password", userDO.getPassword()); 
        params.put("profession", userDO.getProfession()); 
        params.put("company", userDO.getCompany()); 
        params.put("location", userDO.getLocation()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<UserDO> list = getSqlMapClientTemplate().queryForList("User.pageByRelationAndExample", params);
        return list;
    }


    public List<UserDO> listByRelationAndExample(UserRelationDO userRelationDO, UserDO userDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", userRelationDO.getRelation()); 
        params.put("relatedType", userRelationDO.getRelatedType()); 
        params.put("relatedId", userRelationDO.getRelatedId()); 
        params.put("id", userDO.getId()); 
        params.put("gmtCreate", userDO.getGmtCreate()); 
        params.put("gmtModify", userDO.getGmtModify()); 
        params.put("creatorId", userDO.getCreatorId()); 
        params.put("modifierId", userDO.getModifierId()); 
        params.put("name", userDO.getName()); 
        params.put("email", userDO.getEmail()); 
        params.put("password", userDO.getPassword()); 
        params.put("profession", userDO.getProfession()); 
        params.put("company", userDO.getCompany()); 
        params.put("location", userDO.getLocation()); 
        List<UserDO> list = getSqlMapClientTemplate().queryForList("User.listByRelationAndExample", params);
        return list;
    }

}
