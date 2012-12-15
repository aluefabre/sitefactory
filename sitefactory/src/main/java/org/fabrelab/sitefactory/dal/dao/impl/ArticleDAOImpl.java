package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class ArticleDAOImpl extends SqlMapClientDaoSupport implements ArticleDAO {

    public java.lang.Long insert(ArticleDO articleDO) {
        Object id = getSqlMapClientTemplate().insert("Article.insert", articleDO);
        return (java.lang.Long) id;
    }


    public Integer update(ArticleDO articleDO) {
        int result = getSqlMapClientTemplate().update("Article.update", articleDO);
        return result;
    }


    public ArticleDO findByPrimaryKey(java.lang.Long id) {
        ArticleDO articleDO = (ArticleDO) getSqlMapClientTemplate().queryForObject("Article.findByPrimaryKey", id);
        return articleDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("Article.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(ArticleDO articleDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Article.countByExample", articleDO);
        return count;
    }


    public List<ArticleDO> listByExample(ArticleDO articleDO) {
        List<ArticleDO> list = getSqlMapClientTemplate().queryForList("Article.listByExample", articleDO);
        return list;
    }


    public List<ArticleDO> pageByExample(ArticleDO articleDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", articleDO.getId());
        params.put("gmtCreate", articleDO.getGmtCreate());
        params.put("gmtModify", articleDO.getGmtModify());
        params.put("creatorId", articleDO.getCreatorId());
        params.put("modifierId", articleDO.getModifierId());
        params.put("title", articleDO.getTitle());
        params.put("contentId", articleDO.getContentId());
        params.put("type", articleDO.getType());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<ArticleDO> list = getSqlMapClientTemplate().queryForList("Article.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(ArticleDO articleDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Article.deleteByExample", articleDO);
        return count;
    }


    public List<ArticleDO> listByRelation(ArticleRelationDO articleRelationDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", articleRelationDO.getRelation()); 
        params.put("relatedType", articleRelationDO.getRelatedType()); 
        params.put("relatedId", articleRelationDO.getRelatedId()); 
        List<ArticleDO> list = getSqlMapClientTemplate().queryForList("Article.listByRelation", params);
        return list;
    }


    public List<ArticleDO> pageByRelation(ArticleRelationDO articleRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", articleRelationDO.getRelation()); 
        params.put("relatedType", articleRelationDO.getRelatedType()); 
        params.put("relatedId", articleRelationDO.getRelatedId()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<ArticleDO> list = getSqlMapClientTemplate().queryForList("Article.pageByRelation", params);
        return list;
    }


    public List<ArticleDO> pageByRelationAndExample(ArticleRelationDO articleRelationDO, ArticleDO articleDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", articleRelationDO.getRelation()); 
        params.put("relatedType", articleRelationDO.getRelatedType()); 
        params.put("relatedId", articleRelationDO.getRelatedId()); 
        params.put("id", articleDO.getId()); 
        params.put("gmtCreate", articleDO.getGmtCreate()); 
        params.put("gmtModify", articleDO.getGmtModify()); 
        params.put("creatorId", articleDO.getCreatorId()); 
        params.put("modifierId", articleDO.getModifierId()); 
        params.put("title", articleDO.getTitle()); 
        params.put("contentId", articleDO.getContentId()); 
        params.put("type", articleDO.getType()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<ArticleDO> list = getSqlMapClientTemplate().queryForList("Article.pageByRelationAndExample", params);
        return list;
    }


    public List<ArticleDO> listByRelationAndExample(ArticleRelationDO articleRelationDO, ArticleDO articleDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", articleRelationDO.getRelation()); 
        params.put("relatedType", articleRelationDO.getRelatedType()); 
        params.put("relatedId", articleRelationDO.getRelatedId()); 
        params.put("id", articleDO.getId()); 
        params.put("gmtCreate", articleDO.getGmtCreate()); 
        params.put("gmtModify", articleDO.getGmtModify()); 
        params.put("creatorId", articleDO.getCreatorId()); 
        params.put("modifierId", articleDO.getModifierId()); 
        params.put("title", articleDO.getTitle()); 
        params.put("contentId", articleDO.getContentId()); 
        params.put("type", articleDO.getType()); 
        List<ArticleDO> list = getSqlMapClientTemplate().queryForList("Article.listByRelationAndExample", params);
        return list;
    }

}
