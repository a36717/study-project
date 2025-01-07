package com.studyProject.demos.DesignPattern.Creational.Builder;

//指挥者类
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Computer construct() {
        builder.buildCPU();
        builder.buildVideoCard();
        builder.buildMemory();
        builder.buildDisk();
        builder.buildMainBoard();
        return builder.createComputer();
    }
}