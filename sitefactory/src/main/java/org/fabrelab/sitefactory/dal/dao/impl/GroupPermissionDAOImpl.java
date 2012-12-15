package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class GroupPermissionDAOImpl extends SqlMapClientDaoSupport implements GroupPermissionDAO {

    public java.lang.Long insert(GroupPermissionDO groupPermissionDO) {
        Object id = getSqlMapClientTemplate().insert("GroupPermission.insert", groupPermissionDO);
        return (java.lang.Long) id;
    }


    public Integer update(GroupPermissionDO groupPermissionDO) {
        int result = getSqlMapClientTemplate().update("GroupPermission.update", groupPermissionDO);
        return result;
    }


    public GroupPermissionDO findByPrimaryKey(java.lang.Long id) {
        GroupPermissionDO groupPermissionDO = (GroupPermissionDO) getSqlMapClientTemplate().queryForObject("GroupPermission.findByPrimaryKey", id);
        return groupPermissionDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("GroupPermission.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(GroupPermissionDO groupPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("GroupPermission.countByExample", groupPermissionDO);
        return count;
    }


    public List<GroupPermissionDO> listByExample(GroupPermissionDO groupPermissionDO) {
        List<GroupPermissionDO> list = getSqlMapClientTemplate().queryForList("GroupPermission.listByExample", groupPermissionDO);
        return list;
    }


    public List<GroupPermissionDO> pageByExample(GroupPermissionDO groupPermissionDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", groupPermissionDO.getId());
        params.put("groupId", groupPermissionDO.getGroupId());
        params.put("permission", groupPermissionDO.getPermission());
        params.put("userCondition", groupPermissionDO.getUserCondition());
        params.put("gmtCreate", groupPermissionDO.getGmtCreate());
        params.put("gmtModify", groupPermissionDO.getGmtModify());
        params.put("creatorId", groupPermissionDO.getCreatorId());
        params.put("modifierId", groupPermissionDO.getModifierId());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<GroupPermissionDO> list = getSqlMapClientTemplate().queryForList("GroupPermission.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(GroupPermissionDO groupPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("GroupPermission.deleteByExample", groupPermissionDO);
        return count;
    }









}
