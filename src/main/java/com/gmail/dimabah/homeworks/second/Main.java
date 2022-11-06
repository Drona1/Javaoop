package com.gmail.dimabah.homeworks.second;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema("Big Screen", "Metropolis", 50.0, 10, 10);
        FourDimensionalCinema fourDimensionalCinema = new FourDimensionalCinema
                ("Six Sense", "Avatar", 70.0, 5, 5, "water and wind");
        MiniCinema miniCinema = new MiniCinema
                ("Max Comfort", "To Kill a Mockingbird", 100.0, 5, 5,
                        "armchair, pillow", "beer");

        System.out.println(cinema.bookSeat());
        System.out.println(fourDimensionalCinema.bookSeat(5, 5));
        System.out.println(miniCinema.bookSeat());
        System.out.println(bookAnySeat(cinema, fourDimensionalCinema, miniCinema));

    }

    private static Receipt bookAnySeat(Cinema... arr) {
        Receipt result;
        for (Cinema cinema : arr) {
            result = cinema.bookSeat();
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}
