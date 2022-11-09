package com.gmail.dimabah.homeworks.second;

import java.util.Arrays;
import java.util.Scanner;

public class BookingInterface {
    Cinema[] cinemas;

    public BookingInterface(Cinema... cinemas) {
        this.cinemas = cinemas;
    }

    public BookingInterface() {
    }

    public Cinema[] getCinemas() {
        return cinemas;
    }

    public void setCinemas(Cinema... cinemas) {
        this.cinemas = cinemas;
    }

    @Override
    public String toString() {
        return "BookingInterface{" +
                "cinemas=" + Arrays.toString(cinemas) +
                '}';
    }

    public void showInterface() {
        int[] res;
        if (cinemas == null) {
            System.out.println("Sorry, but we are not working right now.");
            return;
        }
        try (Scanner sc = new Scanner(System.in)) {
            int choose;
            for (; ; ) {
                showFilms();
                System.out.println("Enter the movie number, or '0'" +
                        " to select movie and seat automatically (type \"exit\" to exit)");
                choose = showDialog(sc);
                if (choose == -1) {
                    return;
                } else if (choose == 0) {
                    showResult(cinemas);
                } else {
                    for (; ; ) {
                        System.out.println(cinemas[choose - 1]);
                        cinemas[choose - 1].showSeats();
                        System.out.println("Enter row and seat " +
                                "(two numbers separated by a space)" +
                                " or enter 0 to choose automatically " +
                                "(type \"exit\" to exit or \"return\" to return)");
                        res = showDialogChooseSeats(sc, cinemas[choose - 1].getRow(),
                                cinemas[choose - 1].getSeat());
                        if (res == null) {
                            return;
                        } else if (res[0] == -1) {
                            break;
                        } else if (res[0] == 0) {
                            showResult(cinemas[choose - 1]);
                        } else {
                            showResult(cinemas[choose - 1], res);
                        }
                    }
                }
            }
        }
    }

    private void showFilms() {
        System.out.println("At the moment we have several films:");
        for (int i = 0; i < cinemas.length; i++) {
            System.out.println(i + 1 + ". " + cinemas[i].getMovie() +
                    ".\t(Hall \"" + cinemas[i].getName() + "\")\t Price: " +
                    cinemas[i].getPrice());
        }
        System.out.println();
    }

    private int showDialog(Scanner sc) {
        int result = -1;
        while (result < 0) {
            if (sc.hasNextInt()) {
                result = sc.nextInt();
                sc.nextLine();
                if (result < 0 || result > cinemas.length) {
                    System.out.println("Invalid number. Number must be between 0 and "
                            + cinemas.length + " (inclusive)");
                    result = -1;
                }
            } else {
                if (sc.nextLine().equals("exit")) {
                    return -1;
                } else {
                    System.out.println("Wrong data, try again");
                }
            }
        }
        return result;
    }

    private int[] showDialogChooseSeats(Scanner sc, int row, int seat) {
        int[] result = new int[2];
        int count = 0;
        while (count < 2) {
            if (sc.hasNextInt()) {
                result[count] = sc.nextInt();
                count++;
                if (result[0] == 0) {
                    sc.nextLine();
                    return result;
                }
                if (sc.hasNextInt()){
                    result[count] = sc.nextInt();
                    count++;
                }else{
                    System.out.println("Wrong data, try again");
                    count=0;
                }
                sc.nextLine();
            } else {
                String res = sc.nextLine();
                if (res.equals("exit")) {
                    return null;
                } else if (res.equals("return")) {
                    result[0] = -1;
                    return result;
                } else {
                    System.out.println("Wrong data, try again");
                    count = 0;
                }
            }
            if (result[0] < 0 || result[1] < 0 || result[0] > row || result[1] > seat) {
                System.out.println("Wrong seat, try again");
                count = 0;
            }
        }
        return result;
    }

    private void showResult(Cinema... arr) {
        Receipt receipt;
        if (arr.length == 1) {
            receipt = arr[0].bookSeat();
        } else {
            receipt = bookAnySeat();
        }
        if (receipt == null) {
            System.out.println("There are no seats left");
        } else {
            System.out.println("You booked the seat #" + receipt.getSeat() + " in row #"
                    + receipt.getRow() + " for \"" + receipt.getMovie() + "\"");
            System.out.println("Your " + receipt);
        }
    }

    private void showResult(Cinema cinema, int[] place) {
        Receipt receipt;
        receipt = cinema.bookSeat(place[0], place[1]);
        if (receipt == null) {
            System.out.println("This seat is already taken, choose another");
        } else {
            System.out.println("You booked the seat #" + receipt.getSeat() + " in row #"
                    + receipt.getRow() + " for \"" + receipt.getMovie() + "\"");
            System.out.println("Your " + receipt);
        }
    }


    private Receipt bookAnySeat() {
        Receipt result;
        for (Cinema cinema : cinemas) {
            result = cinema.bookSeat();
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}
