package com.gmail.dimabah.additionally.homeworks.second.main;

class Dog extends Animal{
    private String name;

    public Dog(String ration, String color, int weight, String name) {
        super(ration, color, weight);
        this.name = name;
    }
    public Dog() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString()+", name = "  + name;
    }

    @Override
    public String getVoice() {
        return "bow waw";
    }

    @Override
    public void eat() {
        System.out.println("The dog is eating");
    }

    @Override
    public void sleep() {
        System.out.println("The dog is sleeping");
    }
}

