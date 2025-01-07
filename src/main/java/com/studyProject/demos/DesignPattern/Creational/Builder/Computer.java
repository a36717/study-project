package com.studyProject.demos.DesignPattern.Creational.Builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Builder
public class Computer {
    private String CPU;
    private String videoCard;
    private String memory;
    private String disk;
    private String mainBoard;
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.videoCard = builder.videoCard;
        this.memory = builder.memory;
        this.disk = builder.disk;
        this.mainBoard = builder.mainBoard;
    }
    public static final class Builder {
        private String CPU;
        private String videoCard;
        private String memory;
        private String disk;
        private String mainBoard;
        public Builder() {}
        public Builder CPU(String CPU) {
            this.CPU = CPU;
            return this;
        }
        public Builder videoCard(String videoCard) {
            this.videoCard = videoCard;
            return this;
        }
        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }
        public Builder disk(String disk) {
            this.disk = disk;
            return this;
        }
        public Builder mainBoard(String mainBoard) {
            this.mainBoard = mainBoard;
            return this;
        }
        public Computer build() {
            return new Computer(this);
        }
    }
}
