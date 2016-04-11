package com.xy.lr.java.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xylr on 16-4-11.
 * com.xy.lr.java.string
 */
public class StringUtils {
  public static void main(String[] args) {
    System.out.println(match("汉子"));
  }

  /**
   * 汉子匹配
   * @param str 
   * @return 是否是汉字
   */
  public static boolean match( String str ) {
    String str1 = "[\\u4300-\\u9fa5]";
    Pattern pattern = Pattern.compile(str1);

    Matcher matcher = pattern.matcher(str);
    boolean bool = matcher.find();

    return bool;
  }
}
