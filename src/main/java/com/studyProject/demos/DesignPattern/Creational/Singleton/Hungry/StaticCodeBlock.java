package com.studyProject.demos.DesignPattern.Creational.Singleton.Hungry;

import com.studyProject.demos.DesignPattern.Creational.Singleton.Singleton;

import java.io.Serializable;

/**
 * @Author: Seele
 * @Date: 2025/1/23 14:25
 * @Description: 静态代码块
 */
public class StaticCodeBlock implements Singleton {
    private static StaticCodeBlock instance;
    static {
        instance = new StaticCodeBlock();
    }
    private StaticCodeBlock() {
        synchronized (StaticCodeBlock.class) {
            if (instance!=null) {
                throw new RuntimeException("构造函数只能调用一次");
            }
        }
    }
    public static StaticCodeBlock getInstance() {
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
