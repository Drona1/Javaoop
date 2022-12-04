package com.gmail.dimabah.homeworks.eighth;


import java.util.Iterator;
import java.util.Objects;

public class LinkedListCustom<T> implements CollectionCustom<T> {
    private int size = 0;
    private Element<T> first;
    private Element<T> last;

    public LinkedListCustom() {
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

    public T getFirst() {
        if (first == null) {
            return null;
        }
        return first.value;
    }

    public T getLast() {
        if (last == null) {
            return null;
        }
        return last.value;
    }

    @Override
    public boolean add(T data) {
        if (size == 0) {
            first = new Element<>(data, null, null);
            last = first;
        } else {
            last = new Element<>(data, last, null);
            last.previous.next = last;
        }
        size++;
        return true;
    }

    public boolean add(T data, int index) {
        if (isOutIndex(index)) {
            throw new IndexOutOfBoundsException("Index " + index + " doesn't exist in list");
        }
        if (index == 0) {
            first.previous = new Element<>(data, null, first);
            first = first.previous;
        } else {
            Element<T> current;
            Element<T> newElement;
            current = findElement(index);
            newElement = new Element<>(data, current.previous, current);
            if (current.previous != null) {
                current.previous.next = newElement;
            }
            current.previous = newElement;
        }
        size++;
        return true;
    }

    private Element<T> findElement(int index) {
        if (size / 2 >= index) {
            return findElementLeft(index);
        } else {
            return findElementRight(index);
        }
    }

    private Element<T> findElementLeft(int index) {
        Element<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private Element<T> findElementRight(int index) {
        Element<T> current = last;
        for (int i = size - 1; i > index; i--) {
            current = current.previous;
        }
        return current;
    }

    @Override
    public boolean remove(int index) {
        if (isOutIndex(index)) {
            throw new IndexOutOfBoundsException("Index " + index + " doesn't exist in list");
        }
        if (index == 0) {
            first = first.next;
            if (first != null) {
                first.previous = null;
            }
        } else if (index == size - 1) {
            last = last.previous;
            last.next = null;
        } else {
            removeElement(index);
        }
        size--;
        return true;
    }

    private void removeElement(int index) {
        if (size / 2 >= index) {
            removeLeft(index);
        } else {
            removeRight(index);
        }
    }

    private void removeLeft(int index) {
        Element<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.previous.next = current.next;
        if (current.next != null) {
            current.next.previous = current.previous;
        }
    }

    private void removeRight(int index) {
        Element<T> current = last;
        for (int i = 0; i < size - index - 1; i++) {
            current = current.previous;
        }
        current.next.previous = current.previous;
        if (current.previous != null) {
            current.previous.next = current.next;
        }
    }

    private boolean isOutIndex(int index) {
        return index < 0 || index >= size;
    }

    @Override
    public T get(int index) {
        if (isOutIndex(index)) {
            throw new IndexOutOfBoundsException("Index " + index + " doesn't exist in list");
        }
        return findElement(index).value;
    }


    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public boolean contains(T data) {
        Element<T> current = first;
        for (int i = 0; i < size; i++) {
            if (data == null || current.value == null) {
                if (current.value == data) {
                    return true;
                }
            } else {
                if (current.value.equals(data)) {
                    return true;
                }
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Element<T> current = first;
        for (int i = 0; i < size; i++) {
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
        LinkedListCustom<?> that = (LinkedListCustom<?>) o;
        if (size != that.size) return false;

        Element<?> current = first;
        Element<?> objCurrent = that.first;
        for (int i = 0; i < size; i++) {
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
        Element<?> current = first;
        int result = Objects.hash(size);
        for (int i = 0; i < size; i++) {
            result = result + 31 * Objects.hash(current.value);
            current = current.next;
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListCustomIterator();
    }

    private class LinkedListCustomIterator implements Iterator<T> {
        Element<T> elementIteration = first;

        @Override
        public boolean hasNext() {
            return elementIteration != null;
        }

        @Override
        public T next() {
            Element<T> temp = elementIteration;
            elementIteration = elementIteration.next;
            return temp.value;
        }
    }
}

