package com.example.design.Singleton;

import android.hardware.usb.UsbInterface;

import java.util.HashMap;
import java.util.Map;

//三、登记式单例

/**
 * 登记式单例实际上维护了一组单例类的实例，将这些实例存放在一个Map（登记薄）中，对于已经登记过的实例，则从Map直接返回，
 * 对于没有登记的，则先登记，然后返回。
 */
public class Singleton3 {
    private static Map<String, Singleton3> map = new HashMap<String, Singleton3>();

    static {
        Singleton3 single = new Singleton3();
        System.out.println("static " + single.getClass().getName());
        map.put(single.getClass().getName(), single);
    }

    protected Singleton3() {
    }

    //静态工厂方法,返还此类惟一的实例
    public static Singleton3 getInstance(String name) {
        if (name == null) {
            name = Singleton3.class.getName();
            System.out.println("name == null" + "--->name=" + name);
        }
        if (map.get(name) == null) {
            try {
                map.put(name, (Singleton3) Class.forName(name).newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }

    public String about() {
        return "Hello, I am RegSingleton.";
    }
}
