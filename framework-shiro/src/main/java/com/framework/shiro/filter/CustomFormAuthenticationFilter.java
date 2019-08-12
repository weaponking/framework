package com.framework.shiro.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Component;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Component("formAuthenticationFilter")
@Slf4j
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    private static final String successUrl = "/index";

    private String usernameParam = "loginId";

    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
        log.info("successUrl : {}", successUrl);
        WebUtils.issueRedirect(request, response, successUrl, null, true);
    }

}
