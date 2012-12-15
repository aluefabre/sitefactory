package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface TagRelationDAO {

    public java.lang.Long insert(TagRelationDO tagRelationDO);


    public Integer update(TagRelationDO tagRelationDO);


    public TagRelationDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(TagRelationDO tagRelationDO);


    public List<TagRelationDO> listByExample(TagRelationDO tagRelationDO);


    public List<TagRelationDO> pageByExample(TagRelationDO tagRelationDO, PageInfo page);


    public Integer deleteByExample(TagRelationDO tagRelationDO);









}
