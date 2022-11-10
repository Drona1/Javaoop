package com.gmail.dimabah.homeworks.third;

abstract public class Product implements Cloneable {
    private String name;
    private int amount;
    private double price;
    private Categories category;

    public Product(String name, int amount, double price, Categories category) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.category = category;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", category='" + category + '\'';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public abstract String useProduct();

    public abstract void showProduct(int number);

    public abstract void showHeader();

}
