package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface ArticleDAO {

    public java.lang.Long insert(ArticleDO articleDO);


    public Integer update(ArticleDO articleDO);


    public ArticleDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(ArticleDO articleDO);


    public List<ArticleDO> listByExample(ArticleDO articleDO);


    public List<ArticleDO> pageByExample(ArticleDO articleDO, PageInfo page);


    public Integer deleteByExample(ArticleDO articleDO);


    public List<ArticleDO> listByRelation(ArticleRelationDO articleRelationDO);


    public List<ArticleDO> pageByRelation(ArticleRelationDO articleRelationDO, PageInfo page);


    public List<ArticleDO> pageByRelationAndExample(ArticleRelationDO articleRelationDO, ArticleDO articleDO, PageInfo page);


    public List<ArticleDO> listByRelationAndExample(ArticleRelationDO articleRelationDO, ArticleDO articleDO);

}
