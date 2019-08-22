package com.framework.zk.test.lock;

public interface Lock {

    void lock() ;

    void unLock();

    boolean tryLock();

}
