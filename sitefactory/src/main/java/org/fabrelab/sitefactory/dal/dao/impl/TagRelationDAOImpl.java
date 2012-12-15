package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class TagRelationDAOImpl extends SqlMapClientDaoSupport implements TagRelationDAO {

    public java.lang.Long insert(TagRelationDO tagRelationDO) {
        Object id = getSqlMapClientTemplate().insert("TagRelation.insert", tagRelationDO);
        return (java.lang.Long) id;
    }


    public Integer update(TagRelationDO tagRelationDO) {
        int result = getSqlMapClientTemplate().update("TagRelation.update", tagRelationDO);
        return result;
    }


    public TagRelationDO findByPrimaryKey(java.lang.Long id) {
        TagRelationDO tagRelationDO = (TagRelationDO) getSqlMapClientTemplate().queryForObject("TagRelation.findByPrimaryKey", id);
        return tagRelationDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("TagRelation.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(TagRelationDO tagRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("TagRelation.countByExample", tagRelationDO);
        return count;
    }


    public List<TagRelationDO> listByExample(TagRelationDO tagRelationDO) {
        List<TagRelationDO> list = getSqlMapClientTemplate().queryForList("TagRelation.listByExample", tagRelationDO);
        return list;
    }


    public List<TagRelationDO> pageByExample(TagRelationDO tagRelationDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", tagRelationDO.getId());
        params.put("gmtCreate", tagRelationDO.getGmtCreate());
        params.put("gmtModify", tagRelationDO.getGmtModify());
        params.put("creatorId", tagRelationDO.getCreatorId());
        params.put("modifierId", tagRelationDO.getModifierId());
        params.put("relatedId", tagRelationDO.getRelatedId());
        params.put("tagId", tagRelationDO.getTagId());
        params.put("relation", tagRelationDO.getRelation());
        params.put("relatedType", tagRelationDO.getRelatedType());
        params.put("relationData", tagRelationDO.getRelationData());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<TagRelationDO> list = getSqlMapClientTemplate().queryForList("TagRelation.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(TagRelationDO tagRelationDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("TagRelation.deleteByExample", tagRelationDO);
        return count;
    }









}
