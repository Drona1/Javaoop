package com.gmail.dimabah.homeworks.eleventh.second;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class People implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private double weight;
    private boolean live = true;
    private char firstLetter;

    public People(String name, int age, double weight, boolean live) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.live = live;
        if (name!=null) {
            firstLetter = name.toUpperCase().charAt(0);
        }
    }

    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public char getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(char firstLetter) {
        this.firstLetter = firstLetter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return age == people.age && Double.compare(people.weight, weight) == 0
                && live == people.live && firstLetter == people.firstLetter && Objects.equals(name, people.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, weight, live, firstLetter);
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", live=" + live +
                ", firstLetter=" + firstLetter +
                '}';
    }
}
