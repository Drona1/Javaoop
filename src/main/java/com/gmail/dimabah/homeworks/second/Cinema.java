package com.gmail.dimabah.homeworks.second;

import java.util.Arrays;

public class Cinema {
    private String name;
    private String movie;
    private double price;
    private int row;
    private int seat;
    private boolean[][] freeSeat;

    public Cinema(String name, String movie,double price, int row, int seat) {
        this.name = name;
        this.movie = movie;
        this.price = price;
        this.row = row;
        this.seat = seat;

        freeSeat = new boolean[row][seat];
    }

    public Cinema() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
        freeSeat = new boolean[row][seat];
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
        freeSeat = new boolean[row][seat];
    }

    @Override
    public String toString() {
        return "Hall \"" +
                name +
                "\" (rows = " + row +
                ", seat =" + seat +
                " [free seat=" + row*seat +
                "]). Movie:\""+ movie + "\"";
    }

    public Receipt bookSeat(int row, int seat) {
        if (row > this.row || row < 1 || seat > this.seat || seat < 1) {
            return null;
        }
        if (!freeSeat[row-1][seat-1]) {
            freeSeat[row-1][seat-1] = true;
            return new Receipt(name,movie,row,seat,price);
        }
        return null;
    }
    public Receipt bookSeat() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <seat ; j++) {
                if (!freeSeat [i][j]){
                    freeSeat [i][j]=true;
                    return new Receipt(name,movie,i+1,j+1,price);
                }
            }
        }
        return null;
    }
}
