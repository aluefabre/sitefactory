package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class SiteRelationDAOImpl extends SqlMapClientDaoSupport implements SiteRelationDAO {

    public java.lang.Long insert(SiteRelationDO siteRelationDO) {
        Object id = getSqlMapClientTemplate().insert("SiteRelation.insert", siteRelationDO);
        return (java.lang.Long) id;
    }


    public Integer update(SiteRelationDO siteRelationDO) {
        int result = getSqlMapClientTemplate().update("SiteRelation.update", siteRelationDO);
        return result;
    }


    public SiteRelationDO findByPrimaryKey(java.lang.Long id) {
        SiteRelationDO siteRelationDO = (SiteRelationDO) getSqlMapClientTemplate().queryForObject("SiteRelation.findByPrimaryKey", id);
        return siteRelationDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("SiteRelation.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(SiteRelationDO siteRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("SiteRelation.countByExample", siteRelationDO);
        return count;
    }


    public List<SiteRelationDO> listByExample(SiteRelationDO siteRelationDO) {
        List<SiteRelationDO> list = getSqlMapClientTemplate().queryForList("SiteRelation.listByExample", siteRelationDO);
        return list;
    }


    public List<SiteRelationDO> pageByExample(SiteRelationDO siteRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", siteRelationDO.getId());
        params.put("gmtCreate", siteRelationDO.getGmtCreate());
        params.put("gmtModify", siteRelationDO.getGmtModify());
        params.put("creatorId", siteRelationDO.getCreatorId());
        params.put("modifierId", siteRelationDO.getModifierId());
        params.put("siteId", siteRelationDO.getSiteId());
        params.put("relatedId", siteRelationDO.getRelatedId());
        params.put("relation", siteRelationDO.getRelation());
        params.put("relatedType", siteRelationDO.getRelatedType());
        params.put("relationData", siteRelationDO.getRelationData());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<SiteRelationDO> list = getSqlMapClientTemplate().queryForList("SiteRelation.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(SiteRelationDO siteRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("SiteRelation.deleteByExample", siteRelationDO);
        return count;
    }









}
