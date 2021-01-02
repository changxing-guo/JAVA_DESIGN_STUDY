package com.example.design.study1;

import static com.example.design.Util.logv;

public class Test_2_1 {

    // 泛型，指参数化类型的能力。可以定义带泛型类型的类或方法，随后编译器会用具体的类型来替换他

    // 有点：能够在编译时就检测出错误，而不是运行时检测出错误

    // 举个例子
    interface Comparable {
        public int compareTo(int o);
    }

    interface Comparable1<T> {
        public int compareTo(T o);
    }

    class Date implements Comparable{

        @Override
        public int compareTo(int o) {
            return 0;
        }
    }

    class Date1<T1> implements Comparable1<T1> {

        @Override
        public int compareTo(T1 o) {
            return 0;
        }
    }

    public void test_2_1() {
        // 第一个没有泛型，所以可以传入默认的类型object
        Comparable c1 = new Date();
        //c1.compareTo("111");
        c1.compareTo(111);

        //加了泛型，必须传入特定的类型才可以编译不报错
        Comparable1<Integer> c2 = new Date1();
        //c2.compareTo("111");
        c2.compareTo(111);
    }

}
