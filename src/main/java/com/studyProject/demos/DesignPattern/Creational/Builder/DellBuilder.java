package com.studyProject.demos.DesignPattern.Creational.Builder;

public class DellBuilder extends Builder {

    @Override
    public void buildCPU() {
        computer.setCPU("AMD");
    }

    @Override
    public void buildVideoCard() {
        computer.setVideoCard("AMD");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("Dell");
    }

    @Override
    public void buildDisk() {
        computer.setDisk("Dell");
    }

    @Override
    public void buildMainBoard() {
        computer.setMainBoard("Dell");
    }

    @Override
    public Computer createComputer() {
        return computer;
    }
}