package com.studyProject.demos.DesignPattern.Behavioral.State.Low;

public class Lift implements ILift {
    private int state;

    @Override
    public void setState(int state) {
        this.state = state;
    }

    //执行关门动作
    @Override
    public void close() throws InterruptedException {
        switch (this.state) {
            case OPENING_STATE:
                System.out.println("电梯关门了");//只有开门状态可以关闭电梯门
                System.out.flush();
                this.setState(CLOSING_STATE);//关门之后电梯就是关闭状态了
                Thread.sleep(10);
                break;
            case CLOSING_STATE:
                System.err.println("已经是关门状态了");
                Thread.sleep(10);
                break;
            case RUNNING_STATE:
                System.err.println("已经是关门状态了");
                Thread.sleep(10);
                break;
            case STOPPING_STATE:
                System.err.println("已经是关门状态了");
                Thread.sleep(10);
                break;
        }
    }

    //执行开门动作
    @Override
    public void open() throws InterruptedException {
        switch (this.state) {
            case OPENING_STATE://门已经开了，不能再开门了
                System.err.println("已经是开门状态了");
                Thread.sleep(10);
                break;
            case CLOSING_STATE://关门状态，门打开:
                System.out.println("电梯门打开了。。。");
                System.out.flush();
                this.setState(OPENING_STATE);
                Thread.sleep(10);
                break;
            case RUNNING_STATE:
                System.err.println("电梯运行中还开门,不要命了");
                System.err.flush();
                Thread.sleep(10);
                break;
            case STOPPING_STATE:
                System.out.println("电梯门打开了。。。");//电梯停了，可以开门了
                System.out.flush();
                Thread.sleep(10);
                this.setState(OPENING_STATE);
                break;
        }
    }

    //执行运行动作
    @Override
    public void run() throws InterruptedException {
        switch (this.state) {
            case OPENING_STATE://电梯不能开着门就走
                System.err.println("不关门就想走,不要命了");
                Thread.sleep(10);
                break;
            case CLOSING_STATE://门关了，可以运行了
                System.out.println("电梯开始运行了。。。");
                System.out.flush();
                Thread.sleep(10);
                this.setState(RUNNING_STATE);//现在是运行状态
                break;
            case RUNNING_STATE:
                System.err.println("已经是运行状态了");
                Thread.sleep(10);
                break;
            case STOPPING_STATE:
                System.out.println("电梯开始运行了。。。");
                System.out.flush();
                Thread.sleep(10);
                this.setState(RUNNING_STATE);
                break;
        }
    }

    //执行停止动作
    @Override
    public void stop() throws InterruptedException {
        switch (this.state) {
            case OPENING_STATE: //开门的电梯已经是是停止的了(正常情况下)
                System.err.println("已经是停止状态了");
                Thread.sleep(10);
                break;
            case CLOSING_STATE://关门时才可以停止
                System.out.println("电梯停止了。。。");
                System.out.flush();
                Thread.sleep(10);
                this.setState(STOPPING_STATE);
                break;
            case RUNNING_STATE://运行时当然可以停止了
                System.out.println("电梯停止了。。。");
                System.out.flush();
                Thread.sleep(10);
                this.setState(STOPPING_STATE);
                break;
            case STOPPING_STATE:
                System.err.println("已经是停止状态了");
                Thread.sleep(10);
                break;
        }
    }
}
