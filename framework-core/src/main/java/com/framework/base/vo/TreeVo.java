package com.framework.base.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 树形
 */
@Data
public abstract class TreeVo<T> implements Serializable {

    private static final long serialVersionUID = 3366637404526988636L;

    protected Long id; //primary key
    protected boolean delFlag; //1 deleted
    protected Long sortBy;
    protected T parent;
    protected Long parentId;
    protected List<T> children;
    protected Date createTime;
    protected Date updateTime;
}
