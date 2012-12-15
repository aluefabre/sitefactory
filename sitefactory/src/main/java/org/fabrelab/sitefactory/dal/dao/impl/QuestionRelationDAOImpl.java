package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class QuestionRelationDAOImpl extends SqlMapClientDaoSupport implements QuestionRelationDAO {

    public java.lang.Long insert(QuestionRelationDO questionRelationDO) {
        Object id = getSqlMapClientTemplate().insert("QuestionRelation.insert", questionRelationDO);
        return (java.lang.Long) id;
    }


    public Integer update(QuestionRelationDO questionRelationDO) {
        int result = getSqlMapClientTemplate().update("QuestionRelation.update", questionRelationDO);
        return result;
    }


    public QuestionRelationDO findByPrimaryKey(java.lang.Long id) {
        QuestionRelationDO questionRelationDO = (QuestionRelationDO) getSqlMapClientTemplate().queryForObject("QuestionRelation.findByPrimaryKey", id);
        return questionRelationDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("QuestionRelation.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(QuestionRelationDO questionRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("QuestionRelation.countByExample", questionRelationDO);
        return count;
    }


    public List<QuestionRelationDO> listByExample(QuestionRelationDO questionRelationDO) {
        List<QuestionRelationDO> list = getSqlMapClientTemplate().queryForList("QuestionRelation.listByExample", questionRelationDO);
        return list;
    }


    public List<QuestionRelationDO> pageByExample(QuestionRelationDO questionRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", questionRelationDO.getId());
        params.put("gmtCreate", questionRelationDO.getGmtCreate());
        params.put("gmtModify", questionRelationDO.getGmtModify());
        params.put("creatorId", questionRelationDO.getCreatorId());
        params.put("modifierId", questionRelationDO.getModifierId());
        params.put("relatedId", questionRelationDO.getRelatedId());
        params.put("questionId", questionRelationDO.getQuestionId());
        params.put("relation", questionRelationDO.getRelation());
        params.put("relatedType", questionRelationDO.getRelatedType());
        params.put("relationData", questionRelationDO.getRelationData());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<QuestionRelationDO> list = getSqlMapClientTemplate().queryForList("QuestionRelation.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(QuestionRelationDO questionRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("QuestionRelation.deleteByExample", questionRelationDO);
        return count;
    }









}
