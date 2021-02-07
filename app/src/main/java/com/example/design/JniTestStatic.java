package com.example.design;

public class JniTestStatic {

    static
    {
        System.loadLibrary("test2");
    }

    public native final void hello();

    public native String getHello();

    public native int getA(int a, int b);


}
