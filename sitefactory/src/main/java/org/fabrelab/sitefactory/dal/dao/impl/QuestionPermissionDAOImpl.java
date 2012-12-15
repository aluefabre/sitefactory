package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class QuestionPermissionDAOImpl extends SqlMapClientDaoSupport implements QuestionPermissionDAO {

    public java.lang.Long insert(QuestionPermissionDO questionPermissionDO) {
        Object id = getSqlMapClientTemplate().insert("QuestionPermission.insert", questionPermissionDO);
        return (java.lang.Long) id;
    }


    public Integer update(QuestionPermissionDO questionPermissionDO) {
        int result = getSqlMapClientTemplate().update("QuestionPermission.update", questionPermissionDO);
        return result;
    }


    public QuestionPermissionDO findByPrimaryKey(java.lang.Long id) {
        QuestionPermissionDO questionPermissionDO = (QuestionPermissionDO) getSqlMapClientTemplate().queryForObject("QuestionPermission.findByPrimaryKey", id);
        return questionPermissionDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("QuestionPermission.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(QuestionPermissionDO questionPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("QuestionPermission.countByExample", questionPermissionDO);
        return count;
    }


    public List<QuestionPermissionDO> listByExample(QuestionPermissionDO questionPermissionDO) {
        List<QuestionPermissionDO> list = getSqlMapClientTemplate().queryForList("QuestionPermission.listByExample", questionPermissionDO);
        return list;
    }


    public List<QuestionPermissionDO> pageByExample(QuestionPermissionDO questionPermissionDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", questionPermissionDO.getId());
        params.put("questionId", questionPermissionDO.getQuestionId());
        params.put("permission", questionPermissionDO.getPermission());
        params.put("userCondition", questionPermissionDO.getUserCondition());
        params.put("gmtCreate", questionPermissionDO.getGmtCreate());
        params.put("gmtModify", questionPermissionDO.getGmtModify());
        params.put("creatorId", questionPermissionDO.getCreatorId());
        params.put("modifierId", questionPermissionDO.getModifierId());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<QuestionPermissionDO> list = getSqlMapClientTemplate().queryForList("QuestionPermission.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(QuestionPermissionDO questionPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("QuestionPermission.deleteByExample", questionPermissionDO);
        return count;
    }









}
