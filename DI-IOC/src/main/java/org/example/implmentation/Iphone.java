package org.example.implmentation;

import org.example.interfaces.Phone;

public class Iphone implements Phone {
    private String color;
    private double memory;
    private String battery;
    private String producer;

    public Iphone() {
    }

    public Iphone(String color, double memory) {
        this.color = color;
        this.memory = memory;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(long memory) {
        this.memory = memory;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void init(){
        producer="Nokia";
    }
    @Override
    public boolean hasCamera() {
        return false;
    }

    @Override
    public String toString() {
        return "Iphone{" +
                "color='" + color + '\'' +
                ", memory=" + memory +
                ", battery='" + battery + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
