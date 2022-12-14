package com.gmail.dimabah.homeworks.third.products;

import com.gmail.dimabah.homeworks.third.Categories;
import com.gmail.dimabah.homeworks.third.Product;

import java.util.Objects;

public class Souvenir extends Product {
    private int weight;


    public Souvenir(String name, int amount, double price,
                    Categories category, int weight) {
        super(name, amount, price, category);
        this.weight = weight;
    }

    public Souvenir() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return super.toString() +
                "weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Souvenir souvenir = (Souvenir) o;
        return weight == souvenir.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }

    @Override
    public String useProduct() {
        return "You can give it";
    }

    @Override
    public void showProduct(int number) {
        System.out.printf("%2d. %-15s %-8d %-15.2f %-10d %n",
                number, getName(), getAmount(), getPrice(), getWeight());
    }

    @Override
    public void showHeader() {
        System.out.printf("%3s %-15s %-8s %-15s %-10s %n",
                " # ", "Name", "Amount", "Unit Price", "Weight");
    }
}
