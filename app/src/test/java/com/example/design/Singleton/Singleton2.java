package com.example.design.Singleton;


// 饿汉式单例

/**
 * 饿汉式和懒汉式区别
 *      从名字上来说，饿汉和懒汉，
 *      饿汉就是类一旦加载，就把单例初始化完成，保证getInstance的时候，单例是已经存在的了，
 *      而懒汉比较懒，只有当调用getInstance的时候，才回去初始化这个单例。
 */

/**
 * 1、线程安全：
 *      饿汉式天生就是线程安全的，可以直接用于多线程而不会出现问题，
 *      懒汉式本身是非线程安全的，为了实现线程安全有几种写法，分别是Singleton1的1、2、3，这三种实现在资源加载和性能方面
 *  有些区别。
 */
public class Singleton2 {

    private Singleton2() {
    }

    // final 如果引用时类的成员变量，则必须当场赋值，否则编译会报错
    // 表示single所指向的地址不能改变，但是指向的值可以变；即不能被重新实例化
    private static final Singleton2 single = new Singleton2();

    //静态工厂方法
    public static Singleton2 getInstance() {
        return single;
    }

    //饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的。
}
