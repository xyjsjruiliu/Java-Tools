package com.xy.lr.java.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xylr on 16-4-11.
 * com.xy.lr.java.string
 */
public class StringUtils {
  public static void main(String[] args) {
    System.out.println(ChineseMatch("10"));
  }

  /**
   * 汉子匹配
   * @param str 字符串
   * @return 如果是汉字，则为true
   */
  public static boolean ChineseMatch( String str ) {
    String str1 = "[\\u4300-\\u9fa5]";
    Pattern pattern = Pattern.compile(str1);

    Matcher matcher = pattern.matcher(str);
    boolean bool = matcher.find();

    return bool;
  }
}
