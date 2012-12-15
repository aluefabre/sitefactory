package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class SitePermissionDAOImpl extends SqlMapClientDaoSupport implements SitePermissionDAO {

    public java.lang.Long insert(SitePermissionDO sitePermissionDO) {
        Object id = getSqlMapClientTemplate().insert("SitePermission.insert", sitePermissionDO);
        return (java.lang.Long) id;
    }


    public Integer update(SitePermissionDO sitePermissionDO) {
        int result = getSqlMapClientTemplate().update("SitePermission.update", sitePermissionDO);
        return result;
    }


    public SitePermissionDO findByPrimaryKey(java.lang.Long id) {
        SitePermissionDO sitePermissionDO = (SitePermissionDO) getSqlMapClientTemplate().queryForObject("SitePermission.findByPrimaryKey", id);
        return sitePermissionDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("SitePermission.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(SitePermissionDO sitePermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("SitePermission.countByExample", sitePermissionDO);
        return count;
    }


    public List<SitePermissionDO> listByExample(SitePermissionDO sitePermissionDO) {
        List<SitePermissionDO> list = getSqlMapClientTemplate().queryForList("SitePermission.listByExample", sitePermissionDO);
        return list;
    }


    public List<SitePermissionDO> pageByExample(SitePermissionDO sitePermissionDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", sitePermissionDO.getId());
        params.put("siteId", sitePermissionDO.getSiteId());
        params.put("permission", sitePermissionDO.getPermission());
        params.put("userCondition", sitePermissionDO.getUserCondition());
        params.put("gmtCreate", sitePermissionDO.getGmtCreate());
        params.put("gmtModify", sitePermissionDO.getGmtModify());
        params.put("creatorId", sitePermissionDO.getCreatorId());
        params.put("modifierId", sitePermissionDO.getModifierId());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<SitePermissionDO> list = getSqlMapClientTemplate().queryForList("SitePermission.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(SitePermissionDO sitePermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("SitePermission.deleteByExample", sitePermissionDO);
        return count;
    }









}
