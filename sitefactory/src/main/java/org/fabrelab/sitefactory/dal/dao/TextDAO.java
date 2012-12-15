package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface TextDAO {

    public java.lang.Long insert(TextDO textDO);


    public Integer update(TextDO textDO);


    public TextDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(TextDO textDO);


    public List<TextDO> listByExample(TextDO textDO);


    public List<TextDO> pageByExample(TextDO textDO, PageInfo page);


    public Integer deleteByExample(TextDO textDO);









}
