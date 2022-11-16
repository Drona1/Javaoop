package com.gmail.dimabah.homeworks.fifth.tasks.third;

import java.util.Objects;

public class Visitor {
    String name;
    double money;

    public Visitor(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public Visitor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor visitor = (Visitor) o;
        return Double.compare(visitor.money, money) == 0 && Objects.equals(name, visitor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money);
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
