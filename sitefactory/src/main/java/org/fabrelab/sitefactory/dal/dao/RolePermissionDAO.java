package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface RolePermissionDAO {

    public java.lang.Long insert(RolePermissionDO rolePermissionDO);


    public Integer update(RolePermissionDO rolePermissionDO);


    public RolePermissionDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(RolePermissionDO rolePermissionDO);


    public List<RolePermissionDO> listByExample(RolePermissionDO rolePermissionDO);


    public List<RolePermissionDO> pageByExample(RolePermissionDO rolePermissionDO, PageInfo page);


    public Integer deleteByExample(RolePermissionDO rolePermissionDO);









}
