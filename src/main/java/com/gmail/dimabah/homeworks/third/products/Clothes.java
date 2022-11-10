package com.gmail.dimabah.homeworks.third.products;

import com.gmail.dimabah.homeworks.third.Categories;
import com.gmail.dimabah.homeworks.third.Product;

public class Clothes extends Product {
    private int size;
    private String color;
    private String material;

    public Clothes(String name, int amount, double price, Categories category,
                   int size, String color, String material) {
        super(name, amount, price, category);
        this.size = size;
        this.color = color;
        this.material = material;
    }

    public Clothes() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", size=" + size +
                ", color=" + color +
                ", material=" + material +
                '}';
    }

    @Override
    public String useProduct() {
        return "You can wear it";
    }

    @Override
    public void showProduct(int number) {
        System.out.printf("%2d. %-15s %-8d %-15.2f %-6d %-10s %-10s %n",
                number, getName(), getAmount(), getPrice(), getSize(), getColor(), getMaterial());
    }

    @Override
    public void showHeader() {
        System.out.printf("%3s %-15s %-8s %-15s %-6s %-10s %-10s %n",
                " # ", "Name", "Amount", "Unit Price", "Size", "Color", "Material");
    }
}
