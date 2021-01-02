package com.example.design;

import com.example.design.study1.Test_2_1;

import org.junit.Test;

import static com.example.design.Util.logv;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

/*
    sytud1 : 泛型
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        logv("this is a test!");
        Test_2_1 test_2_1 = new Test_2_1();
        test_2_1.testGenericStack();
    }
}