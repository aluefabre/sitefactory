package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface UserDAO {

    public java.lang.Long insert(UserDO userDO);


    public Integer update(UserDO userDO);


    public UserDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(UserDO userDO);


    public List<UserDO> listByExample(UserDO userDO);


    public List<UserDO> pageByExample(UserDO userDO, PageInfo page);


    public Integer deleteByExample(UserDO userDO);


    public List<UserDO> listByRelation(UserRelationDO userRelationDO);


    public List<UserDO> pageByRelation(UserRelationDO userRelationDO, PageInfo page);


    public List<UserDO> pageByRelationAndExample(UserRelationDO userRelationDO, UserDO userDO, PageInfo page);


    public List<UserDO> listByRelationAndExample(UserRelationDO userRelationDO, UserDO userDO);

}
