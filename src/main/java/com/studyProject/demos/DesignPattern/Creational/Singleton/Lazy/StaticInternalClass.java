package com.studyProject.demos.DesignPattern.Creational.Singleton.Lazy;

import com.studyProject.demos.DesignPattern.Creational.Singleton.Singleton;

import java.io.Serializable;
import java.lang.reflect.Modifier;

/**
 * @Author: Seele
 * @Date: 2025/1/23 14:25
 * @Description: 静态内部类(懒汉式)
 */
public class StaticInternalClass implements Singleton {
    private StaticInternalClass() {
        synchronized (StaticInternalClass.class) {
            if (SingletonHolder.INSTANCE!=null) {
                throw new RuntimeException("构造函数只能调用一次");
            }
        }
    }
    private static class SingletonHolder {
        private static final StaticInternalClass INSTANCE = new StaticInternalClass();
    }
    public static StaticInternalClass getInstance() {
        //静态内部类是第一次被调用才加载,外部类的加载与静态内部类无关,因此是懒汉式
        return SingletonHolder.INSTANCE;
    }
    private Object readResolve() {
        return SingletonHolder.INSTANCE;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return SingletonHolder.INSTANCE;
    }
}
