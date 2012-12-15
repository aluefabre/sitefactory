package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class CommentDAOImpl extends SqlMapClientDaoSupport implements CommentDAO {

    public java.lang.Long insert(CommentDO commentDO) {
        Object id = getSqlMapClientTemplate().insert("Comment.insert", commentDO);
        return (java.lang.Long) id;
    }


    public Integer update(CommentDO commentDO) {
        int result = getSqlMapClientTemplate().update("Comment.update", commentDO);
        return result;
    }


    public CommentDO findByPrimaryKey(java.lang.Long id) {
        CommentDO commentDO = (CommentDO) getSqlMapClientTemplate().queryForObject("Comment.findByPrimaryKey", id);
        return commentDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("Comment.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(CommentDO commentDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Comment.countByExample", commentDO);
        return count;
    }


    public List<CommentDO> listByExample(CommentDO commentDO) {
        List<CommentDO> list = getSqlMapClientTemplate().queryForList("Comment.listByExample", commentDO);
        return list;
    }


    public List<CommentDO> pageByExample(CommentDO commentDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", commentDO.getId());
        params.put("gmtCreate", commentDO.getGmtCreate());
        params.put("creatorId", commentDO.getCreatorId());
        params.put("gmtModify", commentDO.getGmtModify());
        params.put("modifierId", commentDO.getModifierId());
        params.put("content", commentDO.getContent());
        params.put("rate", commentDO.getRate());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<CommentDO> list = getSqlMapClientTemplate().queryForList("Comment.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(CommentDO commentDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Comment.deleteByExample", commentDO);
        return count;
    }


    public List<CommentDO> listByRelation(CommentRelationDO commentRelationDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", commentRelationDO.getRelation()); 
        params.put("relatedType", commentRelationDO.getRelatedType()); 
        params.put("relatedId", commentRelationDO.getRelatedId()); 
        List<CommentDO> list = getSqlMapClientTemplate().queryForList("Comment.listByRelation", params);
        return list;
    }


    public List<CommentDO> pageByRelation(CommentRelationDO commentRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", commentRelationDO.getRelation()); 
        params.put("relatedType", commentRelationDO.getRelatedType()); 
        params.put("relatedId", commentRelationDO.getRelatedId()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<CommentDO> list = getSqlMapClientTemplate().queryForList("Comment.pageByRelation", params);
        return list;
    }


    public List<CommentDO> pageByRelationAndExample(CommentRelationDO commentRelationDO, CommentDO commentDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", commentRelationDO.getRelation()); 
        params.put("relatedType", commentRelationDO.getRelatedType()); 
        params.put("relatedId", commentRelationDO.getRelatedId()); 
        params.put("id", commentDO.getId()); 
        params.put("gmtCreate", commentDO.getGmtCreate()); 
        params.put("creatorId", commentDO.getCreatorId()); 
        params.put("gmtModify", commentDO.getGmtModify()); 
        params.put("modifierId", commentDO.getModifierId()); 
        params.put("content", commentDO.getContent()); 
        params.put("rate", commentDO.getRate()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<CommentDO> list = getSqlMapClientTemplate().queryForList("Comment.pageByRelationAndExample", params);
        return list;
    }


    public List<CommentDO> listByRelationAndExample(CommentRelationDO commentRelationDO, CommentDO commentDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", commentRelationDO.getRelation()); 
        params.put("relatedType", commentRelationDO.getRelatedType()); 
        params.put("relatedId", commentRelationDO.getRelatedId()); 
        params.put("id", commentDO.getId()); 
        params.put("gmtCreate", commentDO.getGmtCreate()); 
        params.put("creatorId", commentDO.getCreatorId()); 
        params.put("gmtModify", commentDO.getGmtModify()); 
        params.put("modifierId", commentDO.getModifierId()); 
        params.put("content", commentDO.getContent()); 
        params.put("rate", commentDO.getRate()); 
        List<CommentDO> list = getSqlMapClientTemplate().queryForList("Comment.listByRelationAndExample", params);
        return list;
    }

}
