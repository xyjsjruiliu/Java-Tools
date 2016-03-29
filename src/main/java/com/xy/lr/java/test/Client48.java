package com.xy.lr.java.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xylr on 16-3-26.
 */
public class Client48 {
    public static void main(String[] args) {
        Map<Person45, Object> map = new HashMap<Person45, Object>() {
            {
                put(new Person45("张三"), new Object());
            }
        };

        List<Person45> list = new ArrayList<Person45>() {
            {
                add(new Person45("张三"));
            }
        };

        boolean b1 = list.contains(new Person45("张三"));
        boolean b2 = map.containsKey(new Person45("张三"));

        System.out.println(b1);
        System.out.println(b2);
    }
}
