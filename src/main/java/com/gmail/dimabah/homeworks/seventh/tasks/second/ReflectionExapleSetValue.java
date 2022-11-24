package com.gmail.dimabah.homeworks.seventh.tasks.second;

public class ReflectionExapleSetValue {
    private String first;
    private String second;
    private final String third;
    private int fourth;

    public ReflectionExapleSetValue(String first, String second, int fourth) {
        this();
        this.first = first;
        this.second = second;
        this.fourth = fourth;
    }

    public ReflectionExapleSetValue() {
        this.third = "third";
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getThird() {
        return third;
    }

    public String getSecond() {
        return second;
    }

    public int getFourth() {
        return fourth;
    }

    @Override
    public String toString() {
        return "ReflectionExapleSetValue{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                ", third='" + third + '\'' +
                ", fourth=" + fourth +
                '}';
    }
}
