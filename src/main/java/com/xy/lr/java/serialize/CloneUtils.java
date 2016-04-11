package com.xy.lr.java.serialize;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xylr on 16-3-26.
 */
public class CloneUtils {
  /**
   *
   * @param objs
   * @param <T>
   * @return
   */
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> List<T> clone(List<T> objs) {
        List<T> cloneObjs = new ArrayList<T>();

        for (T obj : objs)
            cloneObjs.add(clone(obj));

        return cloneObjs;
    }
  /**
   * 拷贝一个对象
   * @param obj 对象
   * @param <T> 泛型
   * @return 拷贝之后的对象
   */
  @SuppressWarnings("unchecked")
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

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
      List<String> lists = new ArrayList<String>();
      lists.add("a");
      lists.add("a");
      lists.add("a");

      List<String> obj = clone(lists);

      obj.add("b");

      System.out.println(lists.size() + "\t" + obj.size());
      clone(new Person("", new Salary(100, 100)));
  }
}
