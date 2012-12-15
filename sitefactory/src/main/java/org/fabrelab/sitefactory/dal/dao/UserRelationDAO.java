package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface UserRelationDAO {

    public java.lang.Long insert(UserRelationDO userRelationDO);


    public Integer update(UserRelationDO userRelationDO);


    public UserRelationDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(UserRelationDO userRelationDO);


    public List<UserRelationDO> listByExample(UserRelationDO userRelationDO);


    public List<UserRelationDO> pageByExample(UserRelationDO userRelationDO, PageInfo page);


    public Integer deleteByExample(UserRelationDO userRelationDO);









}
