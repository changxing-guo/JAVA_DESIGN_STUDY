package com.example.design.Singleton;

/**
 * java中单例模式是一种常见的设计模式，单例模式的写法有好几种，这里主要介绍三种：懒汉式单例、饿汉式单例、登记式单例。
 * 　　单例模式有以下特点：
 * 　　1、单例类只能有一个实例。
 * 　　2、单例类必须自己创建自己的唯一实例。
 * 　　3、单例类必须给所有其他对象提供这一实例。
 * 　　单例模式确保某个类只有一个实例，而且自行实例化并向整个系统提供这个实例。在计算机系统中，线程池、缓存、日志对象、
 * 对话框、打印机、显卡的驱动程序对象常被设计成单例。这些应用都或多或少具有资源管理器的功能。每台计算机可以有若干个打印
 * 机，但只能有一个Printer Spooler，以避免两个打印作业同时输出到打印机中。每台计算机可以有若干通信端口，系统应当集中
 * 管理这些通信端口，以避免一个通信端口同时被两个请求同时调用。总之，选择单例模式就是为了避免不一致状态，避免政出多头。
 */

//  一、懒汉式单例
public class Singleton1 {

    //事实上，通过Java反射机制是能够实例化构造方法为private的类
    private Singleton1() {
    }

    private static Singleton1 single = null;

    //静态工厂方法
    public static Singleton1 getInstance() {
        if (single == null) {
            single = new Singleton1();
        }
        return single;
    }
    /**
     * 但是以上懒汉式单例的实现没有考虑线程安全问题，它是线程不安全的，并发环境下很可能出现多个Singleton实例，要实现
     * 线程安全，有以下三种方式，都是对getInstance这个方法改造，保证了懒汉式单例的线程安全，如果你第一次接触单例模式
     * ，对线程安全不是很了解，可以先跳过下面这三小条，去看饿汉式单例，等看完后面再回头考虑线程安全的问题：
     */

    /**
     * 2、资源加载和性能：
     * 饿汉式在类创建的同时就实例化一个静态对象出来，不管之后会不会使用这个单例，都会占据一定的内存，但是相应的，
     * 在第一次调用时速度也会更快，因为其资源已经初始化完成，
     * 而懒汉式顾名思义，会延迟加载，在第一次使用该单例的时候才会实例化对象出来，第一次调用时要做初始化，如果要
     * 做的工作比较多，性能上会有些延迟，之后就和饿汉式一样了。
     */

    // 线程安全1--在getInstance方法上加同步
    public static synchronized Singleton1 getInstance1() {
        if (single == null) {
            single = new Singleton1();
        }
        return single;
    }

    // 线程安全2--双重检查锁定
    public static Singleton1 getInstance2() {
        if (single == null) {
            synchronized (Singleton1.class) {
                if (single == null) {
                    single = new Singleton1();
                }
            }
        }
        return single;
    }

    // 线程安全3--静态内部类
    private static class LazyHolder {
        private static final Singleton1 INSTANCE = new Singleton1();
    }

    public static final Singleton1 getInstance3() {
        return LazyHolder.INSTANCE;
    }

    /**
     * 至于1、2、3这三种实现又有些区别，
     * 第1种，在方法调用上加了同步，虽然线程安全了，但是每次都要同步，会影响性能，毕竟99%的情况下是不需要同步的，
     * 第2种，在getInstance中做了两次null检查，确保了只有第一次调用单例的时候才会做同步，这样也是线程安全的，同时
     * 避免了每次都同步的性能损耗
     * 第3种，利用了classloader的机制来保证初始化instance时只有一个线程，所以也是线程安全的，同时没有性能损耗，所
     * 以一般我倾向于使用这一种。
     */


}

