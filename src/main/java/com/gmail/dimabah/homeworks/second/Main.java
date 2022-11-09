package com.gmail.dimabah.homeworks.second;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema("Big Screen", "Metropolis", 50.0, 10, 7);
        FourDimensionalCinema fourDimensionalCinema = new FourDimensionalCinema
                ("Six Sense", "Avatar", 70.0, 5, 5, "water and wind");
        MiniCinema miniCinema = new MiniCinema
                ("Max Comfort", "To Kill a Mockingbird", 100.0, 5, 5,
                        "armchair, pillow", "beer");

        BookingInterface bookingInterface = new BookingInterface(cinema,
                fourDimensionalCinema,miniCinema);
        bookingInterface.showInterface();
    }
}
