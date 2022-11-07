package com.gmail.dimabah.additionally.homeworks.first.advanced;

public class Phone {
    private String number;
    private Network network;

    public Phone(String number) {
        this.number = number;
    }

    public Phone() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Network getNetwork() {
        return network;
    }


    public void registrationInNetwork(Network network) {
        boolean result = network.regInNetwork(number, this);
        if (!result) {
            System.out.println("Connection error. Wrong number");
            this.network = null;
        } else {
            this.network = network;
        }
    }

    public void makeCall(String number) {
        if (network == null) {
            System.out.println("Connection error. Try to connect to network again");
            return;
        }
        if (network.checkForNumber(this.number) == null) {
            System.out.println("Connection error." +
                    " Your number haven't connected to the network");
            return;
        }
        Phone opponentPhone = network.checkForNumber(number);
        if (opponentPhone == null) {
            System.out.println("Connection error." +
                    " Your opponent haven't connected to the network");
        } else {
            opponentPhone.hasCall(this.number);
        }


    }

    private void hasCall(String number) {
        System.out.println("You (number: " + this.number +
                ") have call from number " + number);
    }
}
