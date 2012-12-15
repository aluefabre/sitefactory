package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface CommentDAO {

    public java.lang.Long insert(CommentDO commentDO);


    public Integer update(CommentDO commentDO);


    public CommentDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(CommentDO commentDO);


    public List<CommentDO> listByExample(CommentDO commentDO);


    public List<CommentDO> pageByExample(CommentDO commentDO, PageInfo page);


    public Integer deleteByExample(CommentDO commentDO);


    public List<CommentDO> listByRelation(CommentRelationDO commentRelationDO);


    public List<CommentDO> pageByRelation(CommentRelationDO commentRelationDO, PageInfo page);


    public List<CommentDO> pageByRelationAndExample(CommentRelationDO commentRelationDO, CommentDO commentDO, PageInfo page);


    public List<CommentDO> listByRelationAndExample(CommentRelationDO commentRelationDO, CommentDO commentDO);

}
