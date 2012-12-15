package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface PostDAO {

    public java.lang.Long insert(PostDO postDO);


    public Integer update(PostDO postDO);


    public PostDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(PostDO postDO);


    public List<PostDO> listByExample(PostDO postDO);


    public List<PostDO> pageByExample(PostDO postDO, PageInfo page);


    public Integer deleteByExample(PostDO postDO);


    public List<PostDO> listByRelation(PostRelationDO postRelationDO);


    public List<PostDO> pageByRelation(PostRelationDO postRelationDO, PageInfo page);


    public List<PostDO> pageByRelationAndExample(PostRelationDO postRelationDO, PostDO postDO, PageInfo page);


    public List<PostDO> listByRelationAndExample(PostRelationDO postRelationDO, PostDO postDO);

}
