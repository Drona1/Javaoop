package com.gmail.dimabah.homeworks.fifth.tasks.third;

import java.util.Objects;

public class RoadRunner extends Animal {
    private boolean hiSpeed;

    public RoadRunner(String name, int age, boolean hiSpeed) {
        super(name, age);
        this.hiSpeed = hiSpeed;
    }

    public RoadRunner() {
    }

    public boolean isHiSpeed() {
        return hiSpeed;
    }

    public void setHiSpeed(boolean hiSpeed) {
        this.hiSpeed = hiSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoadRunner that = (RoadRunner) o;
        return hiSpeed == that.hiSpeed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hiSpeed);
    }

    @Override
    public String toString() {
        return "TheRoadRunner{" +
                "hiSpeed=" + hiSpeed +
                '}';
    }

    @Override
    public void getVoice() {
        System.out.println("Beep, beep...");
    }
    @Override
    public void showAnimal() {
        System.out.printf("name: %-15s %8d years (hi-speed=%b)%n",
                getName(), getAge(), isHiSpeed());
    }
}
