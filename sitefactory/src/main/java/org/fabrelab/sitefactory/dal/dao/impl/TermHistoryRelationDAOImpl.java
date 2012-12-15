package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class TermHistoryRelationDAOImpl extends SqlMapClientDaoSupport implements TermHistoryRelationDAO {

    public java.lang.Long insert(TermHistoryRelationDO termHistoryRelationDO) {
        Object id = getSqlMapClientTemplate().insert("TermHistoryRelation.insert", termHistoryRelationDO);
        return (java.lang.Long) id;
    }


    public Integer update(TermHistoryRelationDO termHistoryRelationDO) {
        int result = getSqlMapClientTemplate().update("TermHistoryRelation.update", termHistoryRelationDO);
        return result;
    }


    public TermHistoryRelationDO findByPrimaryKey(java.lang.Long id) {
        TermHistoryRelationDO termHistoryRelationDO = (TermHistoryRelationDO) getSqlMapClientTemplate().queryForObject("TermHistoryRelation.findByPrimaryKey", id);
        return termHistoryRelationDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("TermHistoryRelation.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(TermHistoryRelationDO termHistoryRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("TermHistoryRelation.countByExample", termHistoryRelationDO);
        return count;
    }


    public List<TermHistoryRelationDO> listByExample(TermHistoryRelationDO termHistoryRelationDO) {
        List<TermHistoryRelationDO> list = getSqlMapClientTemplate().queryForList("TermHistoryRelation.listByExample", termHistoryRelationDO);
        return list;
    }


    public List<TermHistoryRelationDO> pageByExample(TermHistoryRelationDO termHistoryRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", termHistoryRelationDO.getId());
        params.put("gmtCreate", termHistoryRelationDO.getGmtCreate());
        params.put("gmtModify", termHistoryRelationDO.getGmtModify());
        params.put("creatorId", termHistoryRelationDO.getCreatorId());
        params.put("modifierId", termHistoryRelationDO.getModifierId());
        params.put("relatedId", termHistoryRelationDO.getRelatedId());
        params.put("termHistoryId", termHistoryRelationDO.getTermHistoryId());
        params.put("relation", termHistoryRelationDO.getRelation());
        params.put("relatedType", termHistoryRelationDO.getRelatedType());
        params.put("relationData", termHistoryRelationDO.getRelationData());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<TermHistoryRelationDO> list = getSqlMapClientTemplate().queryForList("TermHistoryRelation.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(TermHistoryRelationDO termHistoryRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("TermHistoryRelation.deleteByExample", termHistoryRelationDO);
        return count;
    }









}
