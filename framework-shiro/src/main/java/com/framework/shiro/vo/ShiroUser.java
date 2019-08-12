package com.framework.shiro.vo;

public interface ShiroUser {

    String getLoginId();
    String getPassword();
    String getCredentials();
    boolean isLock();

    void setPassword(String password);
    void setSalt(String salt);
}
