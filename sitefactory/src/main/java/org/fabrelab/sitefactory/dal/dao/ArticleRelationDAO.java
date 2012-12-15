package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface ArticleRelationDAO {

    public java.lang.Long insert(ArticleRelationDO articleRelationDO);


    public Integer update(ArticleRelationDO articleRelationDO);


    public ArticleRelationDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(ArticleRelationDO articleRelationDO);


    public List<ArticleRelationDO> listByExample(ArticleRelationDO articleRelationDO);


    public List<ArticleRelationDO> pageByExample(ArticleRelationDO articleRelationDO, PageInfo page);


    public Integer deleteByExample(ArticleRelationDO articleRelationDO);









}
