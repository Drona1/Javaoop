package com.gmail.dimabah.homeworks.fifth.tasks.third;

import java.util.Objects;

public class Unicorn extends Animal {
    private boolean horn;
    private boolean rainbow;

    public Unicorn(String name, int age, boolean horn, boolean rainbow) {
        super(name, age);
        this.horn = horn;
        this.rainbow = rainbow;
    }

    public Unicorn() {
    }

    public boolean isHorn() {
        return horn;
    }

    public void setHorn(boolean horn) {
        this.horn = horn;
    }

    public boolean isRainbow() {
        return rainbow;
    }

    public void setRainbow(boolean rainbow) {
        this.rainbow = rainbow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Unicorn unicorn = (Unicorn) o;
        return horn == unicorn.horn && rainbow == unicorn.rainbow;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), horn, rainbow);
    }

    @Override
    public String toString() {
        return "Unicorn{" +
                "horn=" + horn +
                ", rainbow=" + rainbow +
                "} super: "+ super.toString();
    }

    @Override
    public void getVoice() {
        System.out.println("snort...neigh");
    }
    @Override
    public void showAnimal() {
        System.out.printf("name: %-15s %8d years (horn=%b, rainbow=%b)%n",
                getName(), getAge(), isHorn(), isRainbow());
    }
}
