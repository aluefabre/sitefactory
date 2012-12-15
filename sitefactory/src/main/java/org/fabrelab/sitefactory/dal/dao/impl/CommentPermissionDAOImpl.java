package org.fabrelab.sitefactory.dal.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.dal.dao.CommentPermissionDAO;
import org.fabrelab.sitefactory.dal.dataobject.CommentPermissionDO;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
public class CommentPermissionDAOImpl extends SqlMapClientDaoSupport implements CommentPermissionDAO {

    public java.lang.Long insert(CommentPermissionDO commentPermissionDO) {
        Object id = getSqlMapClientTemplate().insert("CommentPermission.insert", commentPermissionDO);
        return (java.lang.Long) id;
    }


    public Integer update(CommentPermissionDO commentPermissionDO) {
        int result = getSqlMapClientTemplate().update("CommentPermission.update", commentPermissionDO);
        return result;
    }


    public CommentPermissionDO findByPrimaryKey(java.lang.Long id) {
        CommentPermissionDO commentPermissionDO = (CommentPermissionDO) getSqlMapClientTemplate().queryForObject("CommentPermission.findByPrimaryKey", id);
        return commentPermissionDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("CommentPermission.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(CommentPermissionDO commentPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("CommentPermission.countByExample", commentPermissionDO);
        return count;
    }


    public List<CommentPermissionDO> listByExample(CommentPermissionDO commentPermissionDO) {
        List<CommentPermissionDO> list = getSqlMapClientTemplate().queryForList("CommentPermission.listByExample", commentPermissionDO);
        return list;
    }


    public List<CommentPermissionDO> pageByExample(CommentPermissionDO commentPermissionDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", commentPermissionDO.getId());
        params.put("commentId", commentPermissionDO.getCommentId());
        params.put("permission", commentPermissionDO.getPermission());
        params.put("userCondition", commentPermissionDO.getUserCondition());
        params.put("gmtCreate", commentPermissionDO.getGmtCreate());
        params.put("gmtModify", commentPermissionDO.getGmtModify());
        params.put("creatorId", commentPermissionDO.getCreatorId());
        params.put("modifierId", commentPermissionDO.getModifierId());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<CommentPermissionDO> list = getSqlMapClientTemplate().queryForList("CommentPermission.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(CommentPermissionDO commentPermissionDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("CommentPermission.deleteByExample", commentPermissionDO);
        return count;
    }









}
