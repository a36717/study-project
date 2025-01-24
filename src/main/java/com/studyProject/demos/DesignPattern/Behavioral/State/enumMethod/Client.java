package com.studyProject.demos.DesignPattern.Behavioral.State.enumMethod;



public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(StateEnum.FAULT);
        context.open();
        context.repair();
        context.open();   // 输出: 电梯门开启...
        context.run();
        context.close();  // 切换状态并调用关闭动作
        context.run();    // 由于当前状态是关闭状态，会切换到运行状态并执行运行动作
        context.stop();   // 切换状态并调用停止动作
    }
}