package com.gmail.dimabah.homeworks.eighth;

public class Main {
    public static void main(String[] args) {
        CollectionCustom<String> list = new ArrayListCustom<>();
        System.out.println("ArrayList custom:");
        list.add("one");
        list.add("two");
        list.add("three");

        System.out.print("List: ");
        list.print();

        System.out.println("Element with '1' index: "+ list.get(1));
        list.remove(1);
        System.out.print("List after removed: ");
        list.print();
        System.out.println("\"three\" is contains: " + list.contains("three"));
        System.out.println("Size of the list: "+list.size());

        System.out.println();
        CollectionCustom<String> list2 = new LinkedListCustom<>();
        System.out.println("LinkedList custom:");
        list2.add("one");
        list2.add("two");
        list2.add("three");

        System.out.print("List: ");
        list2.print();

        System.out.println("Element with '1' index: "+ list2.get(1));
        list2.remove(1);
        System.out.print("List after removed: ");
        list2.print();
        System.out.println("\"three\" is contains: " + list2.contains("three"));
        System.out.println("Size of the list: "+list2.size());

        System.out.println();
        QueueCustom<String> list3 = new QueueCustom<>();
        System.out.println("Queue custom:");
        list3.add("one");
        list3.add("two");
        list3.add("three");

        System.out.print("Queue: ");
        list3.print();

        System.out.println("Element at the head of the queue: "+ list3.peek());
        list3.remove();
        System.out.print("Queue after removed: ");
        list3.print();
        System.out.println("\"three\" is contains: " + list3.contains("three"));
        System.out.println("Size of the queue: "+list3.size());

    }
}