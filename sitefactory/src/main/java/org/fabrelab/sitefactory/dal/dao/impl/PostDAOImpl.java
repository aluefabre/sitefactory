package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class PostDAOImpl extends SqlMapClientDaoSupport implements PostDAO {

    public java.lang.Long insert(PostDO postDO) {
        Object id = getSqlMapClientTemplate().insert("Post.insert", postDO);
        return (java.lang.Long) id;
    }


    public Integer update(PostDO postDO) {
        int result = getSqlMapClientTemplate().update("Post.update", postDO);
        return result;
    }


    public PostDO findByPrimaryKey(java.lang.Long id) {
        PostDO postDO = (PostDO) getSqlMapClientTemplate().queryForObject("Post.findByPrimaryKey", id);
        return postDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("Post.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(PostDO postDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Post.countByExample", postDO);
        return count;
    }


    public List<PostDO> listByExample(PostDO postDO) {
        List<PostDO> list = getSqlMapClientTemplate().queryForList("Post.listByExample", postDO);
        return list;
    }


    public List<PostDO> pageByExample(PostDO postDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", postDO.getId());
        params.put("gmtCreate", postDO.getGmtCreate());
        params.put("gmtModify", postDO.getGmtModify());
        params.put("creatorId", postDO.getCreatorId());
        params.put("modifierId", postDO.getModifierId());
        params.put("title", postDO.getTitle());
        params.put("content", postDO.getContent());
        params.put("type", postDO.getType());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<PostDO> list = getSqlMapClientTemplate().queryForList("Post.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(PostDO postDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Post.deleteByExample", postDO);
        return count;
    }


    public List<PostDO> listByRelation(PostRelationDO postRelationDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", postRelationDO.getRelation()); 
        params.put("relatedType", postRelationDO.getRelatedType()); 
        params.put("relatedId", postRelationDO.getRelatedId()); 
        List<PostDO> list = getSqlMapClientTemplate().queryForList("Post.listByRelation", params);
        return list;
    }


    public List<PostDO> pageByRelation(PostRelationDO postRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", postRelationDO.getRelation()); 
        params.put("relatedType", postRelationDO.getRelatedType()); 
        params.put("relatedId", postRelationDO.getRelatedId()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<PostDO> list = getSqlMapClientTemplate().queryForList("Post.pageByRelation", params);
        return list;
    }


    public List<PostDO> pageByRelationAndExample(PostRelationDO postRelationDO, PostDO postDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", postRelationDO.getRelation()); 
        params.put("relatedType", postRelationDO.getRelatedType()); 
        params.put("relatedId", postRelationDO.getRelatedId()); 
        params.put("id", postDO.getId()); 
        params.put("gmtCreate", postDO.getGmtCreate()); 
        params.put("gmtModify", postDO.getGmtModify()); 
        params.put("creatorId", postDO.getCreatorId()); 
        params.put("modifierId", postDO.getModifierId()); 
        params.put("title", postDO.getTitle()); 
        params.put("content", postDO.getContent()); 
        params.put("type", postDO.getType()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<PostDO> list = getSqlMapClientTemplate().queryForList("Post.pageByRelationAndExample", params);
        return list;
    }


    public List<PostDO> listByRelationAndExample(PostRelationDO postRelationDO, PostDO postDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", postRelationDO.getRelation()); 
        params.put("relatedType", postRelationDO.getRelatedType()); 
        params.put("relatedId", postRelationDO.getRelatedId()); 
        params.put("id", postDO.getId()); 
        params.put("gmtCreate", postDO.getGmtCreate()); 
        params.put("gmtModify", postDO.getGmtModify()); 
        params.put("creatorId", postDO.getCreatorId()); 
        params.put("modifierId", postDO.getModifierId()); 
        params.put("title", postDO.getTitle()); 
        params.put("content", postDO.getContent()); 
        params.put("type", postDO.getType()); 
        List<PostDO> list = getSqlMapClientTemplate().queryForList("Post.listByRelationAndExample", params);
        return list;
    }

}
