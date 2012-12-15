package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class TermRelationDAOImpl extends SqlMapClientDaoSupport implements TermRelationDAO {

    public java.lang.Long insert(TermRelationDO termRelationDO) {
        Object id = getSqlMapClientTemplate().insert("TermRelation.insert", termRelationDO);
        return (java.lang.Long) id;
    }


    public Integer update(TermRelationDO termRelationDO) {
        int result = getSqlMapClientTemplate().update("TermRelation.update", termRelationDO);
        return result;
    }


    public TermRelationDO findByPrimaryKey(java.lang.Long id) {
        TermRelationDO termRelationDO = (TermRelationDO) getSqlMapClientTemplate().queryForObject("TermRelation.findByPrimaryKey", id);
        return termRelationDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("TermRelation.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(TermRelationDO termRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("TermRelation.countByExample", termRelationDO);
        return count;
    }


    public List<TermRelationDO> listByExample(TermRelationDO termRelationDO) {
        List<TermRelationDO> list = getSqlMapClientTemplate().queryForList("TermRelation.listByExample", termRelationDO);
        return list;
    }


    public List<TermRelationDO> pageByExample(TermRelationDO termRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", termRelationDO.getId());
        params.put("gmtCreate", termRelationDO.getGmtCreate());
        params.put("gmtModify", termRelationDO.getGmtModify());
        params.put("creatorId", termRelationDO.getCreatorId());
        params.put("modifierId", termRelationDO.getModifierId());
        params.put("relatedId", termRelationDO.getRelatedId());
        params.put("termId", termRelationDO.getTermId());
        params.put("relation", termRelationDO.getRelation());
        params.put("relatedType", termRelationDO.getRelatedType());
        params.put("relationData", termRelationDO.getRelationData());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<TermRelationDO> list = getSqlMapClientTemplate().queryForList("TermRelation.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(TermRelationDO termRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("TermRelation.deleteByExample", termRelationDO);
        return count;
    }









}
