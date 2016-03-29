package com.xy.lr.java.map;

import java.util.*;
import org.apache.commons.io.FileUtils;
/**
 * Created by xylr on 16-3-21.
 */
public class App {
    public static void main(String[] args) {
        /*Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("1",3);
        map.put("2",2);

        System.out.println(map.containsKey("1"));

        System.out.println(map.size());

        System.out.println(map.get("3"));

        if(map.get("3") == null) {

        }

        System.out.println(map.isEmpty());

        System.out.println(map);

        for(Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }*/

        Map<Double, String> sortMap = new TreeMap<Double, String>(new Comparator<Double>() {
            public int compare(Double o1, Double o2) {
                if(o1 > o2)
                    return -1;
                else if(o1 < o2)
                    return 1;
                return 0;
            }
        });
        StringBuilder stringBuilder = new StringBuilder("奥林匹克,0.10538460474667835;赛艇,0.021696874427878626;措施,0.03852204303358941;金路,0.0260232437114771;评论,0.006837279227574691;重点,0.006586924323878603;进行,0.011743637030611525;爱好者,0.01231923962723094;路线,0.011037013397132185;错过,0.011360749597013112;网络,0.0053064708674069976");

        for (String str : stringBuilder.toString().split(";")) {
//            System.out.println(str);
            sortMap.put(Double.valueOf(str.split(",")[1]), str.split(",")[0]);
        }



        /*sortMap.put(2.0, "2.0");
        sortMap.put(1.0, "1.0");
        sortMap.put(0.1, ".01");*/

        for (Map.Entry<Double, String> entry : sortMap.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
