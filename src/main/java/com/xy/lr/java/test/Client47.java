package com.xy.lr.java.test;

/**
 * Created by xylr on 16-3-26.
 */
public class Client47 {
    public static void main(String[] args) {
        Employee e1 = new Employee("张三", 100);
        Employee e2 = new Employee("张三", 1001);
        Person47 p1 = new Person47("张三");

        System.out.println(p1.equals(e1));
        System.out.println(p1.equals(e2));
        System.out.println(e1.equals(e2));
    }
}
class Person47 {
    private String name;

    public Person47(String _name) {
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
        if(obj != null && obj.getClass() == this.getClass()) {
            Person47 p = (Person47) obj;
            if(p.getName() == null || name == null)
                return false;
            return name.equalsIgnoreCase(p.getName());
        }
        return false;
    }
}

class Employee extends Person47 {
    private int id;

    public Employee(String _name, int _id) {
        super(_name);
        id = _id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj.getClass() == this.getClass()) {
            Employee p = (Employee) obj;
            if(p.getName() == null || getName() == null)
                return false;
            return super.equals(obj) && p.getId() == id;
        }
        return false;
    }
}