package com.gmail.dimabah.homeworks.fifth.tasks.third;

public class Main {
    public static void main(String[] args) {
        Dragon dragon = new Dragon("Dragon", 1000, true, true);
        RoadRunner roadRunner = new RoadRunner("Road Runner", 2, true);
        Unicorn unicorn = new Unicorn("Unicorn", 200, true, true);
        Zoo zoo = new Zoo("Miracle", 100.0, dragon, roadRunner, unicorn);
        Visitor visitor = new Visitor("Dmytro", 1000.0);

        zoo.getAccessToZoo(visitor);

    }
}
