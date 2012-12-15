package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface ArticlePermissionDAO {

    public java.lang.Long insert(ArticlePermissionDO articlePermissionDO);


    public Integer update(ArticlePermissionDO articlePermissionDO);


    public ArticlePermissionDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(ArticlePermissionDO articlePermissionDO);


    public List<ArticlePermissionDO> listByExample(ArticlePermissionDO articlePermissionDO);


    public List<ArticlePermissionDO> pageByExample(ArticlePermissionDO articlePermissionDO, PageInfo page);


    public Integer deleteByExample(ArticlePermissionDO articlePermissionDO);









}
