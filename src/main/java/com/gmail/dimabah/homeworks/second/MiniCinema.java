package com.gmail.dimabah.homeworks.second;

public class MiniCinema extends Cinema {
    private String comfort;
    private String drink;

    public MiniCinema(String name, String movie, double price,
                      int row, int seat, String comfort, String drink) {
        super(name, movie, price, row, seat);
        this.comfort = comfort;
        this.drink = drink;
    }

    public MiniCinema() {
    }

    public String getComfort() {
        return comfort;
    }

    public void setComfort(String comfort) {
        this.comfort = comfort;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return super.toString() + " (comfort: " + comfort +
                "; drink = " + drink + ")";
    }

    @Override
    public Receipt bookSeat(int row, int seat) {
        Receipt receipt = super.bookSeat(row, seat);
        if (receipt == null) {
            return null;
        }
        return new Receipt(receipt,"comfort: " + comfort + "; drink = " + drink);
    }

    @Override
    public Receipt bookSeat() {
        Receipt receipt = super.bookSeat();
        if (receipt == null) {
            return null;
        }
        return new Receipt(receipt,
                "comfort: " + comfort + "; drink = " + drink);
    }
}
