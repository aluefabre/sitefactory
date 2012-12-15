package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface AnswerDAO {

    public java.lang.Long insert(AnswerDO answerDO);


    public Integer update(AnswerDO answerDO);


    public AnswerDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(AnswerDO answerDO);


    public List<AnswerDO> listByExample(AnswerDO answerDO);


    public List<AnswerDO> pageByExample(AnswerDO answerDO, PageInfo page);


    public Integer deleteByExample(AnswerDO answerDO);


    public List<AnswerDO> listByRelation(AnswerRelationDO answerRelationDO);


    public List<AnswerDO> pageByRelation(AnswerRelationDO answerRelationDO, PageInfo page);


    public List<AnswerDO> pageByRelationAndExample(AnswerRelationDO answerRelationDO, AnswerDO answerDO, PageInfo page);


    public List<AnswerDO> listByRelationAndExample(AnswerRelationDO answerRelationDO, AnswerDO answerDO);

}
