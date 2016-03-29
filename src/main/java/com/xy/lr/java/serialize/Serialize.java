package com.xy.lr.java.serialize;

/**
 * Created by xylr on 16-3-25.
 */
public class Serialize {
    public static void main(String[] args) {
        Salary salary = new Salary(1000, 2500);

        Person person = new Person("eric", salary);

        SerializationUtils.writeObject(person, "data/Serialize/person.bin");
    }
}
