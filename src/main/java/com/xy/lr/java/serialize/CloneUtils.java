package com.xy.lr.java.serialize;

import java.io.*;

/**
 * Created by xylr on 16-3-26.
 */
public class CloneUtils {
    //拷贝一个对象
    public static <T extends Serializable> T clone (T obj) {
        T clonedObj = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();

            //分配内存空间，写入原始对象，生成新对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            //返回新对象，并做类型转换
            clonedObj = (T)ois.readObject();
            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clonedObj;
    }

    public static void main(String[] args) {

    }
}
