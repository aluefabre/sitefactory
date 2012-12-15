package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class AnswerRelationDAOImpl extends SqlMapClientDaoSupport implements AnswerRelationDAO {

    public java.lang.Long insert(AnswerRelationDO answerRelationDO) {
        Object id = getSqlMapClientTemplate().insert("AnswerRelation.insert", answerRelationDO);
        return (java.lang.Long) id;
    }


    public Integer update(AnswerRelationDO answerRelationDO) {
        int result = getSqlMapClientTemplate().update("AnswerRelation.update", answerRelationDO);
        return result;
    }


    public AnswerRelationDO findByPrimaryKey(java.lang.Long id) {
        AnswerRelationDO answerRelationDO = (AnswerRelationDO) getSqlMapClientTemplate().queryForObject("AnswerRelation.findByPrimaryKey", id);
        return answerRelationDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("AnswerRelation.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(AnswerRelationDO answerRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("AnswerRelation.countByExample", answerRelationDO);
        return count;
    }


    public List<AnswerRelationDO> listByExample(AnswerRelationDO answerRelationDO) {
        List<AnswerRelationDO> list = getSqlMapClientTemplate().queryForList("AnswerRelation.listByExample", answerRelationDO);
        return list;
    }


    public List<AnswerRelationDO> pageByExample(AnswerRelationDO answerRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", answerRelationDO.getId());
        params.put("gmtCreate", answerRelationDO.getGmtCreate());
        params.put("gmtModify", answerRelationDO.getGmtModify());
        params.put("creatorId", answerRelationDO.getCreatorId());
        params.put("modifierId", answerRelationDO.getModifierId());
        params.put("relatedId", answerRelationDO.getRelatedId());
        params.put("answerId", answerRelationDO.getAnswerId());
        params.put("relation", answerRelationDO.getRelation());
        params.put("relatedType", answerRelationDO.getRelatedType());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<AnswerRelationDO> list = getSqlMapClientTemplate().queryForList("AnswerRelation.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(AnswerRelationDO answerRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("AnswerRelation.deleteByExample", answerRelationDO);
        return count;
    }









}
