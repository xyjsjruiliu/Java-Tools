package com.xy.lr.java.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xylr on 16-3-26.
 */
public class Client46 {
    public static void main(String[] args) {
        Person46 p1 = new Person46("张三");
        Person46 p2 = new Person46(null);

        List<Person46> l = new ArrayList<Person46>();
        l.add(p2);
        l.add(p1);

        System.out.println(l.contains(p1));
        System.out.println(l.contains(p2));
    }
}
class Person46 {
    private String name;

    public Person46(String _name) {
        name = _name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person46) {
            Person46 p = (Person46) obj;
            if(p.getName() == null || name == null)
                return false;
//            return name.equalsIgnoreCase(p.getName().trim());
            return name.equalsIgnoreCase(p.getName());
        }
        return false;
    }
}