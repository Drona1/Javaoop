package com.gmail.dimabah.homeworks.third;

import com.gmail.dimabah.homeworks.third.interfaces.ProductManagement;

public class Manager {
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    public Manager() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                '}';
    }

    public boolean addProduct(ProductManagement pm, Product product) {
        return pm.addProduct(product);
    }

    public boolean removeProduct(ProductManagement pm, Product product) {
        return pm.removeProduct(product);
    }

    public boolean changeAmount(ProductManagement pm, Product product, int amount) {
        return pm.changeAmount(product, amount);
    }

    public boolean changePrice(ProductManagement pm, Product product, double price) {
        return pm.changePrice(product, price);
    }
}
