package com.example.design.study1;

import java.util.ArrayList;

public class Test_2_1
{

    // 泛型，指参数化类型的能力。可以定义带泛型类型的类或方法，随后编译器会用具体的类型来替换他

    // 优点：能够在编译时就检测出错误，而不是运行时检测出错误

    // 举个例子
    interface Comparable
    {
        public int compareTo(int o);
    }

    interface Comparable1<T>
    {
        public int compareTo(T o);
    }

    class Date implements Comparable
    {

        @Override
        public int compareTo(int o) {
            return 0;
        }
    }

    class Date1<T1> implements Comparable1<T1>
    {

        @Override
        public int compareTo(T1 o) {
            return 0;
        }
    }

    class Date2<E> implements Comparable1<E>
    {

        @Override
        public int compareTo(E o) {
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

    public void test_2_2() {
        // 泛型类型必须是引用类型，不能用基本类型int，double来替换
        // 举个例子
        //ArrayList<int>  a1 = new ArrayList<int>();    //错误的
        ArrayList<Integer> a2= new ArrayList<Integer>();
        a2.add(5); // 但是可以添加一个int的值，可以自动打包
        int b2 = a2.get(0);     // 取出来的值是integer会自动解包为int
        //Dlogv(b2);
    }

    /*
     * 泛型类可能有多个参数，应该将所有参数一起放到括号中，用逗号分隔开
     *
     */

    // 定义一个泛型类
    /*
     * GenericStack()       创建一个空栈
     * getSize() int        返回这个栈的元素个数
     * peek() E             返回这个栈的栈顶元素
     * pop() E              返回并删除这个栈顶的元素
     * push(o:E) void       向这个栈顶添加一个元素
     * isEmpty() boolean    栈是否为空
     */
    class GenericStack<E>
    {
        private ArrayList<E> list = new ArrayList<E>();

        public int getSize() {
            return list.size();
        }

        public E peek() {
            return list.get(getSize() -1);
        }

        public E pop() {
            E o = list.get(getSize() -1);
            list.remove(getSize() -1);
            return o;
        }

        public void push(E o) {
            list.add(o);
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        // 定义泛型方法
        public <E> void print(E[] list) {
            for (int i=0; i<list.length; i++) {
                //logv(list[i] + " ");
            }
        }

        // 可以将泛型指定为另外一种类型的子类型
        public <E extends Comparable> void test(){

        }
    }

    public void testGenericStack() {

        // 测试泛型类
        GenericStack<String> g1 = new GenericStack<String>();
        g1.push("1111111111");
        g1.push("2222222222");
        g1.push("3333333333");

        /*logv(" size = " + g1.getSize());
        logv(g1.pop());
        logv(g1.pop());
        logv(g1.pop());
        logv(" size = " + g1.getSize());
*/
        // 测试泛型方法
        GenericStack g2 = new GenericStack();
        Integer[] integer = {1, 2, 3, 4, 5, 6};
        String[] strings = {"7", "8", "9", "10"};
        // 为了调用泛型方法，需要将实际类型放在尖括号内作为方法名的前缀
        g2.<Integer>print(integer);
        g2.<String>print(strings);

        // 泛型类和泛型方法总结
        // 非受限泛型类型和受限类型是一样的
        // 为了定义一个类为泛型类型，需要将泛型类型放在类型之后，为了定义一个方法为泛型类型，需要将泛型类型放在
        // 方法返回类型之前 例如： <E> void man(E o1, E o2);
    }
    
}
