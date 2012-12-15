package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class UserPermissionDAOImpl extends SqlMapClientDaoSupport implements UserPermissionDAO {

    public java.lang.Long insert(UserPermissionDO userPermissionDO) {
        Object id = getSqlMapClientTemplate().insert("UserPermission.insert", userPermissionDO);
        return (java.lang.Long) id;
    }


    public Integer update(UserPermissionDO userPermissionDO) {
        int result = getSqlMapClientTemplate().update("UserPermission.update", userPermissionDO);
        return result;
    }


    public UserPermissionDO findByPrimaryKey(java.lang.Long id) {
        UserPermissionDO userPermissionDO = (UserPermissionDO) getSqlMapClientTemplate().queryForObject("UserPermission.findByPrimaryKey", id);
        return userPermissionDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("UserPermission.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(UserPermissionDO userPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("UserPermission.countByExample", userPermissionDO);
        return count;
    }


    public List<UserPermissionDO> listByExample(UserPermissionDO userPermissionDO) {
        List<UserPermissionDO> list = getSqlMapClientTemplate().queryForList("UserPermission.listByExample", userPermissionDO);
        return list;
    }


    public List<UserPermissionDO> pageByExample(UserPermissionDO userPermissionDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", userPermissionDO.getId());
        params.put("userId", userPermissionDO.getUserId());
        params.put("permission", userPermissionDO.getPermission());
        params.put("userCondition", userPermissionDO.getUserCondition());
        params.put("gmtCreate", userPermissionDO.getGmtCreate());
        params.put("gmtModify", userPermissionDO.getGmtModify());
        params.put("creatorId", userPermissionDO.getCreatorId());
        params.put("modifierId", userPermissionDO.getModifierId());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<UserPermissionDO> list = getSqlMapClientTemplate().queryForList("UserPermission.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(UserPermissionDO userPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("UserPermission.deleteByExample", userPermissionDO);
        return count;
    }









}
