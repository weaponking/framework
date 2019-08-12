package com.framework.sys.vo;

import com.framework.base.vo.TreeVo;
import lombok.Data;

@Data
public class SysDept extends TreeVo<SysDept> {

    private static final long serialVersionUID = 2069905605698034586L;

    private String deptName;
}
