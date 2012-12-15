package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface CommentPermissionDAO {

    public java.lang.Long insert(CommentPermissionDO commentPermissionDO);


    public Integer update(CommentPermissionDO commentPermissionDO);


    public CommentPermissionDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(CommentPermissionDO commentPermissionDO);


    public List<CommentPermissionDO> listByExample(CommentPermissionDO commentPermissionDO);


    public List<CommentPermissionDO> pageByExample(CommentPermissionDO commentPermissionDO, PageInfo page);


    public Integer deleteByExample(CommentPermissionDO commentPermissionDO);









}
