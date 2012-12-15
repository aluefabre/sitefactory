package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class TermDAOImpl extends SqlMapClientDaoSupport implements TermDAO {

    public java.lang.Long insert(TermDO termDO) {
        Object id = getSqlMapClientTemplate().insert("Term.insert", termDO);
        return (java.lang.Long) id;
    }


    public Integer update(TermDO termDO) {
        int result = getSqlMapClientTemplate().update("Term.update", termDO);
        return result;
    }


    public TermDO findByPrimaryKey(java.lang.Long id) {
        TermDO termDO = (TermDO) getSqlMapClientTemplate().queryForObject("Term.findByPrimaryKey", id);
        return termDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("Term.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(TermDO termDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Term.countByExample", termDO);
        return count;
    }


    public List<TermDO> listByExample(TermDO termDO) {
        List<TermDO> list = getSqlMapClientTemplate().queryForList("Term.listByExample", termDO);
        return list;
    }


    public List<TermDO> pageByExample(TermDO termDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", termDO.getId());
        params.put("gmtCreate", termDO.getGmtCreate());
        params.put("gmtModify", termDO.getGmtModify());
        params.put("creatorId", termDO.getCreatorId());
        params.put("modifierId", termDO.getModifierId());
        params.put("title", termDO.getTitle());
        params.put("content", termDO.getContent());
        params.put("type", termDO.getType());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<TermDO> list = getSqlMapClientTemplate().queryForList("Term.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(TermDO termDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Term.deleteByExample", termDO);
        return count;
    }


    public List<TermDO> listByRelation(TermRelationDO termRelationDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", termRelationDO.getRelation()); 
        params.put("relatedType", termRelationDO.getRelatedType()); 
        params.put("relatedId", termRelationDO.getRelatedId()); 
        List<TermDO> list = getSqlMapClientTemplate().queryForList("Term.listByRelation", params);
        return list;
    }


    public List<TermDO> pageByRelation(TermRelationDO termRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", termRelationDO.getRelation()); 
        params.put("relatedType", termRelationDO.getRelatedType()); 
        params.put("relatedId", termRelationDO.getRelatedId()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<TermDO> list = getSqlMapClientTemplate().queryForList("Term.pageByRelation", params);
        return list;
    }


    public List<TermDO> pageByRelationAndExample(TermRelationDO termRelationDO, TermDO termDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", termRelationDO.getRelation()); 
        params.put("relatedType", termRelationDO.getRelatedType()); 
        params.put("relatedId", termRelationDO.getRelatedId()); 
        params.put("id", termDO.getId()); 
        params.put("gmtCreate", termDO.getGmtCreate()); 
        params.put("gmtModify", termDO.getGmtModify()); 
        params.put("creatorId", termDO.getCreatorId()); 
        params.put("modifierId", termDO.getModifierId()); 
        params.put("title", termDO.getTitle()); 
        params.put("content", termDO.getContent()); 
        params.put("type", termDO.getType()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<TermDO> list = getSqlMapClientTemplate().queryForList("Term.pageByRelationAndExample", params);
        return list;
    }


    public List<TermDO> listByRelationAndExample(TermRelationDO termRelationDO, TermDO termDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", termRelationDO.getRelation()); 
        params.put("relatedType", termRelationDO.getRelatedType()); 
        params.put("relatedId", termRelationDO.getRelatedId()); 
        params.put("id", termDO.getId()); 
        params.put("gmtCreate", termDO.getGmtCreate()); 
        params.put("gmtModify", termDO.getGmtModify()); 
        params.put("creatorId", termDO.getCreatorId()); 
        params.put("modifierId", termDO.getModifierId()); 
        params.put("title", termDO.getTitle()); 
        params.put("content", termDO.getContent()); 
        params.put("type", termDO.getType()); 
        List<TermDO> list = getSqlMapClientTemplate().queryForList("Term.listByRelationAndExample", params);
        return list;
    }

}
