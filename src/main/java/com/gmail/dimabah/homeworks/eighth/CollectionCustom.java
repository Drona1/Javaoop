package com.gmail.dimabah.homeworks.eighth;

public interface CollectionCustom<T> extends Iterable<T>{
    boolean add(T data);
    boolean add(T data, int index);

    boolean remove(int index);

    T get(int index);

    void print();

    boolean contains(T data);
    int size();

    int hashCode();

    boolean equals(Object o);
}
