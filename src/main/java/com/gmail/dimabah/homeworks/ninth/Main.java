package com.gmail.dimabah.homeworks.ninth;

public class Main {
    public static void main(String[] args) {
        HashSetCustom<String> set = new HashSetCustom<>();
        System.out.println("HashSet custom:");
        set.add("one");
        set.add("two");
        set.add("three");

        System.out.print("Set: ");
        set.print();

        System.out.println("Element \"one\": " + set.get("one"));
        set.remove("one");
        System.out.print("Set after removed: ");
        set.print();
        System.out.println("\"three\" is contains: " + set.contains("three"));
        System.out.println("Size of the set: " + set.getUsingSpace());

    }
}
