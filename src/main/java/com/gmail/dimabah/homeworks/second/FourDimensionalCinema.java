package com.gmail.dimabah.homeworks.second;

public class FourDimensionalCinema extends Cinema {
    private String effects;
    private String screen = "3D";

    public FourDimensionalCinema(String name, String movie, double price,
                                 int row, int seat, String effects) {
        super(name, movie, price, row, seat);
        this.effects = effects;
    }

    public String getEffects() {
        return effects;
    }

    public void setEffects(String effects) {
        this.effects = effects;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    @Override
    public String toString() {
        return super.toString() + " (effects: " + effects +
                "; screen = " + screen + ")";
    }

    @Override
    public Receipt bookSeat(int row, int seat) {
        return new Receipt(super.bookSeat(row, seat),
                "effects: " + effects + "; screen = " + screen);
    }

    @Override
    public Receipt bookSeat() {
        return new Receipt(super.bookSeat(),
                "effects: " + effects + "; screen = " + screen);
    }

    public void makeEffects() {
        System.out.println(effects);
    }
}
