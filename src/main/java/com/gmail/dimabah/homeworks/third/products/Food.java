package com.gmail.dimabah.homeworks.third.products;

import com.gmail.dimabah.homeworks.third.Categories;
import com.gmail.dimabah.homeworks.third.Product;

import java.util.Objects;

public class Food extends Product {
    private String expirationDate;
    private int weight;

    public Food(String name, int amount, double price, Categories category,
                String expirationDate, int weight) {
        super(name, amount, price, category);
        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    public Food() {
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + ", weight=" + weight + " (expirationDate=" +
                expirationDate + ")}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Food food = (Food) o;
        return weight == food.weight && Objects.equals(expirationDate, food.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), expirationDate, weight);
    }

    @Override
    public String useProduct() {
        return "You can eat it";
    }

    @Override
    public void showProduct(int number) {
        System.out.printf("%2d. %-15s %-8d %-15.2f %-10d %-10s %n",
                number, getName(), getAmount(), getPrice(), getWeight(), getExpirationDate());
    }

    @Override
    public void showHeader() {
        System.out.printf("%3s %-15s %-8s %-15s %-10s %-10s %n",
                " # ", "Name", "Amount", "Unit Price", "Weight", "Expiration Date");
    }
}
