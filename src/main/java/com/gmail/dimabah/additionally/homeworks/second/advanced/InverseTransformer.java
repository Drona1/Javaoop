package com.gmail.dimabah.additionally.homeworks.second.advanced;

class InverseTransformer extends TextTransformer{
    public InverseTransformer() {
    }

    @Override
    public String transform(String text) {
        StringBuilder sb = new StringBuilder(text);
        sb.reverse();
        return sb.toString();
    }
}
