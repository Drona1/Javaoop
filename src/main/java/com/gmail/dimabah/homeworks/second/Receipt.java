package com.gmail.dimabah.homeworks.second;

public class Receipt {
    private String name;
    private String movie;
    private int row;
    private int seat;
    private double price;
    private String other;

    public Receipt(String name, String movie, int row, int seat, double price) {
        this.name = name;
        this.movie = movie;
        this.row = row;
        this.seat = seat;
        this.price = price;
    }

    public Receipt(Receipt receipt, String other) {
        name = receipt.name;
        movie = receipt.movie;
        row = receipt.row;
        seat = receipt.seat;
        price = receipt.price;
        this.other = other;
    }

    public Receipt() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Receipt {Hall \"" );
        sb.append(name);
        sb.append("\". Movie = \"");
        sb.append(movie);
        sb.append(" (row=");
        sb.append(row);
        sb.append(", seat=" );
        sb.append(seat);
        sb.append("). Price=");
        sb.append(price);

        if (other != null){
            sb.append(" (");
            sb.append(other);
            sb.append(")");
        }
        sb.append("}");

        return sb.toString();
    }
}
