package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class PostRelationDAOImpl extends SqlMapClientDaoSupport implements PostRelationDAO {

    public java.lang.Long insert(PostRelationDO postRelationDO) {
        Object id = getSqlMapClientTemplate().insert("PostRelation.insert", postRelationDO);
        return (java.lang.Long) id;
    }


    public Integer update(PostRelationDO postRelationDO) {
        int result = getSqlMapClientTemplate().update("PostRelation.update", postRelationDO);
        return result;
    }


    public PostRelationDO findByPrimaryKey(java.lang.Long id) {
        PostRelationDO postRelationDO = (PostRelationDO) getSqlMapClientTemplate().queryForObject("PostRelation.findByPrimaryKey", id);
        return postRelationDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("PostRelation.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(PostRelationDO postRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("PostRelation.countByExample", postRelationDO);
        return count;
    }


    public List<PostRelationDO> listByExample(PostRelationDO postRelationDO) {
        List<PostRelationDO> list = getSqlMapClientTemplate().queryForList("PostRelation.listByExample", postRelationDO);
        return list;
    }


    public List<PostRelationDO> pageByExample(PostRelationDO postRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", postRelationDO.getId());
        params.put("gmtCreate", postRelationDO.getGmtCreate());
        params.put("gmtModify", postRelationDO.getGmtModify());
        params.put("creatorId", postRelationDO.getCreatorId());
        params.put("modifierId", postRelationDO.getModifierId());
        params.put("relatedId", postRelationDO.getRelatedId());
        params.put("postId", postRelationDO.getPostId());
        params.put("relation", postRelationDO.getRelation());
        params.put("relatedType", postRelationDO.getRelatedType());
        params.put("relationData", postRelationDO.getRelationData());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<PostRelationDO> list = getSqlMapClientTemplate().queryForList("PostRelation.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(PostRelationDO postRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("PostRelation.deleteByExample", postRelationDO);
        return count;
    }









}
