package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface QuestionDAO {

    public java.lang.Long insert(QuestionDO questionDO);


    public Integer update(QuestionDO questionDO);


    public QuestionDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(QuestionDO questionDO);


    public List<QuestionDO> listByExample(QuestionDO questionDO);


    public List<QuestionDO> pageByExample(QuestionDO questionDO, PageInfo page);


    public Integer deleteByExample(QuestionDO questionDO);


    public List<QuestionDO> listByRelation(QuestionRelationDO questionRelationDO);


    public List<QuestionDO> pageByRelation(QuestionRelationDO questionRelationDO, PageInfo page);


    public List<QuestionDO> pageByRelationAndExample(QuestionRelationDO questionRelationDO, QuestionDO questionDO, PageInfo page);


    public List<QuestionDO> listByRelationAndExample(QuestionRelationDO questionRelationDO, QuestionDO questionDO);

}
