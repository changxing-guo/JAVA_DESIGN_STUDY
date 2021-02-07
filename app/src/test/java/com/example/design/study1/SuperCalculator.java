package com.example.design.study1;

public class SuperCalculator {

    public void add(int a, int b, DoJob job) {
        int result = a + b;
        job.fillBlank(a, b, result);
    }
}
