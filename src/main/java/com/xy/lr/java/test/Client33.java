package com.xy.lr.java.test;

/**
 * Created by xylr on 16-3-26.
 */
public class Client33 {
    public static void main(String[] args) {
        Base base = new Sub();
        base.doAnything();
        base.doSomething();
    }
}

class Base{
    public static void doSomething() {
        System.out.println("我是父类静态方法");
    }
    public void doAnything() {
        System.out.println("我是父类非静态方法");
    }
}
class Sub extends Base{
    public static void doSomething() {
        System.out.println("我是子类静态方法");
    }
    public void doAnything() {
        System.out.println("我是子类非静态方法");
    }
}
