package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class PostPermissionDAOImpl extends SqlMapClientDaoSupport implements PostPermissionDAO {

    public java.lang.Long insert(PostPermissionDO postPermissionDO) {
        Object id = getSqlMapClientTemplate().insert("PostPermission.insert", postPermissionDO);
        return (java.lang.Long) id;
    }


    public Integer update(PostPermissionDO postPermissionDO) {
        int result = getSqlMapClientTemplate().update("PostPermission.update", postPermissionDO);
        return result;
    }


    public PostPermissionDO findByPrimaryKey(java.lang.Long id) {
        PostPermissionDO postPermissionDO = (PostPermissionDO) getSqlMapClientTemplate().queryForObject("PostPermission.findByPrimaryKey", id);
        return postPermissionDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("PostPermission.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(PostPermissionDO postPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("PostPermission.countByExample", postPermissionDO);
        return count;
    }


    public List<PostPermissionDO> listByExample(PostPermissionDO postPermissionDO) {
        List<PostPermissionDO> list = getSqlMapClientTemplate().queryForList("PostPermission.listByExample", postPermissionDO);
        return list;
    }


    public List<PostPermissionDO> pageByExample(PostPermissionDO postPermissionDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", postPermissionDO.getId());
        params.put("postId", postPermissionDO.getPostId());
        params.put("permission", postPermissionDO.getPermission());
        params.put("userCondition", postPermissionDO.getUserCondition());
        params.put("gmtCreate", postPermissionDO.getGmtCreate());
        params.put("gmtModify", postPermissionDO.getGmtModify());
        params.put("creatorId", postPermissionDO.getCreatorId());
        params.put("modifierId", postPermissionDO.getModifierId());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<PostPermissionDO> list = getSqlMapClientTemplate().queryForList("PostPermission.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(PostPermissionDO postPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("PostPermission.deleteByExample", postPermissionDO);
        return count;
    }









}
