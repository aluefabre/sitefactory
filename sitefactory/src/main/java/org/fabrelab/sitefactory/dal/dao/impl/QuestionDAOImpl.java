package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class QuestionDAOImpl extends SqlMapClientDaoSupport implements QuestionDAO {

    public java.lang.Long insert(QuestionDO questionDO) {
        Object id = getSqlMapClientTemplate().insert("Question.insert", questionDO);
        return (java.lang.Long) id;
    }


    public Integer update(QuestionDO questionDO) {
        int result = getSqlMapClientTemplate().update("Question.update", questionDO);
        return result;
    }


    public QuestionDO findByPrimaryKey(java.lang.Long id) {
        QuestionDO questionDO = (QuestionDO) getSqlMapClientTemplate().queryForObject("Question.findByPrimaryKey", id);
        return questionDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("Question.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(QuestionDO questionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Question.countByExample", questionDO);
        return count;
    }


    public List<QuestionDO> listByExample(QuestionDO questionDO) {
        List<QuestionDO> list = getSqlMapClientTemplate().queryForList("Question.listByExample", questionDO);
        return list;
    }


    public List<QuestionDO> pageByExample(QuestionDO questionDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", questionDO.getId());
        params.put("gmtCreate", questionDO.getGmtCreate());
        params.put("gmtModify", questionDO.getGmtModify());
        params.put("creatorId", questionDO.getCreatorId());
        params.put("modifierId", questionDO.getModifierId());
        params.put("title", questionDO.getTitle());
        params.put("content", questionDO.getContent());
        params.put("type", questionDO.getType());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<QuestionDO> list = getSqlMapClientTemplate().queryForList("Question.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(QuestionDO questionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Question.deleteByExample", questionDO);
        return count;
    }


    public List<QuestionDO> listByRelation(QuestionRelationDO questionRelationDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", questionRelationDO.getRelation()); 
        params.put("relatedType", questionRelationDO.getRelatedType()); 
        params.put("relatedId", questionRelationDO.getRelatedId()); 
        List<QuestionDO> list = getSqlMapClientTemplate().queryForList("Question.listByRelation", params);
        return list;
    }


    public List<QuestionDO> pageByRelation(QuestionRelationDO questionRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", questionRelationDO.getRelation()); 
        params.put("relatedType", questionRelationDO.getRelatedType()); 
        params.put("relatedId", questionRelationDO.getRelatedId()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<QuestionDO> list = getSqlMapClientTemplate().queryForList("Question.pageByRelation", params);
        return list;
    }


    public List<QuestionDO> pageByRelationAndExample(QuestionRelationDO questionRelationDO, QuestionDO questionDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", questionRelationDO.getRelation()); 
        params.put("relatedType", questionRelationDO.getRelatedType()); 
        params.put("relatedId", questionRelationDO.getRelatedId()); 
        params.put("id", questionDO.getId()); 
        params.put("gmtCreate", questionDO.getGmtCreate()); 
        params.put("gmtModify", questionDO.getGmtModify()); 
        params.put("creatorId", questionDO.getCreatorId()); 
        params.put("modifierId", questionDO.getModifierId()); 
        params.put("title", questionDO.getTitle()); 
        params.put("content", questionDO.getContent()); 
        params.put("type", questionDO.getType()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<QuestionDO> list = getSqlMapClientTemplate().queryForList("Question.pageByRelationAndExample", params);
        return list;
    }


    public List<QuestionDO> listByRelationAndExample(QuestionRelationDO questionRelationDO, QuestionDO questionDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", questionRelationDO.getRelation()); 
        params.put("relatedType", questionRelationDO.getRelatedType()); 
        params.put("relatedId", questionRelationDO.getRelatedId()); 
        params.put("id", questionDO.getId()); 
        params.put("gmtCreate", questionDO.getGmtCreate()); 
        params.put("gmtModify", questionDO.getGmtModify()); 
        params.put("creatorId", questionDO.getCreatorId()); 
        params.put("modifierId", questionDO.getModifierId()); 
        params.put("title", questionDO.getTitle()); 
        params.put("content", questionDO.getContent()); 
        params.put("type", questionDO.getType()); 
        List<QuestionDO> list = getSqlMapClientTemplate().queryForList("Question.listByRelationAndExample", params);
        return list;
    }

}
