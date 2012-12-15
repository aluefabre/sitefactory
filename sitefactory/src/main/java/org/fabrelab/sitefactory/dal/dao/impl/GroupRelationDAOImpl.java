package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class GroupRelationDAOImpl extends SqlMapClientDaoSupport implements GroupRelationDAO {

    public java.lang.Long insert(GroupRelationDO groupRelationDO) {
        Object id = getSqlMapClientTemplate().insert("GroupRelation.insert", groupRelationDO);
        return (java.lang.Long) id;
    }


    public Integer update(GroupRelationDO groupRelationDO) {
        int result = getSqlMapClientTemplate().update("GroupRelation.update", groupRelationDO);
        return result;
    }


    public GroupRelationDO findByPrimaryKey(java.lang.Long id) {
        GroupRelationDO groupRelationDO = (GroupRelationDO) getSqlMapClientTemplate().queryForObject("GroupRelation.findByPrimaryKey", id);
        return groupRelationDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("GroupRelation.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(GroupRelationDO groupRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("GroupRelation.countByExample", groupRelationDO);
        return count;
    }


    public List<GroupRelationDO> listByExample(GroupRelationDO groupRelationDO) {
        List<GroupRelationDO> list = getSqlMapClientTemplate().queryForList("GroupRelation.listByExample", groupRelationDO);
        return list;
    }


    public List<GroupRelationDO> pageByExample(GroupRelationDO groupRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", groupRelationDO.getId());
        params.put("gmtCreate", groupRelationDO.getGmtCreate());
        params.put("gmtModify", groupRelationDO.getGmtModify());
        params.put("creatorId", groupRelationDO.getCreatorId());
        params.put("modifierId", groupRelationDO.getModifierId());
        params.put("groupId", groupRelationDO.getGroupId());
        params.put("relatedId", groupRelationDO.getRelatedId());
        params.put("relation", groupRelationDO.getRelation());
        params.put("relatedType", groupRelationDO.getRelatedType());
        params.put("relationData", groupRelationDO.getRelationData());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<GroupRelationDO> list = getSqlMapClientTemplate().queryForList("GroupRelation.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(GroupRelationDO groupRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("GroupRelation.deleteByExample", groupRelationDO);
        return count;
    }









}
