package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class TagDAOImpl extends SqlMapClientDaoSupport implements TagDAO {

    public java.lang.Long insert(TagDO tagDO) {
        Object id = getSqlMapClientTemplate().insert("Tag.insert", tagDO);
        return (java.lang.Long) id;
    }


    public Integer update(TagDO tagDO) {
        int result = getSqlMapClientTemplate().update("Tag.update", tagDO);
        return result;
    }


    public TagDO findByPrimaryKey(java.lang.Long id) {
        TagDO tagDO = (TagDO) getSqlMapClientTemplate().queryForObject("Tag.findByPrimaryKey", id);
        return tagDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("Tag.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(TagDO tagDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Tag.countByExample", tagDO);
        return count;
    }


    public List<TagDO> listByExample(TagDO tagDO) {
        List<TagDO> list = getSqlMapClientTemplate().queryForList("Tag.listByExample", tagDO);
        return list;
    }


    public List<TagDO> pageByExample(TagDO tagDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", tagDO.getId());
        params.put("gmtCreate", tagDO.getGmtCreate());
        params.put("gmtModify", tagDO.getGmtModify());
        params.put("creatorId", tagDO.getCreatorId());
        params.put("modifierId", tagDO.getModifierId());
        params.put("name", tagDO.getName());
        params.put("description", tagDO.getDescription());
        params.put("type", tagDO.getType());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<TagDO> list = getSqlMapClientTemplate().queryForList("Tag.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(TagDO tagDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Tag.deleteByExample", tagDO);
        return count;
    }


    public List<TagDO> listByRelation(TagRelationDO tagRelationDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", tagRelationDO.getRelation()); 
        params.put("relatedType", tagRelationDO.getRelatedType()); 
        params.put("relatedId", tagRelationDO.getRelatedId()); 
        List<TagDO> list = getSqlMapClientTemplate().queryForList("Tag.listByRelation", params);
        return list;
    }


    public List<TagDO> pageByRelation(TagRelationDO tagRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", tagRelationDO.getRelation()); 
        params.put("relatedType", tagRelationDO.getRelatedType()); 
        params.put("relatedId", tagRelationDO.getRelatedId()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<TagDO> list = getSqlMapClientTemplate().queryForList("Tag.pageByRelation", params);
        return list;
    }


    public List<TagDO> pageByRelationAndExample(TagRelationDO tagRelationDO, TagDO tagDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", tagRelationDO.getRelation()); 
        params.put("relatedType", tagRelationDO.getRelatedType()); 
        params.put("relatedId", tagRelationDO.getRelatedId()); 
        params.put("id", tagDO.getId()); 
        params.put("gmtCreate", tagDO.getGmtCreate()); 
        params.put("gmtModify", tagDO.getGmtModify()); 
        params.put("creatorId", tagDO.getCreatorId()); 
        params.put("modifierId", tagDO.getModifierId()); 
        params.put("name", tagDO.getName()); 
        params.put("description", tagDO.getDescription()); 
        params.put("type", tagDO.getType()); 
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<TagDO> list = getSqlMapClientTemplate().queryForList("Tag.pageByRelationAndExample", params);
        return list;
    }


    public List<TagDO> listByRelationAndExample(TagRelationDO tagRelationDO, TagDO tagDO) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relation", tagRelationDO.getRelation()); 
        params.put("relatedType", tagRelationDO.getRelatedType()); 
        params.put("relatedId", tagRelationDO.getRelatedId()); 
        params.put("id", tagDO.getId()); 
        params.put("gmtCreate", tagDO.getGmtCreate()); 
        params.put("gmtModify", tagDO.getGmtModify()); 
        params.put("creatorId", tagDO.getCreatorId()); 
        params.put("modifierId", tagDO.getModifierId()); 
        params.put("name", tagDO.getName()); 
        params.put("description", tagDO.getDescription()); 
        params.put("type", tagDO.getType()); 
        List<TagDO> list = getSqlMapClientTemplate().queryForList("Tag.listByRelationAndExample", params);
        return list;
    }

}
