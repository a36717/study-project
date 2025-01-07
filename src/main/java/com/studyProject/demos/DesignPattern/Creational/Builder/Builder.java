package com.studyProject.demos.DesignPattern.Creational.Builder;

// 抽象 builder 类
public abstract class Builder {

    protected Computer computer = new Computer();

    public abstract void buildCPU();
    public abstract void buildVideoCard();
    public abstract void buildMemory();
    public abstract void buildDisk();
    public abstract void buildMainBoard();
    public abstract Computer createComputer();
}