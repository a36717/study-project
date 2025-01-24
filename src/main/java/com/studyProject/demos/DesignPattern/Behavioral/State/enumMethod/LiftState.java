package com.studyProject.demos.DesignPattern.Behavioral.State.enumMethod;

//抽象状态类
public interface LiftState {

    void setContext(Context context);

    //电梯开门动作
    void open();

    //电梯关门动作
    void close();

    //电梯运行动作
    void run();

    //电梯停止动作
    void stop();

}