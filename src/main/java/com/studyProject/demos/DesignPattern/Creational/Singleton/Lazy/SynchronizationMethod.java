package com.studyProject.demos.DesignPattern.Creational.Singleton.Lazy;

import com.studyProject.demos.DesignPattern.Creational.Singleton.Singleton;

import java.io.Serializable;

/**
 * @Author: Seele
 * @Date: 2025/1/23 14:22
 * @Description: 同步方法
 */
public class SynchronizationMethod implements Singleton {
    private static SynchronizationMethod instance;
    private static volatile boolean flag = false;
    private SynchronizationMethod() {
        synchronized (SynchronizationMethod.class) {
            if (flag) {
                throw new RuntimeException("构造函数只能调用一次");
            }
            flag = true;
        }
    }
    public static synchronized SynchronizationMethod getInstance() {
        if (instance == null) {
            instance = new SynchronizationMethod();
        }
        return instance;
    }
    private Object readResolve() {
        return instance;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
        return instance;
    }
}
