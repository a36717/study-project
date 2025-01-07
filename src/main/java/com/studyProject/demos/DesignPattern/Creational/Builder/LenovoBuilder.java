package com.studyProject.demos.DesignPattern.Creational.Builder;

public class LenovoBuilder extends Builder {

    @Override
    public void buildCPU() {
        computer.setCPU("Intel");
    }

    @Override
    public void buildVideoCard() {
        computer.setVideoCard("Nvidia");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("Lenovo");
    }

    @Override
    public void buildDisk() {
        computer.setDisk("Lenovo");
    }

    @Override
    public void buildMainBoard() {
        computer.setMainBoard("Lenovo");
    }

    @Override
    public Computer createComputer() {
        return computer;
    }
}