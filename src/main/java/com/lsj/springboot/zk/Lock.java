package com.lsj.springboot.zk;

import org.apache.zookeeper.KeeperException;

/**
 * https://www.cnblogs.com/LOVE0612/p/9714163.html
 */
public interface Lock {
    public void getLock() throws KeeperException, InterruptedException;
    public void freeLock() throws KeeperException, InterruptedException;
}
