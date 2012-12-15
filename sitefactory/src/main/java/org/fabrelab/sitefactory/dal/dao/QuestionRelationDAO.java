package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface QuestionRelationDAO {

    public java.lang.Long insert(QuestionRelationDO questionRelationDO);


    public Integer update(QuestionRelationDO questionRelationDO);


    public QuestionRelationDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(QuestionRelationDO questionRelationDO);


    public List<QuestionRelationDO> listByExample(QuestionRelationDO questionRelationDO);


    public List<QuestionRelationDO> pageByExample(QuestionRelationDO questionRelationDO, PageInfo page);


    public Integer deleteByExample(QuestionRelationDO questionRelationDO);









}
