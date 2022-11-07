package com.gmail.dimabah.additionally.homeworks.second.main;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Fish","Black", 10, "Barsic");
        Dog dog = new Dog( "Meet", "White", 15, "Barbos");
        Veterinarian veterinarian = new Veterinarian("Ay-bolit");
        System.out.println(cat);
        System.out.println(dog);
        System.out.println(cat.getVoice());
        System.out.println(dog.getVoice());
        veterinarian.treatment(cat);
    }
}
