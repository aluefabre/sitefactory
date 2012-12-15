package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class RoleRelationDAOImpl extends SqlMapClientDaoSupport implements RoleRelationDAO {

    public java.lang.Long insert(RoleRelationDO roleRelationDO) {
        Object id = getSqlMapClientTemplate().insert("RoleRelation.insert", roleRelationDO);
        return (java.lang.Long) id;
    }


    public Integer update(RoleRelationDO roleRelationDO) {
        int result = getSqlMapClientTemplate().update("RoleRelation.update", roleRelationDO);
        return result;
    }


    public RoleRelationDO findByPrimaryKey(java.lang.Long id) {
        RoleRelationDO roleRelationDO = (RoleRelationDO) getSqlMapClientTemplate().queryForObject("RoleRelation.findByPrimaryKey", id);
        return roleRelationDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("RoleRelation.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(RoleRelationDO roleRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("RoleRelation.countByExample", roleRelationDO);
        return count;
    }


    public List<RoleRelationDO> listByExample(RoleRelationDO roleRelationDO) {
        List<RoleRelationDO> list = getSqlMapClientTemplate().queryForList("RoleRelation.listByExample", roleRelationDO);
        return list;
    }


    public List<RoleRelationDO> pageByExample(RoleRelationDO roleRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", roleRelationDO.getId());
        params.put("gmtCreate", roleRelationDO.getGmtCreate());
        params.put("gmtModify", roleRelationDO.getGmtModify());
        params.put("creatorId", roleRelationDO.getCreatorId());
        params.put("modifierId", roleRelationDO.getModifierId());
        params.put("roleId", roleRelationDO.getRoleId());
        params.put("relatedId", roleRelationDO.getRelatedId());
        params.put("relatedType", roleRelationDO.getRelatedType());
        params.put("relationData", roleRelationDO.getRelationData());
        params.put("relation", roleRelationDO.getRelation());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<RoleRelationDO> list = getSqlMapClientTemplate().queryForList("RoleRelation.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(RoleRelationDO roleRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("RoleRelation.deleteByExample", roleRelationDO);
        return count;
    }









}
