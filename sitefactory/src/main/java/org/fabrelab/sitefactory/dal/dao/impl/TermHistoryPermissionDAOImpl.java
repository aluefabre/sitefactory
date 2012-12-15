package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class TermHistoryPermissionDAOImpl extends SqlMapClientDaoSupport implements TermHistoryPermissionDAO {

    public java.lang.Long insert(TermHistoryPermissionDO termHistoryPermissionDO) {
        Object id = getSqlMapClientTemplate().insert("TermHistoryPermission.insert", termHistoryPermissionDO);
        return (java.lang.Long) id;
    }


    public Integer update(TermHistoryPermissionDO termHistoryPermissionDO) {
        int result = getSqlMapClientTemplate().update("TermHistoryPermission.update", termHistoryPermissionDO);
        return result;
    }


    public TermHistoryPermissionDO findByPrimaryKey(java.lang.Long id) {
        TermHistoryPermissionDO termHistoryPermissionDO = (TermHistoryPermissionDO) getSqlMapClientTemplate().queryForObject("TermHistoryPermission.findByPrimaryKey", id);
        return termHistoryPermissionDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("TermHistoryPermission.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(TermHistoryPermissionDO termHistoryPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("TermHistoryPermission.countByExample", termHistoryPermissionDO);
        return count;
    }


    public List<TermHistoryPermissionDO> listByExample(TermHistoryPermissionDO termHistoryPermissionDO) {
        List<TermHistoryPermissionDO> list = getSqlMapClientTemplate().queryForList("TermHistoryPermission.listByExample", termHistoryPermissionDO);
        return list;
    }


    public List<TermHistoryPermissionDO> pageByExample(TermHistoryPermissionDO termHistoryPermissionDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", termHistoryPermissionDO.getId());
        params.put("termHistoryId", termHistoryPermissionDO.getTermHistoryId());
        params.put("permission", termHistoryPermissionDO.getPermission());
        params.put("userCondition", termHistoryPermissionDO.getUserCondition());
        params.put("gmtCreate", termHistoryPermissionDO.getGmtCreate());
        params.put("gmtModify", termHistoryPermissionDO.getGmtModify());
        params.put("creatorId", termHistoryPermissionDO.getCreatorId());
        params.put("modifierId", termHistoryPermissionDO.getModifierId());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<TermHistoryPermissionDO> list = getSqlMapClientTemplate().queryForList("TermHistoryPermission.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(TermHistoryPermissionDO termHistoryPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("TermHistoryPermission.deleteByExample", termHistoryPermissionDO);
        return count;
    }









}
