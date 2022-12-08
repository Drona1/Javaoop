package com.gmail.dimabah.homeworks.eleventh.first;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File from = new File("text.txt");
        File to = new File("copy\\");
        Path path = Paths.get(to.getAbsolutePath());
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String extension = from.getName().substring(from.getName().lastIndexOf('.'));
        System.out.printf("Initial file: %s%n%n", from.getAbsolutePath());
        System.out.printf("%-15s%23s  %s%n",
                "Class:", "Elapsed time:", "File copy:");

        String name;
        printStat(name = "FileInputStream",
                copyFileUsingFileInputStream(from, to, name + extension),
                to.getAbsolutePath() + name + extension);
        printStat(name = "FileReader",
                copyFileUsingFileReader(from, to, name + extension),
                to.getAbsolutePath() + name + extension);
        printStat(name = "BufferedReader",
                copyFileUsingBufferedReader(from, to, name + extension),
                to.getAbsolutePath() + name + extension);
        printStat(name = "Scanner",
                copyFileUsingScanner(from, to, name + extension),
                to.getAbsolutePath() + name + extension);
    }

    private static void printStat(String name, long time, String to) {
        System.out.printf("%-15s%,20d %-3s %s%n", name, time, "ns", to);
    }

    private static long copyFileUsingFileInputStream(File from, File to, String name) {
        long startTime = System.nanoTime();
        try (FileInputStream fileIn = new FileInputStream(from);
             FileOutputStream fileOut = new FileOutputStream(to + name)) {
            byte[] buffer = new byte[1024];
            int readByte;
            while ((readByte = fileIn.read(buffer)) != -1) {
                fileOut.write(buffer, 0, readByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }

    private static long copyFileUsingFileReader(File from, File to, String name) {
        long startTime = System.nanoTime();
        try (FileReader fileIn = new FileReader(from);
             FileWriter fileOut = new FileWriter(to + name)) {
            int readChar;
            while ((readChar = fileIn.read()) != -1) {
                fileOut.write(readChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }

    private static long copyFileUsingBufferedReader(File from, File to, String name) {
        long startTime = System.nanoTime();
        try (BufferedReader fileIn = new BufferedReader(new FileReader(from));
             BufferedWriter fileOut = new BufferedWriter(new FileWriter(to + name))) {
            String readLine = fileIn.readLine();
            while (readLine != null) {
                fileOut.write(readLine);
                readLine = fileIn.readLine();
                if (readLine != null) {
                    fileOut.write(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }

    private static long copyFileUsingScanner(File from, File to, String name) {
        long startTime = System.nanoTime();
        try (Scanner fileIn = new Scanner(from);
             PrintWriter fileOut = new PrintWriter(to + name)) {
            while (fileIn.hasNextLine()) {
                fileOut.print(fileIn.nextLine());
                if (fileIn.hasNextLine()) {
                    fileOut.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }
}
