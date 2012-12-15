package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class GroupDAOImpl extends SqlMapClientDaoSupport implements GroupDAO {

    public java.lang.Long insert(GroupDO groupDO) {
        Object id = getSqlMapClientTemplate().insert("Group.insert", groupDO);
        return (java.lang.Long) id;
    }


    public Integer update(GroupDO groupDO) {
        int result = getSqlMapClientTemplate().update("Group.update", groupDO);
        return result;
    }


    public GroupDO findByPrimaryKey(java.lang.Long id) {
        GroupDO groupDO = (GroupDO) getSqlMapClientTemplate().queryForObject("Group.findByPrimaryKey", id);
        return groupDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("Group.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(GroupDO groupDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Group.countByExample", groupDO);
        return count;
    }


    public List<GroupDO> listByExample(GroupDO groupDO) {
        List<GroupDO> list = getSqlMapClientTemplate().queryForList("Group.listByExample", groupDO);
        return list;
    }


    public List<GroupDO> pageByExample(GroupDO groupDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", groupDO.getId());
        params.put("gmtCreate", groupDO.getGmtCreate());
        params.put("gmtModify", groupDO.getGmtModify());
        params.put("creatorId", groupDO.getCreatorId());
        params.put("modifierId", groupDO.getModifierId());
        params.put("title", groupDO.getTitle());
        params.put("description", groupDO.getDescription());
        params.put("status", groupDO.getStatus());
        params.put("type", groupDO.getType());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<GroupDO> list = getSqlMapClientTemplate().queryForList("Group.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(GroupDO groupDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Group.deleteByExample", groupDO);
        return count;
    }


    public List<GroupDO> listByRelation(GroupRelationDO groupRelationDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", groupRelationDO.getRelation()); 
        params.put("relatedType", groupRelationDO.getRelatedType()); 
        params.put("relatedId", groupRelationDO.getRelatedId()); 
        List<GroupDO> list = getSqlMapClientTemplate().queryForList("Group.listByRelation", params);
        return list;
    }


    public List<GroupDO> pageByRelation(GroupRelationDO groupRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", groupRelationDO.getRelation()); 
        params.put("relatedType", groupRelationDO.getRelatedType()); 
        params.put("relatedId", groupRelationDO.getRelatedId()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<GroupDO> list = getSqlMapClientTemplate().queryForList("Group.pageByRelation", params);
        return list;
    }


    public List<GroupDO> pageByRelationAndExample(GroupRelationDO groupRelationDO, GroupDO groupDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", groupRelationDO.getRelation()); 
        params.put("relatedType", groupRelationDO.getRelatedType()); 
        params.put("relatedId", groupRelationDO.getRelatedId()); 
        params.put("id", groupDO.getId()); 
        params.put("gmtCreate", groupDO.getGmtCreate()); 
        params.put("gmtModify", groupDO.getGmtModify()); 
        params.put("creatorId", groupDO.getCreatorId()); 
        params.put("modifierId", groupDO.getModifierId()); 
        params.put("title", groupDO.getTitle()); 
        params.put("description", groupDO.getDescription()); 
        params.put("status", groupDO.getStatus()); 
        params.put("type", groupDO.getType()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<GroupDO> list = getSqlMapClientTemplate().queryForList("Group.pageByRelationAndExample", params);
        return list;
    }


    public List<GroupDO> listByRelationAndExample(GroupRelationDO groupRelationDO, GroupDO groupDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", groupRelationDO.getRelation()); 
        params.put("relatedType", groupRelationDO.getRelatedType()); 
        params.put("relatedId", groupRelationDO.getRelatedId()); 
        params.put("id", groupDO.getId()); 
        params.put("gmtCreate", groupDO.getGmtCreate()); 
        params.put("gmtModify", groupDO.getGmtModify()); 
        params.put("creatorId", groupDO.getCreatorId()); 
        params.put("modifierId", groupDO.getModifierId()); 
        params.put("title", groupDO.getTitle()); 
        params.put("description", groupDO.getDescription()); 
        params.put("status", groupDO.getStatus()); 
        params.put("type", groupDO.getType()); 
        List<GroupDO> list = getSqlMapClientTemplate().queryForList("Group.listByRelationAndExample", params);
        return list;
    }

}
