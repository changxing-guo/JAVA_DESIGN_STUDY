package com.example.design;

import com.example.design.Singleton.Singleton3;
import com.example.design.study1.ChangeDate;
import com.example.design.study1.Student;
import com.example.design.study1.Test_2_1;

import org.junit.Test;

import java.util.Scanner;

//import static com.example.design.Util.logv;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    /*
            sytud1 : 泛型
         */
    public void test1() {
        //logv("this is a test!");
        Test_2_1 test_2_1 = new Test_2_1();
        test_2_1.testGenericStack();
    }

    //public

    public void test2(ChangeDate ch, int b_) {
        ch.setA(10);
        b_ = 20;
    }

    /**
     * 测试参数传递到底是值传递还是引用传递---1
     * 首先可以确定基本类型传递是值传递
     * 基本类型作为参数传递时，是传递值的拷贝，无论你怎么改变这个拷贝，原值是不会改变的
     */
    public void test3() {
        ChangeDate a = new ChangeDate();
        a.setA(100);
        int b = 200;
        test2(a, b);

        System.out.println(a.getA());
        System.out.println(b);
    }
    /** 打印的结果
     * 10
     * 200
     */

    /**
     * 测试参数传递到底是值传递还是引用传递---2
     * <p>
     * 这就是让人迷惑的地方，对象作为参数传递时，同样是在方法内改变了对象的值，为什么有的是改变了原对象的值，
     * 而有的并没有改变原对象的值呢？这时候究竟是“传值”还是“传引用”呢？
     */
    public void test3_1(ChangeDate ch) {
        //new操作符操作成功后总会在内存中新开辟一块存储区域, ch此时并没有指向传入的内存地址
        // 相当于C++中的引用&， c中的指针
        ch = new ChangeDate();
        ch.setA(11);

    }

    public void test4() {
        ChangeDate a = new ChangeDate();
        a.setA(100);
        test3_1(a);

        System.out.println(a.getA());
    }

    /**
     * 打印的结果
     * 100
     */

    /**
     * 学生计算加法
     * @param a
     * @param b
     */
    public void testSt(int a, int b) {
        Student student = new Student("jack");
        student.fillBlank(a, b);
    }

    /**
     * callback test
     * @param a
     * @param b
     */
    public void testSt2(int a, int b)
    {
        Student jack = new Student("jack");
        jack.callHelp(a, b);
    }

    //测试单例模式
    public void testSingle() {
        Singleton3 single3 = Singleton3.getInstance(null);
        single3.about();
    }

    //题目1：输入三个整数x,y,z，请把这三个数由小到大输出。
    public void  Max()
    {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int tmp;
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            if (a>b) {
                tmp = a;
                a = b;
                b = tmp;
            }
            if (a>c) {
                tmp = c;
                a = c;
                c = a;
            }
            if (b>c) {
                tmp = b;
                b = c;
                c = tmp;
            }

            System.out.println(" x = " + a + ", y = " + b + ", z = " + c);
        }
    }

    @Test
    public void addition_isCorrect() {
        System.out.println("this is a test");
        Max();
    }


}