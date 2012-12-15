package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface QuestionPermissionDAO {

    public java.lang.Long insert(QuestionPermissionDO questionPermissionDO);


    public Integer update(QuestionPermissionDO questionPermissionDO);


    public QuestionPermissionDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(QuestionPermissionDO questionPermissionDO);


    public List<QuestionPermissionDO> listByExample(QuestionPermissionDO questionPermissionDO);


    public List<QuestionPermissionDO> pageByExample(QuestionPermissionDO questionPermissionDO, PageInfo page);


    public Integer deleteByExample(QuestionPermissionDO questionPermissionDO);









}
