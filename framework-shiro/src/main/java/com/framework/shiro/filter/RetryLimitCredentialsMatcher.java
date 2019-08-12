package com.framework.shiro.filter;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class RetryLimitCredentialsMatcher extends HashedCredentialsMatcher {

    private Cache<String, AtomicInteger> passwordRetryCache;

    @Value("${password.algorithmName}")
    private String algorithmName = "md5";
    @Value("${password.hashIterations}")
    private int hashIterations = 2;
    @Value("${password.retryCount}")
    private int retryCount = 5;

    @Autowired
    public RetryLimitCredentialsMatcher(CacheManager shiroCacheManager) {
        setHashAlgorithmName(algorithmName);
        setHashIterations(hashIterations);
        setStoredCredentialsHexEncoded(true);
        passwordRetryCache = shiroCacheManager.getCache("passwordRetryCache");
    }

    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String)token.getPrincipal();
        AtomicInteger cacheCount = passwordRetryCache.get(username);
        if(cacheCount == null) {
            cacheCount = new AtomicInteger(0);
            passwordRetryCache.put(username, cacheCount);
        }
        if(cacheCount.incrementAndGet() > retryCount) {
            throw new ExcessiveAttemptsException();
        }

        boolean matches = super.doCredentialsMatch(token, info);
        if(matches) {
            passwordRetryCache.remove(username);
        }
        return matches;
    }
}
