package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class UserRelationDAOImpl extends SqlMapClientDaoSupport implements UserRelationDAO {

    public java.lang.Long insert(UserRelationDO userRelationDO) {
        Object id = getSqlMapClientTemplate().insert("UserRelation.insert", userRelationDO);
        return (java.lang.Long) id;
    }


    public Integer update(UserRelationDO userRelationDO) {
        int result = getSqlMapClientTemplate().update("UserRelation.update", userRelationDO);
        return result;
    }


    public UserRelationDO findByPrimaryKey(java.lang.Long id) {
        UserRelationDO userRelationDO = (UserRelationDO) getSqlMapClientTemplate().queryForObject("UserRelation.findByPrimaryKey", id);
        return userRelationDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("UserRelation.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(UserRelationDO userRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("UserRelation.countByExample", userRelationDO);
        return count;
    }


    public List<UserRelationDO> listByExample(UserRelationDO userRelationDO) {
        List<UserRelationDO> list = getSqlMapClientTemplate().queryForList("UserRelation.listByExample", userRelationDO);
        return list;
    }


    public List<UserRelationDO> pageByExample(UserRelationDO userRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", userRelationDO.getId());
        params.put("gmtCreate", userRelationDO.getGmtCreate());
        params.put("gmtModify", userRelationDO.getGmtModify());
        params.put("creatorId", userRelationDO.getCreatorId());
        params.put("modifierId", userRelationDO.getModifierId());
        params.put("userId", userRelationDO.getUserId());
        params.put("relatedId", userRelationDO.getRelatedId());
        params.put("relatedType", userRelationDO.getRelatedType());
        params.put("relationData", userRelationDO.getRelationData());
        params.put("relation", userRelationDO.getRelation());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<UserRelationDO> list = getSqlMapClientTemplate().queryForList("UserRelation.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(UserRelationDO userRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("UserRelation.deleteByExample", userRelationDO);
        return count;
    }









}
