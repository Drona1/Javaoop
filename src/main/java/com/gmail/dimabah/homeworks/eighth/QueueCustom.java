package com.gmail.dimabah.homeworks.eighth;

import java.util.*;

public class QueueCustom<T> {

    private Element<T> head;
    private Element<T> tail;
    private final int maxSize;
    private int currentSize;

    public QueueCustom(int size) {
        if (isPositive(size)) {
            this.maxSize = size;
        } else {
            maxSize = -1;
            throw new IllegalArgumentException("Illegal size " + size);
        }
    }

    private boolean isPositive(int number) {
        return number >= 0;
    }

    public QueueCustom() {
        maxSize = -1;
    }

    private static class Element<T> {
        T value;
        Element<T> previous;
        Element<T> next;

        public Element(T value, Element<T> previous, Element<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    public boolean add(T data) {
        if (maxSize >= 0 && isNoFreePlace()) {
            throw new IllegalStateException("The queue is full");
        }
        addElement(data);
        return true;
    }

    public boolean offer(T data) {
        if (maxSize >= 0 && isNoFreePlace()) {
            return false;
        }
        addElement(data);
        return true;
    }

    private boolean isNoFreePlace() {
        return currentSize >= maxSize;
    }

    private void addElement(T data) {
        if (currentSize == 0) {
            head = new Element<>(data, null, null);
            tail = head;

        } else {
            tail = new Element<>(data, tail, null);
            tail.previous.next = tail;
        }
        currentSize++;
    }

    public T remove() {
        if (currentSize == 0) {
            throw new NoSuchElementException("The queue is empty");
        }
        return removeElement();
    }

    public T poll() {
        if (currentSize == 0) {
            return null;
        }
        return removeElement();
    }

    private T removeElement() {
        T element = head.value;
        if (head.next != null) {
            head = head.next;
            head.previous = null;
        }
        currentSize--;
        return element;
    }

    public T element() {
        if (currentSize == 0) {
            throw new NoSuchElementException("The queue is empty");
        }
        return head.value;
    }

    public T peek() {
        if (currentSize == 0) {
            return null;
        }
        return head.value;
    }

    public int size() {
        return currentSize;
    }

    public boolean contains(T data) {
        Element<T> current = head;
        for (int i = 0; i < currentSize; i++) {
            if ((current.value!=null && current.value.equals(data)) ||
                    (current.value==null && data ==null)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Element<T> current = head;
        for (int i = 0; i < currentSize; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(current.value);
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueCustom<?> that = (QueueCustom<?>) o;
        if (maxSize != that.maxSize || currentSize != that.currentSize) return false;

        Element<?> current = head;
        Element<?> objCurrent = that.head;
        for (int i = 0; i < currentSize; i++) {
            if ((objCurrent.value == null && current.value != null) ||
                    (objCurrent.value != null && current.value == null) ||
                    (objCurrent.value != null && !current.value.equals(objCurrent.value))) {
                return false;
            }
            current = current.next;
            objCurrent = objCurrent.next;
        }
        return true;
    }

    @Override
    public int hashCode() {
        Element<?> current = head;
        int result = Objects.hash(maxSize, currentSize);
        for (int i = 0; i < currentSize; i++) {
            result = result + 31 * Objects.hash(current.value);
            current = current.next;
        }
        return result;
    }
}
