package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class TagPermissionDAOImpl extends SqlMapClientDaoSupport implements TagPermissionDAO {

    public java.lang.Long insert(TagPermissionDO tagPermissionDO) {
        Object id = getSqlMapClientTemplate().insert("TagPermission.insert", tagPermissionDO);
        return (java.lang.Long) id;
    }


    public Integer update(TagPermissionDO tagPermissionDO) {
        int result = getSqlMapClientTemplate().update("TagPermission.update", tagPermissionDO);
        return result;
    }


    public TagPermissionDO findByPrimaryKey(java.lang.Long id) {
        TagPermissionDO tagPermissionDO = (TagPermissionDO) getSqlMapClientTemplate().queryForObject("TagPermission.findByPrimaryKey", id);
        return tagPermissionDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("TagPermission.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(TagPermissionDO tagPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("TagPermission.countByExample", tagPermissionDO);
        return count;
    }


    public List<TagPermissionDO> listByExample(TagPermissionDO tagPermissionDO) {
        List<TagPermissionDO> list = getSqlMapClientTemplate().queryForList("TagPermission.listByExample", tagPermissionDO);
        return list;
    }


    public List<TagPermissionDO> pageByExample(TagPermissionDO tagPermissionDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", tagPermissionDO.getId());
        params.put("tagId", tagPermissionDO.getTagId());
        params.put("permission", tagPermissionDO.getPermission());
        params.put("userCondition", tagPermissionDO.getUserCondition());
        params.put("gmtCreate", tagPermissionDO.getGmtCreate());
        params.put("gmtModify", tagPermissionDO.getGmtModify());
        params.put("creatorId", tagPermissionDO.getCreatorId());
        params.put("modifierId", tagPermissionDO.getModifierId());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<TagPermissionDO> list = getSqlMapClientTemplate().queryForList("TagPermission.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(TagPermissionDO tagPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("TagPermission.deleteByExample", tagPermissionDO);
        return count;
    }









}
