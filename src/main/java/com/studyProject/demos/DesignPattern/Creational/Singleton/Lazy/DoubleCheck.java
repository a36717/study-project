package com.studyProject.demos.DesignPattern.Creational.Singleton.Lazy;

import com.studyProject.demos.DesignPattern.Creational.Singleton.Singleton;

import java.io.Serializable;

/**
 * @Author: Seele
 * @Date: 2025/1/23 14:25
 * @Description: 双重检查锁
 */
public class DoubleCheck implements Singleton {
    //volatile关键字保证创建的对象第一时间对其他线程可见及禁止指令重排序
    private static volatile DoubleCheck instance;
    private DoubleCheck() {
        synchronized (DoubleCheck.class) {
            if (instance!=null) {
                throw new RuntimeException("构造函数只能调用一次");
            }
        }
    }
    public static DoubleCheck getInstance() {
        if (instance == null) {
            synchronized (DoubleCheck.class) {
                //抢到锁之后再次判断是否为null
                if(instance == null) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
    private Object readResolve() {
        return instance;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return instance;
    }
}
