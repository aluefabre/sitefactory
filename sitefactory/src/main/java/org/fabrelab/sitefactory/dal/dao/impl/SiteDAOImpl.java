package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class SiteDAOImpl extends SqlMapClientDaoSupport implements SiteDAO {

    public java.lang.Long insert(SiteDO siteDO) {
        Object id = getSqlMapClientTemplate().insert("Site.insert", siteDO);
        return (java.lang.Long) id;
    }


    public Integer update(SiteDO siteDO) {
        int result = getSqlMapClientTemplate().update("Site.update", siteDO);
        return result;
    }


    public SiteDO findByPrimaryKey(java.lang.Long id) {
        SiteDO siteDO = (SiteDO) getSqlMapClientTemplate().queryForObject("Site.findByPrimaryKey", id);
        return siteDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("Site.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(SiteDO siteDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Site.countByExample", siteDO);
        return count;
    }


    public List<SiteDO> listByExample(SiteDO siteDO) {
        List<SiteDO> list = getSqlMapClientTemplate().queryForList("Site.listByExample", siteDO);
        return list;
    }


    public List<SiteDO> pageByExample(SiteDO siteDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", siteDO.getId());
        params.put("gmtCreate", siteDO.getGmtCreate());
        params.put("gmtModify", siteDO.getGmtModify());
        params.put("creatorId", siteDO.getCreatorId());
        params.put("modifierId", siteDO.getModifierId());
        params.put("title", siteDO.getTitle());
        params.put("description", siteDO.getDescription());
        params.put("status", siteDO.getStatus());
        params.put("type", siteDO.getType());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<SiteDO> list = getSqlMapClientTemplate().queryForList("Site.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(SiteDO siteDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Site.deleteByExample", siteDO);
        return count;
    }


    public List<SiteDO> listByRelation(SiteRelationDO siteRelationDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", siteRelationDO.getRelation()); 
        params.put("relatedType", siteRelationDO.getRelatedType()); 
        params.put("relatedId", siteRelationDO.getRelatedId()); 
        List<SiteDO> list = getSqlMapClientTemplate().queryForList("Site.listByRelation", params);
        return list;
    }


    public List<SiteDO> pageByRelation(SiteRelationDO siteRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", siteRelationDO.getRelation()); 
        params.put("relatedType", siteRelationDO.getRelatedType()); 
        params.put("relatedId", siteRelationDO.getRelatedId()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<SiteDO> list = getSqlMapClientTemplate().queryForList("Site.pageByRelation", params);
        return list;
    }


    public List<SiteDO> pageByRelationAndExample(SiteRelationDO siteRelationDO, SiteDO siteDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", siteRelationDO.getRelation()); 
        params.put("relatedType", siteRelationDO.getRelatedType()); 
        params.put("relatedId", siteRelationDO.getRelatedId()); 
        params.put("id", siteDO.getId()); 
        params.put("gmtCreate", siteDO.getGmtCreate()); 
        params.put("gmtModify", siteDO.getGmtModify()); 
        params.put("creatorId", siteDO.getCreatorId()); 
        params.put("modifierId", siteDO.getModifierId()); 
        params.put("title", siteDO.getTitle()); 
        params.put("description", siteDO.getDescription()); 
        params.put("status", siteDO.getStatus()); 
        params.put("type", siteDO.getType()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<SiteDO> list = getSqlMapClientTemplate().queryForList("Site.pageByRelationAndExample", params);
        return list;
    }


    public List<SiteDO> listByRelationAndExample(SiteRelationDO siteRelationDO, SiteDO siteDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", siteRelationDO.getRelation()); 
        params.put("relatedType", siteRelationDO.getRelatedType()); 
        params.put("relatedId", siteRelationDO.getRelatedId()); 
        params.put("id", siteDO.getId()); 
        params.put("gmtCreate", siteDO.getGmtCreate()); 
        params.put("gmtModify", siteDO.getGmtModify()); 
        params.put("creatorId", siteDO.getCreatorId()); 
        params.put("modifierId", siteDO.getModifierId()); 
        params.put("title", siteDO.getTitle()); 
        params.put("description", siteDO.getDescription()); 
        params.put("status", siteDO.getStatus()); 
        params.put("type", siteDO.getType()); 
        List<SiteDO> list = getSqlMapClientTemplate().queryForList("Site.listByRelationAndExample", params);
        return list;
    }

}
