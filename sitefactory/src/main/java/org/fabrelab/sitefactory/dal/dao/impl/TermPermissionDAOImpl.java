package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class TermPermissionDAOImpl extends SqlMapClientDaoSupport implements TermPermissionDAO {

    public java.lang.Long insert(TermPermissionDO termPermissionDO) {
        Object id = getSqlMapClientTemplate().insert("TermPermission.insert", termPermissionDO);
        return (java.lang.Long) id;
    }


    public Integer update(TermPermissionDO termPermissionDO) {
        int result = getSqlMapClientTemplate().update("TermPermission.update", termPermissionDO);
        return result;
    }


    public TermPermissionDO findByPrimaryKey(java.lang.Long id) {
        TermPermissionDO termPermissionDO = (TermPermissionDO) getSqlMapClientTemplate().queryForObject("TermPermission.findByPrimaryKey", id);
        return termPermissionDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("TermPermission.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(TermPermissionDO termPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("TermPermission.countByExample", termPermissionDO);
        return count;
    }


    public List<TermPermissionDO> listByExample(TermPermissionDO termPermissionDO) {
        List<TermPermissionDO> list = getSqlMapClientTemplate().queryForList("TermPermission.listByExample", termPermissionDO);
        return list;
    }


    public List<TermPermissionDO> pageByExample(TermPermissionDO termPermissionDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", termPermissionDO.getId());
        params.put("termId", termPermissionDO.getTermId());
        params.put("permission", termPermissionDO.getPermission());
        params.put("userCondition", termPermissionDO.getUserCondition());
        params.put("gmtCreate", termPermissionDO.getGmtCreate());
        params.put("gmtModify", termPermissionDO.getGmtModify());
        params.put("creatorId", termPermissionDO.getCreatorId());
        params.put("modifierId", termPermissionDO.getModifierId());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<TermPermissionDO> list = getSqlMapClientTemplate().queryForList("TermPermission.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(TermPermissionDO termPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("TermPermission.deleteByExample", termPermissionDO);
        return count;
    }









}
