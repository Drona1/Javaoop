package com.gmail.dimabah.additionally.homeworks.first.advanced;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();
        Phone phoneOne = new Phone("0951234567");
        Phone phoneTwo = new Phone("0501234567");
        phoneOne.registrationInNetwork(network);
        phoneTwo.registrationInNetwork(network);
        phoneOne.makeCall("0501234567");
        phoneTwo.makeCall("0951234567");
    }
}
