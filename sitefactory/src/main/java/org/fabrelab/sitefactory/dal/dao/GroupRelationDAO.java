package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface GroupRelationDAO {

    public java.lang.Long insert(GroupRelationDO groupRelationDO);


    public Integer update(GroupRelationDO groupRelationDO);


    public GroupRelationDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(GroupRelationDO groupRelationDO);


    public List<GroupRelationDO> listByExample(GroupRelationDO groupRelationDO);


    public List<GroupRelationDO> pageByExample(GroupRelationDO groupRelationDO, PageInfo page);


    public Integer deleteByExample(GroupRelationDO groupRelationDO);









}
