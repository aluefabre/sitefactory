package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class TermHistoryDAOImpl extends SqlMapClientDaoSupport implements TermHistoryDAO {

    public java.lang.Long insert(TermHistoryDO termHistoryDO) {
        Object id = getSqlMapClientTemplate().insert("TermHistory.insert", termHistoryDO);
        return (java.lang.Long) id;
    }


    public Integer update(TermHistoryDO termHistoryDO) {
        int result = getSqlMapClientTemplate().update("TermHistory.update", termHistoryDO);
        return result;
    }


    public TermHistoryDO findByPrimaryKey(java.lang.Long id) {
        TermHistoryDO termHistoryDO = (TermHistoryDO) getSqlMapClientTemplate().queryForObject("TermHistory.findByPrimaryKey", id);
        return termHistoryDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("TermHistory.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(TermHistoryDO termHistoryDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("TermHistory.countByExample", termHistoryDO);
        return count;
    }


    public List<TermHistoryDO> listByExample(TermHistoryDO termHistoryDO) {
        List<TermHistoryDO> list = getSqlMapClientTemplate().queryForList("TermHistory.listByExample", termHistoryDO);
        return list;
    }


    public List<TermHistoryDO> pageByExample(TermHistoryDO termHistoryDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", termHistoryDO.getId());
        params.put("gmtCreate", termHistoryDO.getGmtCreate());
        params.put("gmtModify", termHistoryDO.getGmtModify());
        params.put("creatorId", termHistoryDO.getCreatorId());
        params.put("modifierId", termHistoryDO.getModifierId());
        params.put("title", termHistoryDO.getTitle());
        params.put("content", termHistoryDO.getContent());
        params.put("type", termHistoryDO.getType());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<TermHistoryDO> list = getSqlMapClientTemplate().queryForList("TermHistory.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(TermHistoryDO termHistoryDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("TermHistory.deleteByExample", termHistoryDO);
        return count;
    }


    public List<TermHistoryDO> listByRelation(TermHistoryRelationDO TermHistoryRelationDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", TermHistoryRelationDO.getRelation()); 
        params.put("relatedType", TermHistoryRelationDO.getRelatedType()); 
        params.put("relatedId", TermHistoryRelationDO.getRelatedId()); 
        List<TermHistoryDO> list = getSqlMapClientTemplate().queryForList("TermHistory.listByRelation", params);
        return list;
    }


    public List<TermHistoryDO> pageByRelation(TermHistoryRelationDO TermHistoryRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", TermHistoryRelationDO.getRelation()); 
        params.put("relatedType", TermHistoryRelationDO.getRelatedType()); 
        params.put("relatedId", TermHistoryRelationDO.getRelatedId()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<TermHistoryDO> list = getSqlMapClientTemplate().queryForList("TermHistory.pageByRelation", params);
        return list;
    }


    public List<TermHistoryDO> pageByRelationAndExample(TermHistoryRelationDO TermHistoryRelationDO, TermHistoryDO termHistoryDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", TermHistoryRelationDO.getRelation()); 
        params.put("relatedType", TermHistoryRelationDO.getRelatedType()); 
        params.put("relatedId", TermHistoryRelationDO.getRelatedId()); 
        params.put("id", termHistoryDO.getId()); 
        params.put("gmtCreate", termHistoryDO.getGmtCreate()); 
        params.put("gmtModify", termHistoryDO.getGmtModify()); 
        params.put("creatorId", termHistoryDO.getCreatorId()); 
        params.put("modifierId", termHistoryDO.getModifierId()); 
        params.put("title", termHistoryDO.getTitle()); 
        params.put("content", termHistoryDO.getContent()); 
        params.put("type", termHistoryDO.getType()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<TermHistoryDO> list = getSqlMapClientTemplate().queryForList("TermHistory.pageByRelationAndExample", params);
        return list;
    }


    public List<TermHistoryDO> listByRelationAndExample(TermHistoryRelationDO TermHistoryRelationDO, TermHistoryDO termHistoryDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", TermHistoryRelationDO.getRelation()); 
        params.put("relatedType", TermHistoryRelationDO.getRelatedType()); 
        params.put("relatedId", TermHistoryRelationDO.getRelatedId()); 
        params.put("id", termHistoryDO.getId()); 
        params.put("gmtCreate", termHistoryDO.getGmtCreate()); 
        params.put("gmtModify", termHistoryDO.getGmtModify()); 
        params.put("creatorId", termHistoryDO.getCreatorId()); 
        params.put("modifierId", termHistoryDO.getModifierId()); 
        params.put("title", termHistoryDO.getTitle()); 
        params.put("content", termHistoryDO.getContent()); 
        params.put("type", termHistoryDO.getType()); 
        List<TermHistoryDO> list = getSqlMapClientTemplate().queryForList("TermHistory.listByRelationAndExample", params);
        return list;
    }

}
