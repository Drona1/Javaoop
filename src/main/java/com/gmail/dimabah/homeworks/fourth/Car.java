package com.gmail.dimabah.homeworks.fourth;

import java.util.Arrays;
import java.util.Objects;

public abstract class Car {
    private String name;
    private String color;
    private double price;
    private Engine engine;
    private Wheel[] wheels;
    private int seats;

    public Car(String name, String color, double price, Engine engine, Wheel[] wheels, int seats) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.engine = engine;
        this.wheels = wheels;
        this.seats = seats;
    }

    public Car(String name, String color, double price, Engine engine,  Wheel wheel, int numberOfWheels, int seats) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.engine = engine;
        this.wheels = new Wheel[numberOfWheels];
        Arrays.fill(wheels,wheel);
        this.seats = seats;
    }

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", engine=" + engine +
                ", wheels=" + Arrays.toString(wheels) +
                ", seats=" + seats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && seats == car.seats && Objects.equals(name, car.name) && Objects.equals(color, car.color) && Objects.equals(engine, car.engine) && Arrays.equals(wheels, car.wheels);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, color, price, engine, seats);
        result = 31 * result + Arrays.hashCode(wheels);
        return result;
    }

    abstract String moveCar();
}
