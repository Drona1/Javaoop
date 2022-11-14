package com.gmail.dimabah.homeworks.fourth;

import java.util.Arrays;
import java.util.Objects;

public class Salon {
    private String name;
    private Car[] cars;

    public Salon(String name, Car... cars) {
        this.name = name;
        this.cars = cars;
    }

    public Salon() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salon salon = (Salon) o;
        return Objects.equals(name, salon.name) && Arrays.equals(cars, salon.cars);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(cars);
        return result;
    }

    @Override
    public String toString() {
        return "Salon{" +
                "name='" + name + '\'' +
                ", cars=" + Arrays.toString(cars) +
                '}';
    }
}
