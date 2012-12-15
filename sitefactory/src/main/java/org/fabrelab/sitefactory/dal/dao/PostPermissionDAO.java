package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface PostPermissionDAO {

    public java.lang.Long insert(PostPermissionDO postPermissionDO);


    public Integer update(PostPermissionDO postPermissionDO);


    public PostPermissionDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(PostPermissionDO postPermissionDO);


    public List<PostPermissionDO> listByExample(PostPermissionDO postPermissionDO);


    public List<PostPermissionDO> pageByExample(PostPermissionDO postPermissionDO, PageInfo page);


    public Integer deleteByExample(PostPermissionDO postPermissionDO);









}
