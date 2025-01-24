package com.studyProject.demos.DesignPattern.Behavioral.State.enumMethod;

import lombok.Getter;

// 环境角色

public class Context {
    // 定义一个当前电梯状态
    private StateEnum liftState;

    public StateEnum getLiftState() {
        return this.liftState;
    }

    public void setLiftState(StateEnum liftState) {
        // 当前环境改变
        this.liftState = liftState;
        // 把当前的环境通知到各个实现类中
        this.liftState.setContext(this);
    }

    public void open() {
        this.liftState.open();
    }

    public void close() {
        this.liftState.close();
    }

    public void run() {
        this.liftState.run();
    }

    public void stop() {
        this.liftState.stop();
    }
    public void repair() {
        this.liftState.repair();
    }
}