package com.gmail.dimabah.homeworks.twelfth;

public class Main {
    public static void main(String[] args) {
        int length = 10000;
        int threadsCount = 32;
        Thread[] threads = new Thread[threadsCount];

        Integer[] array = new Integer[length];
        RaceConditionExample example = new RaceConditionExample(array);
        System.out.println("Race condition example:");
        tryToGenerateRaceCondition(threads, example::incrementWithoutSynchronized);
        showStatistic(array, threads.length);
        System.out.println();

        array = new Integer[length];
        RaceConditionExample example2 = new RaceConditionExample(array);
        System.out.println("With synchronized:");
        tryToGenerateRaceCondition(threads, example2::incrementWithSynchronized);
        showStatistic(array, threads.length);
    }

    private static void tryToGenerateRaceCondition(Thread[] threads, Runnable task) {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }
        for (Thread i : threads) {
            try {
                i.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void showStatistic(Integer[] array, int threadsCount) {
        int totalCount = 0;
        String times;
        for (int i = threadsCount; i > 0; i--) {
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
