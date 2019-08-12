package com.framework.sys.vo;

import com.framework.base.vo.TreeVo;
import lombok.Data;

@Data
public class SysMenu extends TreeVo<SysMenu> {

    private static final long serialVersionUID = -3168199386317397761L;

    private String menuName;
    private String menuType;
    private String menuIcon;
    private String menuPerm;
    private String menuUrl;
    private String menuDesc;

}
