package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface TagDAO {

    public java.lang.Long insert(TagDO tagDO);


    public Integer update(TagDO tagDO);


    public TagDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(TagDO tagDO);


    public List<TagDO> listByExample(TagDO tagDO);


    public List<TagDO> pageByExample(TagDO tagDO, PageInfo page);


    public Integer deleteByExample(TagDO tagDO);


    public List<TagDO> listByRelation(TagRelationDO tagRelationDO);


    public List<TagDO> pageByRelation(TagRelationDO tagRelationDO, PageInfo page);


    public List<TagDO> pageByRelationAndExample(TagRelationDO tagRelationDO, TagDO tagDO, PageInfo page);


    public List<TagDO> listByRelationAndExample(TagRelationDO tagRelationDO, TagDO tagDO);

}
