package com.studyProject.demos.DesignPattern.Behavioral.State.Low;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Lift lift = new Lift();
        lift.setState(ILift.OPENING_STATE);
        lift.open();//开门
        lift.stop();//停止
        lift.open();//开门
        lift.close();//关门
        lift.run();//运行
        lift.open();//开门
        lift.stop();//停止
    }
}
