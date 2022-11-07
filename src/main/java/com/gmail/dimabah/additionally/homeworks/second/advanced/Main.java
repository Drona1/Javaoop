package com.gmail.dimabah.additionally.homeworks.second.advanced;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        TextTransformer textTransformer = new TextTransformer();
        InverseTransformer inverseTransformer = new InverseTransformer();
        UpDownTransformer upDownTransformer = new UpDownTransformer();
        File file = new File("src/main/java/com/gmail/dimabah/" +
                "additionally/homeworks/second/advanced/text.txt");
        TextSaver textSaver = new TextSaver(upDownTransformer,file);

        textSaver.saveTextToFile("Test 123! Тест, ([])?");
    }
}
