package com.gmail.dimabah.homeworks.fourth;

public class Main {
    public static void main(String[] args) {

        SportUtilityVehicle suv = new SportUtilityVehicle("Mercedes-Benz GLE-Class", "white", 70000,
                new Engine(272, 23),
                new Wheel(18, 45, "Mercedes-Benz"), 4, 5, true);
        Limousine limousine = new Limousine("Maybach 62", "black", 100000,
                new Engine(550, 23),
                new Wheel(20, 45, "Maybach"),
                4, 5, "comfort", true);
        Limousine limousineToBuy = new Limousine("Maybach 62", "black", 100000,
                new Engine(550, 23),
                new Wheel(20, 45, "Maybach"),
                4, 5, "comfort", true);
        Salon salon = new Salon("AutoS", limousine, suv);

        System.out.println("Hello, I want to buy a car: ");
        System.out.println(limousineToBuy);
        System.out.println("Do you have the same car?");
        boolean flag = true;
        for (var car : salon.getCars()) {
            if (car.hashCode() == limousineToBuy.hashCode() && car.equals(limousineToBuy)) {
                System.out.println("Yes, we have such a car");
                System.out.println(car);
                flag = false;
            }
            if (flag){
                System.out.println("Sorry, but we don't have such a car");
            }
        }
    }
}
