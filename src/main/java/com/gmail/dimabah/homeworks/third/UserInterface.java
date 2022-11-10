package com.gmail.dimabah.homeworks.third;

import java.util.Scanner;

public class UserInterface {
    private Store store;
    private Customer customer;
    private PaymentSystem paymentSystem;

    public UserInterface(Store store, Customer customer, PaymentSystem paymentSystem) {
        this.store = store;
        this.customer = customer;
        this.paymentSystem = paymentSystem;
    }

    public UserInterface() {
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PaymentSystem getPaymentSystem() {
        return paymentSystem;
    }

    public void setPaymentSystem(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    @Override
    public String toString() {
        return "UserInterface{" +
                "store=" + store +
                ", customer=" + customer +
                ", paymentSystem=" + paymentSystem +
                '}';
    }

    public void showInterface() {
        int category = 0;
        int index = 0;
        int amount = 0;
        String command = "";
        try (Scanner sc = new Scanner(System.in)) {
            for (; ; ) {
                customer.showCategories(store);
                category = quireInt(sc) - 1;
                if (category == -1) {
                    return;
                }
                do {
                    customer.showAssortment(store, category);
                    index = quireInt(sc) - 1;
                    if (index == -1) {
                        break;
                    }
                    System.out.println("how many do you need?");
                    amount = quireInt(sc);
                    buyProduct(index, category, amount);
                    command = quireString(sc);
                    if (command.equals("no")) {
                        customer.showShoppingCart();
                        switch (quirePay(sc)) {
                            case ("yes") -> {
                                paymentSystem.payProduct(customer, store);
                                customer.showBoughtProducts();
                                return;
                            }
                            case ("no") -> store.clearShoppingCart();
                            case ("0") -> command = "";
                        }
                    }
                } while (!command.equals("0"));
            }
        }
    }

    private int quireInt(Scanner sc) {
        int input = -1;
        while (input < 0) {
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                sc.nextLine();
                return input;
            } else {
                System.out.println("Wrong data, try again");
                sc.nextLine();
            }
        }
        return 0;
    }

    private String quireString(Scanner sc) {
        System.out.println("Do you want to continue shopping?");
        System.out.println("'yes' - to continue, 'no' - to place an order, '0' to return");
        return sc.nextLine();
    }

    private String quirePay(Scanner sc) {
        System.out.println("Do you want to pay for this order?");
        System.out.println("'yes' - pay, 'no' - empty the Shopping Car, '0' to return");
        return sc.nextLine();
    }

    private void buyProduct(int index, int category, int amount) {
        int cout = -1;
        for (var i : store.getProducts()) {
            if (i.getCategory().ordinal() == category) {
                cout++;
            }
            if (cout == index) {
                customer.buyProduct(store, i.getName(), amount);
                break;
            }
        }
    }

}
