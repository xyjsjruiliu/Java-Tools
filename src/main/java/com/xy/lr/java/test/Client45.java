package com.xy.lr.java.test;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xylr on 16-3-26.
 */
public class Client45 {
    public static void main(String[] args) {
        Person45 p1 = new Person45("张三");
        Person45 p2 = new Person45("张三 ");

        List<Person45> l = new ArrayList<Person45>();
        l.add(p2);
        l.add(p1);

        System.out.println(l.contains(p1));
        System.out.println(l.contains(p2));
    }
}

class Person45 {
    private String name;

    public Person45(String _name) {
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
        if(obj instanceof Person45) {
            Person45 p = (Person45) obj;
//            return name.equalsIgnoreCase(p.getName().trim());
            return name.equalsIgnoreCase(p.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).toHashCode();
    }
}
