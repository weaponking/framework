package com.framework.sys.vo;

import com.framework.base.vo.BaseVo;
import com.framework.shiro.vo.ShiroUser;
import lombok.Data;
import java.util.List;

/**
 * 用户
 */
@Data
public class SysUser extends BaseVo implements ShiroUser {

    private static final long serialVersionUID = -8031450908114318023L;

    private String loginId;//登陆ID
    private String password;
    private String userName;
    private String email;
    private String phone;
    private String sex; //0=男,1=女,2=未知
    private Long deptId; //部门
    private String salt; //加密
    private SysDept dept;
    private boolean lock;
    private List<SysRole> roles;

    public String getCredentials() {
        return loginId.concat(salt);
    }
}
