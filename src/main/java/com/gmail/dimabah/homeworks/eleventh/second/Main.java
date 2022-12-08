package com.gmail.dimabah.homeworks.eleventh.second;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        People peopleFirst = new People("Vasiliy Lomachenko",34,61.05,true);
        People peopleSecond = new People("Oleksandr Usyk",35,100.5 ,true);
        People[] peoples = {peopleFirst,peopleSecond};

        try(ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream("peoples.ser"));
            ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream("peoples.ser"))){

            fileOut.writeObject(peoples);
            System.out.println(Arrays.toString(peoples));

            People[] peopleFromFile = (People[]) fileIn.readObject();
            System.out.println(Arrays.toString(peopleFromFile));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
