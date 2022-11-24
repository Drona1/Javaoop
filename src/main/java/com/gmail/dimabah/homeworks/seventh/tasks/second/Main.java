package com.gmail.dimabah.homeworks.seventh.tasks.second;

public class Main {

    public static void main(String[] args)throws Exception {
        ReflectionExapleSetValue example = new ReflectionExapleSetValue("first","second", 1);
        StringReplacer stringReplacer = new StringReplacer();

        System.out.println("before change: " + example);
        stringReplacer.hackTheObject(example);
        System.out.println("after change: " + example);
    }
}
