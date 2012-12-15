package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface CommentRelationDAO {

    public java.lang.Long insert(CommentRelationDO commentRelationDO);


    public Integer update(CommentRelationDO commentRelationDO);


    public CommentRelationDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(CommentRelationDO commentRelationDO);


    public List<CommentRelationDO> listByExample(CommentRelationDO commentRelationDO);


    public List<CommentRelationDO> pageByExample(CommentRelationDO commentRelationDO, PageInfo page);


    public Integer deleteByExample(CommentRelationDO commentRelationDO);









}
