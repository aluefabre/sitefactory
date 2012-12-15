package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class ArticlePermissionDAOImpl extends SqlMapClientDaoSupport implements ArticlePermissionDAO {

    public java.lang.Long insert(ArticlePermissionDO articlePermissionDO) {
        Object id = getSqlMapClientTemplate().insert("ArticlePermission.insert", articlePermissionDO);
        return (java.lang.Long) id;
    }


    public Integer update(ArticlePermissionDO articlePermissionDO) {
        int result = getSqlMapClientTemplate().update("ArticlePermission.update", articlePermissionDO);
        return result;
    }


    public ArticlePermissionDO findByPrimaryKey(java.lang.Long id) {
        ArticlePermissionDO articlePermissionDO = (ArticlePermissionDO) getSqlMapClientTemplate().queryForObject("ArticlePermission.findByPrimaryKey", id);
        return articlePermissionDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("ArticlePermission.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(ArticlePermissionDO articlePermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("ArticlePermission.countByExample", articlePermissionDO);
        return count;
    }


    public List<ArticlePermissionDO> listByExample(ArticlePermissionDO articlePermissionDO) {
        List<ArticlePermissionDO> list = getSqlMapClientTemplate().queryForList("ArticlePermission.listByExample", articlePermissionDO);
        return list;
    }


    public List<ArticlePermissionDO> pageByExample(ArticlePermissionDO articlePermissionDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", articlePermissionDO.getId());
        params.put("contentId", articlePermissionDO.getContentId());
        params.put("permission", articlePermissionDO.getPermission());
        params.put("userCondition", articlePermissionDO.getUserCondition());
        params.put("gmtCreate", articlePermissionDO.getGmtCreate());
        params.put("gmtModify", articlePermissionDO.getGmtModify());
        params.put("creatorId", articlePermissionDO.getCreatorId());
        params.put("modifierId", articlePermissionDO.getModifierId());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<ArticlePermissionDO> list = getSqlMapClientTemplate().queryForList("ArticlePermission.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(ArticlePermissionDO articlePermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("ArticlePermission.deleteByExample", articlePermissionDO);
        return count;
    }









}
