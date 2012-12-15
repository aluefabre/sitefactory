package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface SiteDAO {

    public java.lang.Long insert(SiteDO siteDO);


    public Integer update(SiteDO siteDO);


    public SiteDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(SiteDO siteDO);


    public List<SiteDO> listByExample(SiteDO siteDO);


    public List<SiteDO> pageByExample(SiteDO siteDO, PageInfo page);


    public Integer deleteByExample(SiteDO siteDO);


    public List<SiteDO> listByRelation(SiteRelationDO siteRelationDO);


    public List<SiteDO> pageByRelation(SiteRelationDO siteRelationDO, PageInfo page);


    public List<SiteDO> pageByRelationAndExample(SiteRelationDO siteRelationDO, SiteDO siteDO, PageInfo page);


    public List<SiteDO> listByRelationAndExample(SiteRelationDO siteRelationDO, SiteDO siteDO);

}
