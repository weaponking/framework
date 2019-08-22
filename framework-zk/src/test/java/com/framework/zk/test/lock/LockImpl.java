package com.framework.zk.test.lock;

public class LockImpl implements Lock {

    private final static String SEPARATOR = "/";

    private final static String LOCK_NODE = SEPARATOR + "tmpLock";

    public void lock() {

    }

    public void unLock() {

    }

    public boolean tryLock() {
        return false;
    }

}
