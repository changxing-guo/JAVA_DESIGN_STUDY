package com.example.design.study1;

import android.telecom.Call;

/**
 * 函数回调问题分析
 */

public class Student {

    private String name = null;

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    private int callADD(int a, int b) {
        return a + b;
    }

    private int useCalculator(int a, int b) {
        return new Calculator().add(a,b);
    }

    public void fillBlank(int a, int b) {
        // 第一种方法
        //int result = callADD(a, b);
        //System.out.println(name + "心算:" + a + " + " + b + " = " + result);
        //  第二种方法
        int result = useCalculator(a,b);
        System.out.println(name + "通过计算器:" + a + " + " + b + " = " + result);
    }

    public void fillBlank(int a, int b, int result) {
        System.out.println(name + "超级计算器:" + a + " + " + b + " = " + result);
    }

    public void callHelp(int a, int b)
    {
        // 第一种回调
        //new SuperCalculator().add(a, b, this);

        // 第二种回调
        new SuperCalculator().add(a, b, new doHomeWork());
    }

    /*class SuperCalculator{
        public void add(int a,int b,Student st)
        {
            int result = a + b;
            st.fillBlank(a, b, result);
        }
    }*/

    /**
     * 实际使用中，考虑到java的单继承，以及不希望把自身太多东西暴漏给别人，这里使用从接口继承的方式配合内部类来做。
     */
    public class doHomeWork implements DoJob
    {
        @Override
        public void fillBlank(int a, int b, int result) {
            System.out.println(name + " DoJob:" + a + " + " + b + " = " + result);
        }
    }



}
