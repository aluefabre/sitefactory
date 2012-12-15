package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class ArticleRelationDAOImpl extends SqlMapClientDaoSupport implements ArticleRelationDAO {

    public java.lang.Long insert(ArticleRelationDO articleRelationDO) {
        Object id = getSqlMapClientTemplate().insert("ArticleRelation.insert", articleRelationDO);
        return (java.lang.Long) id;
    }


    public Integer update(ArticleRelationDO articleRelationDO) {
        int result = getSqlMapClientTemplate().update("ArticleRelation.update", articleRelationDO);
        return result;
    }


    public ArticleRelationDO findByPrimaryKey(java.lang.Long id) {
        ArticleRelationDO articleRelationDO = (ArticleRelationDO) getSqlMapClientTemplate().queryForObject("ArticleRelation.findByPrimaryKey", id);
        return articleRelationDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("ArticleRelation.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(ArticleRelationDO articleRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("ArticleRelation.countByExample", articleRelationDO);
        return count;
    }


    public List<ArticleRelationDO> listByExample(ArticleRelationDO articleRelationDO) {
        List<ArticleRelationDO> list = getSqlMapClientTemplate().queryForList("ArticleRelation.listByExample", articleRelationDO);
        return list;
    }


    public List<ArticleRelationDO> pageByExample(ArticleRelationDO articleRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", articleRelationDO.getId());
        params.put("gmtCreate", articleRelationDO.getGmtCreate());
        params.put("gmtModify", articleRelationDO.getGmtModify());
        params.put("creatorId", articleRelationDO.getCreatorId());
        params.put("modifierId", articleRelationDO.getModifierId());
        params.put("relatedId", articleRelationDO.getRelatedId());
        params.put("articleId", articleRelationDO.getArticleId());
        params.put("relation", articleRelationDO.getRelation());
        params.put("relatedType", articleRelationDO.getRelatedType());
        params.put("relationData", articleRelationDO.getRelationData());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<ArticleRelationDO> list = getSqlMapClientTemplate().queryForList("ArticleRelation.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(ArticleRelationDO articleRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("ArticleRelation.deleteByExample", articleRelationDO);
        return count;
    }









}
