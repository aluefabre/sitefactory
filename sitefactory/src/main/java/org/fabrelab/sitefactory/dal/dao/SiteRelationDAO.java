package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface SiteRelationDAO {

    public java.lang.Long insert(SiteRelationDO siteRelationDO);


    public Integer update(SiteRelationDO siteRelationDO);


    public SiteRelationDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(SiteRelationDO siteRelationDO);


    public List<SiteRelationDO> listByExample(SiteRelationDO siteRelationDO);


    public List<SiteRelationDO> pageByExample(SiteRelationDO siteRelationDO, PageInfo page);


    public Integer deleteByExample(SiteRelationDO siteRelationDO);









}
