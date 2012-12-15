package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface RoleRelationDAO {

    public java.lang.Long insert(RoleRelationDO roleRelationDO);


    public Integer update(RoleRelationDO roleRelationDO);


    public RoleRelationDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(RoleRelationDO roleRelationDO);


    public List<RoleRelationDO> listByExample(RoleRelationDO roleRelationDO);


    public List<RoleRelationDO> pageByExample(RoleRelationDO roleRelationDO, PageInfo page);


    public Integer deleteByExample(RoleRelationDO roleRelationDO);









}
