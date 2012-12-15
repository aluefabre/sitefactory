package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class AnswerDAOImpl extends SqlMapClientDaoSupport implements AnswerDAO {

    public java.lang.Long insert(AnswerDO answerDO) {
        Object id = getSqlMapClientTemplate().insert("Answer.insert", answerDO);
        return (java.lang.Long) id;
    }


    public Integer update(AnswerDO answerDO) {
        int result = getSqlMapClientTemplate().update("Answer.update", answerDO);
        return result;
    }


    public AnswerDO findByPrimaryKey(java.lang.Long id) {
        AnswerDO answerDO = (AnswerDO) getSqlMapClientTemplate().queryForObject("Answer.findByPrimaryKey", id);
        return answerDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("Answer.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(AnswerDO answerDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Answer.countByExample", answerDO);
        return count;
    }


    public List<AnswerDO> listByExample(AnswerDO answerDO) {
        List<AnswerDO> list = getSqlMapClientTemplate().queryForList("Answer.listByExample", answerDO);
        return list;
    }


    public List<AnswerDO> pageByExample(AnswerDO answerDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", answerDO.getId());
        params.put("gmtCreate", answerDO.getGmtCreate());
        params.put("gmtModify", answerDO.getGmtModify());
        params.put("creatorId", answerDO.getCreatorId());
        params.put("modifierId", answerDO.getModifierId());
        params.put("title", answerDO.getTitle());
        params.put("content", answerDO.getContent());
        params.put("type", answerDO.getType());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<AnswerDO> list = getSqlMapClientTemplate().queryForList("Answer.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(AnswerDO answerDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Answer.deleteByExample", answerDO);
        return count;
    }


    public List<AnswerDO> listByRelation(AnswerRelationDO answerRelationDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", answerRelationDO.getRelation()); 
        params.put("relatedType", answerRelationDO.getRelatedType()); 
        params.put("relatedId", answerRelationDO.getRelatedId()); 
        List<AnswerDO> list = getSqlMapClientTemplate().queryForList("Answer.listByRelation", params);
        return list;
    }


    public List<AnswerDO> pageByRelation(AnswerRelationDO answerRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", answerRelationDO.getRelation()); 
        params.put("relatedType", answerRelationDO.getRelatedType()); 
        params.put("relatedId", answerRelationDO.getRelatedId()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<AnswerDO> list = getSqlMapClientTemplate().queryForList("Answer.pageByRelation", params);
        return list;
    }


    public List<AnswerDO> pageByRelationAndExample(AnswerRelationDO answerRelationDO, AnswerDO answerDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", answerRelationDO.getRelation()); 
        params.put("relatedType", answerRelationDO.getRelatedType()); 
        params.put("relatedId", answerRelationDO.getRelatedId()); 
        params.put("id", answerDO.getId()); 
        params.put("gmtCreate", answerDO.getGmtCreate()); 
        params.put("gmtModify", answerDO.getGmtModify()); 
        params.put("creatorId", answerDO.getCreatorId()); 
        params.put("modifierId", answerDO.getModifierId()); 
        params.put("title", answerDO.getTitle()); 
        params.put("content", answerDO.getContent()); 
        params.put("type", answerDO.getType()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<AnswerDO> list = getSqlMapClientTemplate().queryForList("Answer.pageByRelationAndExample", params);
        return list;
    }


    public List<AnswerDO> listByRelationAndExample(AnswerRelationDO answerRelationDO, AnswerDO answerDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", answerRelationDO.getRelation()); 
        params.put("relatedType", answerRelationDO.getRelatedType()); 
        params.put("relatedId", answerRelationDO.getRelatedId()); 
        params.put("id", answerDO.getId()); 
        params.put("gmtCreate", answerDO.getGmtCreate()); 
        params.put("gmtModify", answerDO.getGmtModify()); 
        params.put("creatorId", answerDO.getCreatorId()); 
        params.put("modifierId", answerDO.getModifierId()); 
        params.put("title", answerDO.getTitle()); 
        params.put("content", answerDO.getContent()); 
        params.put("type", answerDO.getType()); 
        List<AnswerDO> list = getSqlMapClientTemplate().queryForList("Answer.listByRelationAndExample", params);
        return list;
    }

}
