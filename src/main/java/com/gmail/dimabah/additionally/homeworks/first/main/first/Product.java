package com.gmail.dimabah.additionally.homeworks.first.main.first;

class Product {
    String pen;
    String description;
    double price;
    double weight;

    public Product(String pen,String description, double price, double weight) {
        this.pen = pen;
        this.description = description;
        this.price = price;
        this.weight = weight;
    }

    public Product(){

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPen() {
        return pen;
    }

    public void setPen(String pen) {
        this.pen = pen;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pen='" + pen + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
