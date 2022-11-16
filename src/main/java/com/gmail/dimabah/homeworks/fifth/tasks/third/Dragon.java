package com.gmail.dimabah.homeworks.fifth.tasks.third;

import java.util.Objects;

public class Dragon extends Animal {
    private boolean wings;
    private boolean scale;

    public Dragon(String name, int age, boolean wings, boolean scale) {
        super(name, age);
        this.wings = wings;
        this.scale = scale;
    }

    public Dragon() {
    }

    public boolean isWings() {
        return wings;
    }

    public void setWings(boolean wings) {
        this.wings = wings;
    }

    public boolean isScale() {
        return scale;
    }

    public void setScale(boolean scale) {
        this.scale = scale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dragon dragon = (Dragon) o;
        return wings == dragon.wings && scale == dragon.scale;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wings, scale);
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "wings=" + wings +
                ", scale=" + scale +
                '}';
    }

    @Override
    public void getVoice() {
        System.out.println("ROAR");
    }

    @Override
    public void showAnimal() {
        System.out.printf("name: %-15s %8d years (wings=%b, scale=%b)%n",
                getName(), getAge(), isWings(), isScale());
    }
}
