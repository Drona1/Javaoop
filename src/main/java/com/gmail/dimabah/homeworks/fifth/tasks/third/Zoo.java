package com.gmail.dimabah.homeworks.fifth.tasks.third;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Zoo {
    private String name;
    private Animal[] animals;
    private BigDecimal price;

    public Zoo(String name , double price, Animal...animals) {
        this.name = name;
        this.animals = animals;
        this.price = new BigDecimal(""+ price);
    }

    public Zoo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zoo zoo = (Zoo) o;
        return Objects.equals(name, zoo.name) && Arrays.equals(animals, zoo.animals) && Objects.equals(price, zoo.price);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, price);
        result = 31 * result + Arrays.hashCode(animals);
        return result;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", animals=" + Arrays.toString(animals) +
                ", price=" + price +
                '}';
    }

    public void getAccessToZoo(Visitor visitor) {
        BigDecimal money = new BigDecimal("" + visitor.getMoney());
        if (price==null || money.subtract(price).signum() !=-1) {
            if (animals!=null) {
                visitor.setMoney(money.subtract(price).doubleValue());
                dialogWithVisitor();
            }else{
                System.out.println("Sorry, there are no animals in the zoo");
            }
            System.out.println("Goodbye, " + visitor.getName() + ". Come again");
        } else {
            System.out.println("Not enough money to visit the Zoo " + name);
        }
    }

    private void dialogWithVisitor() {
        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println("Enter  'feed'  to go to feed animals," +
                        " or  'tour'  to go on a tour or  'exit'  to exit");
                String choose = sc.nextLine();
                switch (choose) {
                    case "feed" -> {
                        System.out.println("We have such animals as:");
                        for (Animal animal : animals) {
                            animal.showAnimal();
                        }
                        String animal;
                        do {
                            System.out.println("Enter name of the animal to feed it," +
                                    " or '0' \\ 'return' to return");
                            animal = sc.nextLine();
                            if (animal.equals("0") || animal.equals("return")) {
                                break;
                            }
                            feedAnimal(animal);
                        } while (true);
                    }
                    case "tour" -> feedAllAnimals();
                    case "exit" -> {
                        return;
                    }
                    default -> System.out.println("Wrong data, try again");
                }
            } while (true);
        }
    }

    private boolean feedAnimal(String name) {
        if (animals == null) {
            System.out.println("Sorry, there are no animals in the zoo");
            return false;
        }
        for (Animal animal : animals) {
            if (animal != null && animal.getName().equalsIgnoreCase(name)) {
                System.out.println("You feed " + animal.getName());
                System.out.print(animal.getName() + " makes sounds: ");
                animal.getVoice();
                System.out.println();
                return true;
            }
        }
        System.out.println(name + " not found in the zoo");
        return false;
    }

    private boolean feedAllAnimals() {
        if (animals == null) {
            System.out.println("Sorry, there are no animals in the zoo");
            return false;
        }
        System.out.println("You are on a tour");
        for (Animal animal : animals) {
            if (animal != null) {
                System.out.println("You feed " + animal.getName());
                System.out.print(animal.getName() + " makes sounds: ");
                animal.getVoice();
                System.out.println();
            }
        }
        return true;
    }
}
