package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class RolePermissionDAOImpl extends SqlMapClientDaoSupport implements RolePermissionDAO {

    public java.lang.Long insert(RolePermissionDO rolePermissionDO) {
        Object id = getSqlMapClientTemplate().insert("RolePermission.insert", rolePermissionDO);
        return (java.lang.Long) id;
    }


    public Integer update(RolePermissionDO rolePermissionDO) {
        int result = getSqlMapClientTemplate().update("RolePermission.update", rolePermissionDO);
        return result;
    }


    public RolePermissionDO findByPrimaryKey(java.lang.Long id) {
        RolePermissionDO rolePermissionDO = (RolePermissionDO) getSqlMapClientTemplate().queryForObject("RolePermission.findByPrimaryKey", id);
        return rolePermissionDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("RolePermission.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(RolePermissionDO rolePermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("RolePermission.countByExample", rolePermissionDO);
        return count;
    }


    public List<RolePermissionDO> listByExample(RolePermissionDO rolePermissionDO) {
        List<RolePermissionDO> list = getSqlMapClientTemplate().queryForList("RolePermission.listByExample", rolePermissionDO);
        return list;
    }


    public List<RolePermissionDO> pageByExample(RolePermissionDO rolePermissionDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", rolePermissionDO.getId());
        params.put("roleId", rolePermissionDO.getRoleId());
        params.put("permission", rolePermissionDO.getPermission());
        params.put("userCondition", rolePermissionDO.getUserCondition());
        params.put("gmtCreate", rolePermissionDO.getGmtCreate());
        params.put("gmtModify", rolePermissionDO.getGmtModify());
        params.put("creatorId", rolePermissionDO.getCreatorId());
        params.put("modifierId", rolePermissionDO.getModifierId());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<RolePermissionDO> list = getSqlMapClientTemplate().queryForList("RolePermission.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(RolePermissionDO rolePermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("RolePermission.deleteByExample", rolePermissionDO);
        return count;
    }









}
