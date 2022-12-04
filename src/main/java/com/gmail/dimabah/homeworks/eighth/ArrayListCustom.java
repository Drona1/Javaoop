package com.gmail.dimabah.homeworks.eighth;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class ArrayListCustom<T> implements CollectionCustom<T> {
    private int size;
    private T[] array;
    private int currentIndex = 0;

    @SuppressWarnings("unchecked")
    public ArrayListCustom(int size) {
        if (isPositive(size)) {
            this.size = size;
            array = (T[]) (new Object[size]);
        } else {
            throw new IllegalArgumentException("Illegal size " + size);
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayListCustom() {
        size = 10;
        array = (T[]) (new Object[size]);
    }

    private boolean isPositive(int number) {
        return number >= 0;
    }

    private void expandArray() {
        size = size + (size / 2) + 1;
        array = Arrays.copyOf(array, size);
    }

    @Override
    public boolean add(T data) {
        if (currentIndex == size) {
            expandArray();
        }
        array[currentIndex] = data;
        currentIndex++;
        return true;
    }

    @Override
    public boolean add(T data, int index) {
        if (isOutIndex(index)) {
            throw new IndexOutOfBoundsException("Index " + index + " doesn't exist in list");
        }
        if (currentIndex == size) {
            expandArray();
        }
        moveArrayRight(index);
        array[index] = data;
        currentIndex++;
        return true;
    }

    @Override
    public boolean remove(int index) {
        if (isOutIndex(index)) {
            throw new IndexOutOfBoundsException("Index " + index + " doesn't exist in list");
        }
        moveArrayLeft(index);
        currentIndex--;
        return true;

    }

    private boolean isOutIndex(int index) {
        return index < 0 || index >= currentIndex;
    }

    private void moveArrayLeft(int startIndex) {
        for (int i = startIndex; i < currentIndex; i++) {
            array[i] = array[i + 1];
        }
    }

    private void moveArrayRight(int startIndex) {
        for (int i = currentIndex; i > startIndex; i--) {
            array[i] = array[i - 1];
        }
    }

    @Override
    public T get(int index) {
        if (isOutIndex(index)) {
            throw new IndexOutOfBoundsException("Index " + index + " doesn't exist in list");
        }
        return array[index];
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public boolean contains(T data) {
        for (int i = 0; i < currentIndex; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return currentIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < currentIndex; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayListCustom<?> that = (ArrayListCustom<?>) o;
        return currentIndex == that.currentIndex && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(currentIndex);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListCustomIterator();
    }

    private class ArrayListCustomIterator implements Iterator<T> {
        int indexIteration = 0;


        @Override
        public boolean hasNext() {
            return indexIteration < currentIndex;
        }

        @Override
        public T next() {
            return array[indexIteration++];
        }
    }
}
