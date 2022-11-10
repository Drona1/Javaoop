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
        try (Scanner sc = new Scanner(System.in)) {
            for (; ; ) {
                category = quireInt(sc, customer.showCategories(store)) - 1;
                switch (category) {
                    case -1 -> {
                        customer.showBoughtProducts();
                        return;
                    }
                    case -2 -> {
                        if (dialogPay(sc)) {
                            continue;
                        }else{
                            return;
                        }
                    }
                }
                do {
                    index = quireInt(sc, customer.showAssortment(store, category)) - 1;
                    if (index == -1) {
                        break;
                    } else if (index == -2) {
                        if (dialogPay(sc)) {
                            continue;
                        }else{
                            return;
                        }
                    }
                    System.out.println("how many do you need?");
                    amount = quireInt(sc, (1 << -1) - 1);
                    buyProduct(index, category, amount);
                } while (true);
            }
        }
    }
    private int quireInt(Scanner sc, int limit) {
        int input = -1;
        while (input < 0) {
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                sc.nextLine();
                if (input < 0 || input > limit) {
                    System.out.println("Invalid value," +
                            " value must be between 0 and " + limit);
                    input = -1;
                } else {
                    return input;
                }
            } else {
                if (sc.nextLine().equals("cart")) {
                    return -1;
                }
                System.out.println("Wrong data, try again");
            }
        }
        return 0;
    }

    private boolean dialogPay(Scanner sc) {
        customer.showShoppingCart();
        System.out.println("Do you want to pay for this order?");
        System.out.println("Enter 'yes'/'y'/'pay'/'+' to pay;" +
                "         'no'/'n'/'-'/'empty' to empty the Shopping Car;" +
                "         '0' to return    'exit' to exit");

        switch (sc.nextLine()) {
            case "yes","y","pay","+" -> {
                paymentSystem.payProduct(customer, store);
                customer.showBoughtProducts();
            }
            case "no","n","-","empty" -> store.clearShoppingCart();
            case "exit" -> {customer.showBoughtProducts();
                return false;
            }
        }
        return true;
    }

    private void buyProduct(int index, int category, int amount) {
        int count = -1;
        for (var i : store.getProducts()) {
            if (i.getCategory().ordinal() == category) {
                count++;
            }
            if (count == index) {
                customer.buyProduct(store, i.getName(), amount);
                break;
            }
        }
    }

}
