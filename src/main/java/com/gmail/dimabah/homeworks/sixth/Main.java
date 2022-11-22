package com.gmail.dimabah.homeworks.sixth;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer[]> pair = new Pair<>(null, new Integer[1]);
        try {
            pair.getFirst().toLowerCase();
        } catch (NullPointerException e) {
            System.out.println("NulLPointerException example:");
            e.printStackTrace();
            sleep(100);
        }
        System.out.println();

        try {
            int i = pair.getSecond()[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException example:");
            e.printStackTrace();
            sleep(100);
        }
        System.out.println();

        try {
            Object o = pair.getSecond();
            System.out.println((String) o);
        } catch (ClassCastException e) {
            System.out.println("ClassCastException example:");
            e.printStackTrace();
        }
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
