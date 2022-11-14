package com.gmail.dimabah.homeworks.fourth;

import java.util.Objects;

public class Wheel {
    private int diameter;
    private int width;
    private String producer;

    public Wheel(int diameter, int width, String producer) {
        this.diameter = diameter;
        this.width = width;
        this.producer = producer;
    }

    public Wheel() {
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheel wheel = (Wheel) o;
        return diameter == wheel.diameter && width == wheel.width && Objects.equals(producer, wheel.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diameter, width, producer);
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "diameter=" + diameter +
                ", width=" + width +
                ", producer='" + producer + '\'' +
                '}';
    }
}
