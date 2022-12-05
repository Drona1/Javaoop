package com.gmail.dimabah.homeworks.ninth;



import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Objects;

public class HashSetCustom<T> implements Iterable<T> {
    private int size;
    private int usingSpace = 0;
    private Element<T>[] array;

    @SuppressWarnings("unchecked")
    public HashSetCustom(int size) {
        if (isPositive(size)) {
            this.size = size;
            array = (Element<T>[]) Array.newInstance(Element.class, size);
        } else {
            size = 11;
            throw new IllegalArgumentException("Illegal size " + size);
        }
    }

    private boolean isPositive(int number) {
        return number > 0;
    }

    @SuppressWarnings("unchecked")
    public HashSetCustom() {
        size = 11;
        array = (Element<T>[]) Array.newInstance(Element.class, size);
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

    @SuppressWarnings("unchecked")
    private void resize() {
        size = size * 2 + 1;
        Element<T>[] newArr = (Element<T>[]) Array.newInstance(Element.class, size);
        usingSpace = 0;
        for (Element<T> element : array) {
            if (element != null) {
                Element<T> current = element;
                for (; current != null; current = current.next) {
                    int index = calculateIndexByHashCode(current.value);
                    if (newArr[index] == null) {
                        newArr[index] = new Element<>(current.value, null, null);
                        usingSpace++;
                    } else {
                        Element<T> currentInNewArr = newArr[index];
                        while (currentInNewArr.next != null) {
                            currentInNewArr = currentInNewArr.next;
                        }
                        currentInNewArr.next = new Element<>(current.value, currentInNewArr, null);
                    }

                }

            }
        }
        array = newArr;
    }

    public boolean add(T data) {
        if (usingSpace > size * .75d) {
            resize();
        }
        int index = calculateIndexByHashCode(data);
        if (array[index] == null) {
            array[index] = new Element<>(data, null, null);
            usingSpace++;
        } else {
            Element<T> current = array[index];
            for (; current != null; current = current.next) {
                if (isDuplicate(data, current)) {
                    return false;
                }
                if (current.next == null) {
                    current.next = new Element<>(data, current, null);
                    break;
                }
            }
        }
        return true;
    }

    private Element<T> findElement(T data) {
        int index = calculateIndexByHashCode(data);
        if (array[index] != null) {
            Element<T> current = array[index];
            for (; current != null; current = current.next) {
                if (isDuplicate(data, current)) {
                    return current;
                }
            }
        }
        return null;
    }


    private boolean isDuplicate(T data, Element<T> current) {
        if (data == null || current.value == null) {
            return current.value == data;
        } else {
            return current.value.equals(data);
        }
    }

    private int calculateIndexByHashCode(T data) {
        return Math.abs(Objects.hash(data)) % size;
    }

    public boolean remove(T data) {
        Element<T> element = findElement(data);
        if (element != null) {
            if (element.next == null && element.previous == null) {
                array[calculateIndexByHashCode(data)] = null;
                return true;
            }
            if (element.next != null) {
                if (element.previous != null) {
                    element.next.previous = element.previous;
                    element.previous.next = element.next;
                } else {
                    element.next.previous = null;
                    array[calculateIndexByHashCode(data)]=element.next;
                }
                return true;
            }
            element.previous.next = null;
            return true;
        }
        return false;
    }
    public int getSize(){
        return size;
    }
    public int getUsingSpace(){
        return usingSpace;
    }


    public T get(T data) {
        Element<T> result = findElement(data);
        if (result == null) {
            return null;
        }
        return result.value;
    }

    public boolean contains(T data) {
        return findElement(data) != null;
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Element<T> element : array) {
            if (element != null) {
                Element<T> current = element;
                sb.append("{");
                for (; current != null; current = current.next) {
                    sb.append(current.value);
                    if (current.next != null) {
                        sb.append(", ");
                    }
                }
                sb.append("}");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashSetCustom<?> that = (HashSetCustom<?>) o;
        if (size != that.size || usingSpace != that.usingSpace) return false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (that.array[i] == null) return false;
                Element<?> current = array[i];
                Element<?> objCurrent = that.array[i];
                while (current != null) {
                    if ((objCurrent.value == null && current.value != null) ||
                            (objCurrent.value != null && current.value == null) ||
                            (objCurrent.value != null && !current.value.equals(objCurrent.value))) {
                        return false;
                    }
                    current = current.next;
                    objCurrent = objCurrent.next;
                }
                if (objCurrent != null) return false;
            } else {
                if (that.array[i] != null) return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, usingSpace);
        for (Element<T> element : array) {
            if (element != null) {
                Element<?> current = element;
                for (; current != null; current = current.next) {
                    result = result * 31 + Objects.hash(current.value);
                }
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new HashSetCustomIterator();
    }

    private class HashSetCustomIterator implements Iterator<T> {
        private Element<T> elementIteration;
        private int index;

        public HashSetCustomIterator() {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    index = i + 1;
                    elementIteration = array[i];
                    break;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return elementIteration != null;
        }

        @Override
        public T next() {
            Element<T> temp = elementIteration;
            if (elementIteration.next == null) {
                if (index >= array.length) {
                    elementIteration = null;
                }
                for (int i = index; i < array.length; i++) {
                    if (array[i] != null) {
                        elementIteration = array[i];
                        index = i + 1;
                        break;
                    }
                }
            } else {
                elementIteration = elementIteration.next;
            }
            return temp.value;
        }
    }
}
