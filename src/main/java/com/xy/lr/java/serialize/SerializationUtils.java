package com.xy.lr.java.serialize;

import java.io.*;

/**
 * Created by xylr on 16-3-25.
 */
public class SerializationUtils {
    /**
     * 序列化
     * @param s
     * @param name
     */
    public static void writeObject(Serializable s, String name){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(name));
            oos.writeObject(s);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化
     * @param name
     * @return
     */
    public static Object readObject(String name) {
        Object obj = null;
        try {
            ObjectInput input = new ObjectInputStream(new FileInputStream(name));

            obj = input.readObject();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
