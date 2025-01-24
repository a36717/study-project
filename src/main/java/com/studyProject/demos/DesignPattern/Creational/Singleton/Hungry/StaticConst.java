package com.studyProject.demos.DesignPattern.Creational.Singleton.Hungry;

import com.studyProject.demos.DesignPattern.Creational.Singleton.Lazy.DoubleCheck;
import com.studyProject.demos.DesignPattern.Creational.Singleton.Singleton;

import java.io.Serializable;

/**
 * @Author: Seele
 * @Date: 2025/1/23 14:25
 * @Description: 静态常量
 */
public class StaticConst implements Singleton {
    private final static StaticConst INSTANCE = new StaticConst();
    private StaticConst() {
        synchronized (StaticConst.class) {
            if (INSTANCE!=null) {
                throw new RuntimeException("构造函数只能调用一次");
            }
        }
    }
    public static StaticConst getInstance() {
        return INSTANCE;
    }
    private Object readResolve() {
        return INSTANCE;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return INSTANCE;
    }
}
