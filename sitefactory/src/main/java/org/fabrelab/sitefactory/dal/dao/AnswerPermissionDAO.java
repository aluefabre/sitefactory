package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface AnswerPermissionDAO {

    public java.lang.Long insert(AnswerPermissionDO answerPermissionDO);


    public Integer update(AnswerPermissionDO answerPermissionDO);


    public AnswerPermissionDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(AnswerPermissionDO answerPermissionDO);


    public List<AnswerPermissionDO> listByExample(AnswerPermissionDO answerPermissionDO);


    public List<AnswerPermissionDO> pageByExample(AnswerPermissionDO answerPermissionDO, PageInfo page);


    public Integer deleteByExample(AnswerPermissionDO answerPermissionDO);









}
