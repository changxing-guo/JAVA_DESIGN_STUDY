package com.example.design.Singleton;

public class TestSingleton {
    String name = null;

    private TestSingleton() {
    }

    /**
     * 假设两个线程，线程A正在执行instance = new Instance()的操作，而线程B开始执行if（instance==null）的判断，
     * 当不存在volatile的时候，因为 new Instance()是一个非原子操作，可能发生无序写入，构造函数可能在整个对象构造完
     * 成前执行完毕，线程B可能会看到一个不完整的instance对象，因为java的某些实现会在内存中开辟一片存储对象的区域后直
     * 接返回内存的引用，所以线程B判断不为null，而这时候实际上，instance的构造函数还没有执行，从而线程b得到不完整的
     * 对象。 在 Instance 的构造函数执行之前，会在内存中开辟一片存储对象的区域后直接返回内存的引用，赋值给变量
     * instance，instance也就可能成为非 null 的，即赋值语句在对象实例化之前调用，此时别的线程得到的是一个还会初始
     * 化的对象，这样会导致系统崩溃线程B可能会看到一个不完整的instance对象，因为java的某些实现，所以线程B判断不为
     * null。从而得到不完整的对象。
     */
    private static volatile TestSingleton instance = null;

    public static TestSingleton getInstance() {
        if (instance == null) {
            synchronized (TestSingleton.class) {
                if (instance == null) {
                    instance = new TestSingleton();
                }
            }
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println("the name is " + name);
    }

}
