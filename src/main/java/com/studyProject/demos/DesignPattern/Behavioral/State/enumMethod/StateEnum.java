package com.studyProject.demos.DesignPattern.Behavioral.State.enumMethod;

/**
 * @Author: Seele
 * @Date: 2025/1/9 11:13
 * @Description:
 */
public enum StateEnum implements LiftState {
    FAULT{
        @Override
        public String getStatus() {
            return "故障状态";
        }

        @Override
        public void stop() {
            System.out.println("电梯已经停了");
        }

        @Override
        public void repair() {
            System.out.println("电梯修好了");
            context.setLiftState(StateEnum.CLOSING);
        }
    },
    OPENING {
        @Override
        public String getStatus() {
            return "开门状态";
        }
        @Override
        public void open() {
            System.out.println("电梯门开启...");
        }

        @Override
        public void close() {
            context.setLiftState(StateEnum.CLOSING);
            context.getLiftState().close();
        }


        @Override
        public void stop() {
            System.out.println("电梯已经停了");
        }

    },
    CLOSING {
        @Override
        public String getStatus() {
            return "关门状态";
        }
        @Override
        public void open() {
            context.setLiftState(StateEnum.OPENING);
            context.getLiftState().open();
        }

        @Override
        public void close() {
            System.out.println("电梯门关闭...");
        }

        @Override
        public void run() {
            context.setLiftState(StateEnum.RUNNING);
            context.getLiftState().run();
        }

        @Override
        public void stop() {
            context.setLiftState(StateEnum.STOPPING);
            context.getLiftState().stop();
        }

    },
    RUNNING {
        @Override
        public String getStatus() {
            return "运行状态";
        }

        @Override
        public void close() {
            System.out.println("门已经是关闭的了");
        }

        @Override
        public void run() {
            System.out.println("电梯正在运行...");
        }

        @Override
        public void stop() {
            context.setLiftState(StateEnum.STOPPING);
            context.getLiftState().stop();
        }
    },
    STOPPING {
        @Override
        public String getStatus() {
            return "停止状态";
        }

        @Override
        public void open() {
            context.setLiftState(StateEnum.OPENING);
            context.getLiftState().open();
        }

        @Override
        public void close() {
            context.setLiftState(StateEnum.CLOSING);
            context.getLiftState().close();
        }

        @Override
        public void run() {
            context.setLiftState(StateEnum.RUNNING);
            context.getLiftState().run();
        }

        @Override
        public void stop() {
            System.out.println("电梯停止了...");
        }

    };
    protected static Context context;
    public abstract String getStatus();


    @Override
    public void open(){
        System.out.println("当前电梯为"+getStatus()+",不能开门");
    }

    @Override
    public void close(){
        System.out.println("当前电梯为"+getStatus()+",不能关门");
    }

    @Override
    public void run(){
        System.out.println("当前电梯为"+getStatus()+",不能运行");
    }

    @Override
    public void stop(){
        System.out.println("当前电梯为"+getStatus()+",不能停止");
    }

    @Override
    public void setContext(Context context){StateEnum.context = context;}

    public void repair(){
        System.out.println("电梯没有坏,不用维修");
    }
}
