package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface PostRelationDAO {

    public java.lang.Long insert(PostRelationDO postRelationDO);


    public Integer update(PostRelationDO postRelationDO);


    public PostRelationDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(PostRelationDO postRelationDO);


    public List<PostRelationDO> listByExample(PostRelationDO postRelationDO);


    public List<PostRelationDO> pageByExample(PostRelationDO postRelationDO, PageInfo page);


    public Integer deleteByExample(PostRelationDO postRelationDO);









}
