package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface AnswerRelationDAO {

    public java.lang.Long insert(AnswerRelationDO answerRelationDO);


    public Integer update(AnswerRelationDO answerRelationDO);


    public AnswerRelationDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(AnswerRelationDO answerRelationDO);


    public List<AnswerRelationDO> listByExample(AnswerRelationDO answerRelationDO);


    public List<AnswerRelationDO> pageByExample(AnswerRelationDO answerRelationDO, PageInfo page);


    public Integer deleteByExample(AnswerRelationDO answerRelationDO);









}
