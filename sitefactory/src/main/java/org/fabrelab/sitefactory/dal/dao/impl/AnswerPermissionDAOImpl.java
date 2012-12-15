package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class AnswerPermissionDAOImpl extends SqlMapClientDaoSupport implements AnswerPermissionDAO {

    public java.lang.Long insert(AnswerPermissionDO answerPermissionDO) {
        Object id = getSqlMapClientTemplate().insert("AnswerPermission.insert", answerPermissionDO);
        return (java.lang.Long) id;
    }


    public Integer update(AnswerPermissionDO answerPermissionDO) {
        int result = getSqlMapClientTemplate().update("AnswerPermission.update", answerPermissionDO);
        return result;
    }


    public AnswerPermissionDO findByPrimaryKey(java.lang.Long id) {
        AnswerPermissionDO answerPermissionDO = (AnswerPermissionDO) getSqlMapClientTemplate().queryForObject("AnswerPermission.findByPrimaryKey", id);
        return answerPermissionDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("AnswerPermission.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(AnswerPermissionDO answerPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("AnswerPermission.countByExample", answerPermissionDO);
        return count;
    }


    public List<AnswerPermissionDO> listByExample(AnswerPermissionDO answerPermissionDO) {
        List<AnswerPermissionDO> list = getSqlMapClientTemplate().queryForList("AnswerPermission.listByExample", answerPermissionDO);
        return list;
    }


    public List<AnswerPermissionDO> pageByExample(AnswerPermissionDO answerPermissionDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", answerPermissionDO.getId());
        params.put("answerId", answerPermissionDO.getAnswerId());
        params.put("permission", answerPermissionDO.getPermission());
        params.put("userCondition", answerPermissionDO.getUserCondition());
        params.put("gmtCreate", answerPermissionDO.getGmtCreate());
        params.put("gmtModify", answerPermissionDO.getGmtModify());
        params.put("creatorId", answerPermissionDO.getCreatorId());
        params.put("modifierId", answerPermissionDO.getModifierId());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<AnswerPermissionDO> list = getSqlMapClientTemplate().queryForList("AnswerPermission.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(AnswerPermissionDO answerPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("AnswerPermission.deleteByExample", answerPermissionDO);
        return count;
    }









}
