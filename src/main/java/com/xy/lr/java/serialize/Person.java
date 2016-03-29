package com.xy.lr.java.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by xylr on 16-3-25.
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 60407L;

    private String name;

    private transient Salary salary;

    public Person(String _name, Salary _salary) {
        this.name = _name;
        this.salary = _salary;
    }

    //序列化委托方法
    private void writeObject(ObjectOutputStream out) {
        try {
            out.defaultWriteObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.writeInt(salary.getBasePay());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //反序列化委托方法
    private void readObject(ObjectInputStream in) {
        try {
            in.defaultReadObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            salary = new Salary(in.readInt(), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}
