package com.studyProject.demos.DesignPattern.Creational.Builder;

//建造者模式
public class Client {
    public static void main(String[] args) {
        buildComputer(new DellBuilder());
        buildComputer(new LenovoBuilder());
        Computer myComputer = new Computer.Builder()
                .CPU("huice")
                .videoCard("huice")
                .memory("huice")
                .disk("huice")
                .mainBoard("huice")
                .build();
        System.out.println(myComputer);
    }
    private static void buildComputer(Builder builder) {
        Director director = new Director(builder);
        Computer computer = director.construct();
        System.out.println(computer);
    }
}
