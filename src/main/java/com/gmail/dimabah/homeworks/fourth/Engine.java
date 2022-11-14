package com.gmail.dimabah.homeworks.fourth;

import java.util.Objects;

public class Engine {
    private int power;
    private double fuelConsumption;

    public Engine(int power, double fuelConsumption) {
        this.power = power;
        this.fuelConsumption = fuelConsumption;
    }

    public Engine() {
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return power == engine.power && Double.compare(engine.fuelConsumption, fuelConsumption) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, fuelConsumption);
    }

    @Override
    public String toString() {
        return "Engine{" +
                "power=" + power +
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }
}
