package com.gmail.dimabah.homeworks.first;

class Person {
    private String name;
    private String surname;
    private String occupation;
    private Gender gender;
    private int age;

    public Person(String name, String surname, String occupation, Gender gender, int age) {
        this.name = name;
        this.surname = surname;
        this.occupation = occupation;
        this.gender = gender;
        this.age = age;
    }
    public Person(){

    }

    @Override
    public String toString() {
        return  "name = " + name  +
                ", surname = " + surname +
                ", profession = " + occupation  +
                ", gender = " + gender +
                ", age = " + age;
    }
}
