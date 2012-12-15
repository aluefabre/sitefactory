package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface GroupPermissionDAO {

    public java.lang.Long insert(GroupPermissionDO groupPermissionDO);


    public Integer update(GroupPermissionDO groupPermissionDO);


    public GroupPermissionDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(GroupPermissionDO groupPermissionDO);


    public List<GroupPermissionDO> listByExample(GroupPermissionDO groupPermissionDO);


    public List<GroupPermissionDO> pageByExample(GroupPermissionDO groupPermissionDO, PageInfo page);


    public Integer deleteByExample(GroupPermissionDO groupPermissionDO);









}
