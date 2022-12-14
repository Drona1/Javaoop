package com.gmail.dimabah.homeworks.twelfth;

public class RaceConditionExample {
    private Integer[] array;

    public RaceConditionExample(Integer[] array) {
        this.array = array;
    }

    public Integer[] getArray() {
        return array;
    }

    public void setArray(Integer[] array) {
        this.array = array;
    }

    public synchronized void incrementWithSynchronized() {
        increment();
    }

    public void incrementWithoutSynchronized() {
        increment();
    }

    private void increment() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = 1;
            } else {
                array[i] = array[i] + 1;
            }
        }
    }
}
