package org.fabrelab.sitefactory.dal.dao.impl;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public class TextDAOImpl extends SqlMapClientDaoSupport implements TextDAO {

    public java.lang.Long insert(TextDO textDO) {
        Object id = getSqlMapClientTemplate().insert("Text.insert", textDO);
        return (java.lang.Long) id;
    }


    public Integer update(TextDO textDO) {
        int result = getSqlMapClientTemplate().update("Text.update", textDO);
        return result;
    }


    public TextDO findByPrimaryKey(java.lang.Long id) {
        TextDO textDO = (TextDO) getSqlMapClientTemplate().queryForObject("Text.findByPrimaryKey", id);
        return textDO;
    }


    public Integer deleteByPrimaryKey(java.lang.Long id) {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("Text.deleteByPrimaryKey", id);
        return rows;
    }


    public Integer countByExample(TextDO textDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Text.countByExample", textDO);
        return count;
    }


    public List<TextDO> listByExample(TextDO textDO) {
        List<TextDO> list = getSqlMapClientTemplate().queryForList("Text.listByExample", textDO);
        return list;
    }


    public List<TextDO> pageByExample(TextDO textDO, PageInfo page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", textDO.getId());
        params.put("entityId", textDO.getEntityId());
        params.put("content", textDO.getContent());
        params.put("gmtCreate", textDO.getGmtCreate());
        params.put("gmtModify", textDO.getGmtModify());
        params.put("creatorId", textDO.getCreatorId());
        params.put("modifierId", textDO.getModifierId());
        params.put("pageStart", page.getPageStart());
        params.put("pageSize", page.getPageSize());
        List<TextDO> list = getSqlMapClientTemplate().queryForList("Text.pageByExample", params);
        return list;
    }


    public Integer deleteByExample(TextDO textDO) {
        Integer count = (Integer)getSqlMapClientTemplate().queryForObject("Text.deleteByExample", textDO);
        return count;
    }









}
