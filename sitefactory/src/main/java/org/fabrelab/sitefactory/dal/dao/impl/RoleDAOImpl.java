package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class RoleDAOImpl extends SqlMapClientDaoSupport implements RoleDAO {

    public java.lang.Long insert(RoleDO roleDO) {
        Object id = getSqlMapClientTemplate().insert("Role.insert", roleDO);
        return (java.lang.Long) id;
    }


    public Integer update(RoleDO roleDO) {
        int result = getSqlMapClientTemplate().update("Role.update", roleDO);
        return result;
    }


    public RoleDO findByPrimaryKey(java.lang.Long id) {
        RoleDO roleDO = (RoleDO) getSqlMapClientTemplate().queryForObject("Role.findByPrimaryKey", id);
        return roleDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("Role.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(RoleDO roleDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Role.countByExample", roleDO);
        return count;
    }


    public List<RoleDO> listByExample(RoleDO roleDO) {
        List<RoleDO> list = getSqlMapClientTemplate().queryForList("Role.listByExample", roleDO);
        return list;
    }


    public List<RoleDO> pageByExample(RoleDO roleDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", roleDO.getId());
        params.put("gmtCreate", roleDO.getGmtCreate());
        params.put("gmtModify", roleDO.getGmtModify());
        params.put("creatorId", roleDO.getCreatorId());
        params.put("modifierId", roleDO.getModifierId());
        params.put("name", roleDO.getName());
        params.put("description", roleDO.getDescription());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<RoleDO> list = getSqlMapClientTemplate().queryForList("Role.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(RoleDO roleDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Role.deleteByExample", roleDO);
        return count;
    }


    public List<RoleDO> listByRelation(RoleRelationDO roleRelationDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", roleRelationDO.getRelation()); 
        params.put("relatedType", roleRelationDO.getRelatedType()); 
        params.put("relatedId", roleRelationDO.getRelatedId()); 
        List<RoleDO> list = getSqlMapClientTemplate().queryForList("Role.listByRelation", params);
        return list;
    }


    public List<RoleDO> pageByRelation(RoleRelationDO roleRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", roleRelationDO.getRelation()); 
        params.put("relatedType", roleRelationDO.getRelatedType()); 
        params.put("relatedId", roleRelationDO.getRelatedId()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<RoleDO> list = getSqlMapClientTemplate().queryForList("Role.pageByRelation", params);
        return list;
    }


    public List<RoleDO> pageByRelationAndExample(RoleRelationDO roleRelationDO, RoleDO roleDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", roleRelationDO.getRelation()); 
        params.put("relatedType", roleRelationDO.getRelatedType()); 
        params.put("relatedId", roleRelationDO.getRelatedId()); 
        params.put("id", roleDO.getId()); 
        params.put("gmtCreate", roleDO.getGmtCreate()); 
        params.put("gmtModify", roleDO.getGmtModify()); 
        params.put("creatorId", roleDO.getCreatorId()); 
        params.put("modifierId", roleDO.getModifierId()); 
        params.put("name", roleDO.getName()); 
        params.put("description", roleDO.getDescription()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<RoleDO> list = getSqlMapClientTemplate().queryForList("Role.pageByRelationAndExample", params);
        return list;
    }


    public List<RoleDO> listByRelationAndExample(RoleRelationDO roleRelationDO, RoleDO roleDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", roleRelationDO.getRelation()); 
        params.put("relatedType", roleRelationDO.getRelatedType()); 
        params.put("relatedId", roleRelationDO.getRelatedId()); 
        params.put("id", roleDO.getId()); 
        params.put("gmtCreate", roleDO.getGmtCreate()); 
        params.put("gmtModify", roleDO.getGmtModify()); 
        params.put("creatorId", roleDO.getCreatorId()); 
        params.put("modifierId", roleDO.getModifierId()); 
        params.put("name", roleDO.getName()); 
        params.put("description", roleDO.getDescription()); 
        List<RoleDO> list = getSqlMapClientTemplate().queryForList("Role.listByRelationAndExample", params);
        return list;
    }

}
