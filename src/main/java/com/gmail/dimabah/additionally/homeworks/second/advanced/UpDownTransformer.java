package com.gmail.dimabah.additionally.homeworks.second.advanced;

class UpDownTransformer extends TextTransformer {
    @Override
    public String transform(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <text.length() ; i++) {
            if (i%2==0) {
                sb.append(Character.toLowerCase(text.charAt(i)));
            }else {
                sb.append(Character.toUpperCase(text.charAt(i)));
            }
        }
        return  sb.toString();
    }
}
