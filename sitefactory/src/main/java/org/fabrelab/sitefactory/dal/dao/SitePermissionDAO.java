package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface SitePermissionDAO {

    public java.lang.Long insert(SitePermissionDO sitePermissionDO);


    public Integer update(SitePermissionDO sitePermissionDO);


    public SitePermissionDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(SitePermissionDO sitePermissionDO);


    public List<SitePermissionDO> listByExample(SitePermissionDO sitePermissionDO);


    public List<SitePermissionDO> pageByExample(SitePermissionDO sitePermissionDO, PageInfo page);


    public Integer deleteByExample(SitePermissionDO sitePermissionDO);









}
