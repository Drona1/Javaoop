package com.gmail.dimabah.homeworks.fourth;

import java.util.Objects;

public class SportUtilityVehicle extends Car{
    private boolean fourWheelDrive;

    public SportUtilityVehicle(String name, String color, double price, Engine engine, Wheel[] wheels, int seats, boolean fourWheelDrive) {
        super(name, color, price, engine, wheels, seats);
        this.fourWheelDrive = fourWheelDrive;
    }

    public SportUtilityVehicle(String name, String color, double price, Engine engine, Wheel wheel, int numberOfWheels, int seats, boolean fourWheelDrive) {
        super(name, color, price, engine, wheel, numberOfWheels, seats);
        this.fourWheelDrive = fourWheelDrive;
    }

    public SportUtilityVehicle() {
    }

    public boolean isFourWheelDrive() {
        return fourWheelDrive;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SportUtilityVehicle that = (SportUtilityVehicle) o;
        return fourWheelDrive == that.fourWheelDrive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fourWheelDrive);
    }

    @Override
    public String toString() {
        return "SportUtilityVehicle{" +
                "fourWheelDrive=" + fourWheelDrive +
                '}'+" super: "+super.toString();
    }

    @Override
    String moveCar() {
        return "Do it everywhere!";
    }
}
