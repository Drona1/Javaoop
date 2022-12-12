package com.gmail.dimabah.homeworks.twelfth;

public class Main {
    public static void main(String[] args) {
        int length = 10000;
        int treadsCount = 32;
        Thread[] treads = new Thread[treadsCount];

        Integer[] array = new Integer[length];
        RaceConditionExample example = new RaceConditionExample(array);
        System.out.println("Race condition example:");
        tryToGenerateRaceCondition(treads,example::incrementWithoutSynchronized);
        showStatistic(array, treads.length);
        System.out.println();

        array = new Integer[length];
        RaceConditionExample example2 = new RaceConditionExample(array);
        System.out.println("With synchronized:");
        tryToGenerateRaceCondition(treads,example2::incrementWithSynchronized);
        showStatistic(array, treads.length);

    }
    private static void tryToGenerateRaceCondition(Thread[] treads,Runnable task) {
        for (int i = 0; i < treads.length; i++) {
            treads[i] = new Thread(task);
            treads[i].start();
        }
        for (Thread tread : treads) {
            try {
                tread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void showStatistic(Integer[] array, int treadsCount) {
        int totalCount = 0;
        String times;
        for (int i = treadsCount; i > 0; i--) {
            int count = 0;
            for (var j : array) {
                if (i == j) {
                    count++;
                }
            }
            if (count != 0) {
                if (count == 1) {
                    times = "time";
                } else {
                    times = "times";
                }
                System.out.printf("Value %d - %,6d %s%n", i, count, times);
                totalCount += count;
            }
            if (totalCount == array.length) {
                break;
            }
        }
    }
}
