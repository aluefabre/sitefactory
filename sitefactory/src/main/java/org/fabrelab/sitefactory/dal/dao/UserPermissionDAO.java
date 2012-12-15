package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface UserPermissionDAO {

    public java.lang.Long insert(UserPermissionDO userPermissionDO);


    public Integer update(UserPermissionDO userPermissionDO);


    public UserPermissionDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(UserPermissionDO userPermissionDO);


    public List<UserPermissionDO> listByExample(UserPermissionDO userPermissionDO);


    public List<UserPermissionDO> pageByExample(UserPermissionDO userPermissionDO, PageInfo page);


    public Integer deleteByExample(UserPermissionDO userPermissionDO);









}
