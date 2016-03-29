package com.xy.lr.java.math;

import java.util.Random;

/**
 * Created by xylr on 16-3-16.
 * Java 随机数程序
 */
public class JRandom {
    /**
     * 在 start 和 end 之间随机产生一个数字，但是不包括 end
     * @param start 开始
     * @param end 结束
     * @return 随机数字
     */
    public static int getRandomInt(int start, int end) {
        return (int)getRandomDouble(start, end);
    }

    /**
     * 在 0 和 end 之间随机产生一个数字，但是不包括 end
     * @param end 结束
     * @return 随机数字
     */
    public static int getRandomInt(int end) {
        return getRandomInt(0, end);
    }

    /**
     * 在 start 和 end 之间随机产生一个数字，但是不包括 end
     * @param start 开始
     * @param end 结束
     * @return 随机数字
     */
    public static double getRandomDouble(double start, double end) {
        Random random = new Random();

        return random.nextDouble() * (end - start) + start;
    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getRandomDouble(1,6));
        System.out.println(getRandomInt(1,6));
        System.out.println(getRandomInt(3));
    }
}
