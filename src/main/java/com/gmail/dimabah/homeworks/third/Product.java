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
        return "class Product [" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                " pcs., price=" + price +
                "$, category='" + category + '\''+"]";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product prod = (Product) o;
        if (name == null || !name.equals(prod.getName())) return false;
        if (price!= prod.getPrice()) return false;
        if (category!=null || category!=prod.getCategory()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + hashCodeFromSting(name);

        long temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        if (category != null) {
            result = 31 * result + hashCodeFromSting(category.name());
        }
        return result;
    }

    private int hashCodeFromSting(String text) {
        int result = 1;
        if (text == null) {
            return 0;
        } else {
            for (int i = 0; i < text.length(); i++) {
                result = 31 * result + text.charAt(i);
            }
        }
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public abstract String useProduct();

    public abstract void showProduct(int number);

    public abstract void showHeader();

}
