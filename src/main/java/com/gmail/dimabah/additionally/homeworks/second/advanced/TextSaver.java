package com.gmail.dimabah.additionally.homeworks.second.advanced;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

class TextSaver {
    TextTransformer textTransformer;
    File file;

    public TextSaver(TextTransformer textTransformer, File file) {
        this.textTransformer = textTransformer;
        this.file = file;
    }

    public TextSaver() {
    }

    public TextTransformer getTextTransformer() {
        return textTransformer;
    }

    public void setTextTransformer(TextTransformer textTransformer) {
        this.textTransformer = textTransformer;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "TextSaver{" +
                "textTransformer=" + textTransformer +
                ", file=" + file +
                '}';
    }
    public void saveTextToFile(String text){
        try(PrintWriter pw = new PrintWriter(file)) {
            file.createNewFile();
            text = textTransformer.transform(text);
            pw.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
