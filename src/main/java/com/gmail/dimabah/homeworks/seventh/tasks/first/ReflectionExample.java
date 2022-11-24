package com.gmail.dimabah.homeworks.seventh.tasks.first;

public class ReflectionExample extends Thread implements Cloneable {
    private int number;
    private String text;

    public ReflectionExample(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public ReflectionExample() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getText() throws NullPointerException {
        if (text == null) {
            throw new NullPointerException();
        }
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ReflectionExample{" +
                "number=" + number +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public void run() {
        for (int i = 0; i < number; i++) {
            System.out.println(text + " " + i);
        }
    }
}
