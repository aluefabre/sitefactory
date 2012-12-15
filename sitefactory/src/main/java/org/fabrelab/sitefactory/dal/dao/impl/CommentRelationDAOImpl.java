package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class CommentRelationDAOImpl extends SqlMapClientDaoSupport implements CommentRelationDAO {

    public java.lang.Long insert(CommentRelationDO commentRelationDO) {
        Object id = getSqlMapClientTemplate().insert("CommentRelation.insert", commentRelationDO);
        return (java.lang.Long) id;
    }


    public Integer update(CommentRelationDO commentRelationDO) {
        int result = getSqlMapClientTemplate().update("CommentRelation.update", commentRelationDO);
        return result;
    }


    public CommentRelationDO findByPrimaryKey(java.lang.Long id) {
        CommentRelationDO commentRelationDO = (CommentRelationDO) getSqlMapClientTemplate().queryForObject("CommentRelation.findByPrimaryKey", id);
        return commentRelationDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("CommentRelation.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(CommentRelationDO commentRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("CommentRelation.countByExample", commentRelationDO);
        return count;
    }


    public List<CommentRelationDO> listByExample(CommentRelationDO commentRelationDO) {
        List<CommentRelationDO> list = getSqlMapClientTemplate().queryForList("CommentRelation.listByExample", commentRelationDO);
        return list;
    }


    public List<CommentRelationDO> pageByExample(CommentRelationDO commentRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", commentRelationDO.getId());
        params.put("gmtCreate", commentRelationDO.getGmtCreate());
        params.put("gmtModify", commentRelationDO.getGmtModify());
        params.put("creatorId", commentRelationDO.getCreatorId());
        params.put("modifierId", commentRelationDO.getModifierId());
        params.put("relatedId", commentRelationDO.getRelatedId());
        params.put("commentId", commentRelationDO.getCommentId());
        params.put("relation", commentRelationDO.getRelation());
        params.put("relatedType", commentRelationDO.getRelatedType());
        params.put("relationData", commentRelationDO.getRelationData());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<CommentRelationDO> list = getSqlMapClientTemplate().queryForList("CommentRelation.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(CommentRelationDO commentRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("CommentRelation.deleteByExample", commentRelationDO);
        return count;
    }









}
