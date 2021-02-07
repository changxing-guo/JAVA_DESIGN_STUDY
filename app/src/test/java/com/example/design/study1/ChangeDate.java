package com.example.design.study1;

public class ChangeDate {

    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public static void change(int i) {
        i = i + 10;
    }

    public void setDate(DateTest d){
        d.c = 10;
    }


    class DateTest {
        protected int c;
    }
}
