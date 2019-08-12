package com.framework.base.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * 单表基础类
 */
@Data
public abstract class BaseVo implements Serializable {

    private static final long serialVersionUID = -3599463239750822759L;

    protected Long id; //primary key
    protected boolean delFlag; //1 deleted
    protected Long sortBy;
    protected Date createTime;
    protected Date updateTime;

}
