package com.gmail.dimabah.homeworks.first;

public class Main {
    public static void main(String[] args) {
        Person personFirst = new Person("Susan", "Quatro",
                "Singer", Gender.FEMALE, 72);
        Person personSecond = new Person("Bruce", "Dickinson",
                "Pilot", Gender.MALE, 64);

        System.out.println("First person: " + personFirst);
        System.out.println("Second person: " + personSecond);
    }
}
