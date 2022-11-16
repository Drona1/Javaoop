package com.gmail.dimabah.homeworks.fifth.tasks.second;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 347_900; i++) {
            FinalizeDemonstration finalizeTest = new FinalizeDemonstration();
        }
    }
}
class FinalizeDemonstration{
    @Override
    protected void finalize() throws Throwable {
        try{
        }finally {
            System.out.println("finalize!");
            super.finalize();
        }
    }
}