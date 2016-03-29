package com.xy.lr.java.test;

/**
 * Created by xylr on 16-3-26.
 */
public class Client43 {
    public static void main(String[] args) {
        Person43 f = new Person43("父亲");

        Person43 s1 = new Person43("大儿子", f);

        Person43 s2 = s1.clone();
        s2.setName("小儿子");

        s1.getFather().setName("干爹");

        System.out.println(s1.getName() + "\t" + s1.getFather().getName());
        System.out.println(s2.getName() + "\t" + s2.getFather().getName());
    }
}

class Person43 implements Cloneable{
    private String name;
    private Person43 father;

    public Person43(String _name) {
        name = _name;
    }

    public Person43(String _name, Person43 _parent) {
        name = _name;
        father = _parent;
    }
    @Override
    public Person43 clone() {
        Person43 p = null;
        try{
            p = (Person43) super.clone();

            p.setFather(new Person43(p.getFather().getName()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();;
        }
        return p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person43 getFather() {
        return father;
    }

    public void setFather(Person43 father) {
        this.father = father;
    }
}