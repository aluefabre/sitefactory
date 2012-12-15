package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface RoleDAO {

    public java.lang.Long insert(RoleDO roleDO);


    public Integer update(RoleDO roleDO);


    public RoleDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(RoleDO roleDO);


    public List<RoleDO> listByExample(RoleDO roleDO);


    public List<RoleDO> pageByExample(RoleDO roleDO, PageInfo page);


    public Integer deleteByExample(RoleDO roleDO);


    public List<RoleDO> listByRelation(RoleRelationDO roleRelationDO);


    public List<RoleDO> pageByRelation(RoleRelationDO roleRelationDO, PageInfo page);


    public List<RoleDO> pageByRelationAndExample(RoleRelationDO roleRelationDO, RoleDO roleDO, PageInfo page);


    public List<RoleDO> listByRelationAndExample(RoleRelationDO roleRelationDO, RoleDO roleDO);

}
