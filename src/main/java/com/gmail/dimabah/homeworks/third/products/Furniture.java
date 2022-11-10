package com.gmail.dimabah.homeworks.third.products;

import com.gmail.dimabah.homeworks.third.Categories;
import com.gmail.dimabah.homeworks.third.Product;

import java.util.Objects;

public class Furniture extends Product {
    private int height;
    private int width;
    private int length;
    private String material;
    private String color;

    public Furniture(String name, int amount, double price, Categories category,
                     int height, int width, int length, String material, String color) {
        super(name, amount, price, category);
        this.height = height;
        this.width = width;
        this.length = length;
        this.material = material;
        this.color = color;
    }

    public Furniture() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", height=" + height +
                ", width=" + width +
                ", length=" + length +
                ", material=" + material +
                ", color=" + color +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Furniture furniture = (Furniture) o;
        return height == furniture.height && width == furniture.width
                && length == furniture.length && Objects.equals(material, furniture.material)
                && Objects.equals(color, furniture.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height, width, length, material, color);
    }

    @Override
    public String useProduct() {
        return "You can place it";
    }

    @Override
    public void showProduct(int number) {
        System.out.printf("%2d. %-15s %-8d %-15.2f %-10s %-10s %-7s %-7s %-7s %n",
                number, getName(), getAmount(), getPrice(), getColor(),
                getMaterial(), getWidth(), getLength(), getHeight());
    }

    @Override
    public void showHeader() {
        System.out.printf("%3s %-15s %-8s %-15s %-10s %-10s %-7s %-7s %-7s %n",
                " # ","Name", "Amount", "Unit Price", "Color", "Material", "Width", "Length", "Height");
    }
}
