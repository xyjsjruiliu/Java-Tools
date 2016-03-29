package com.xy.lr.java.tools.time;

/**
 * Created by xylr on 16-1-20.
 */
public class DateTime {
    public static void main(String[] args) {
        System.out.println(DateTime.formatTime(86400000));
        System.currentTimeMillis();
    }

    /**
     * transform the format of Millis time
     * @param time input Millis time
     * @return format time
     */
    public static String formatTime(long time) {
        int result;
        int timeMS = (int)time;
        int day = timeMS / ( 24 * 60 * 60 * 1000 );
        result = timeMS % ( 24 * 60 * 60 * 1000 );

        int hour = result / ( 60 * 60 * 1000 );
        result = result % ( 60 * 60 * 1000 );

        int minute = result / ( 60 * 1000 );
        result = result % ( 60 * 1000 );

        int second = result / ( 1000 );
        int ms = result % 1000;

        return day + " days:" + hour + " hours:" + minute + " minutes:"
                + second + " seconds:" + ms + " millis";
    }

    /**
     * 系统当前时间
     * @return 返回系统当前时间
     */
    public static long CurrentTime() {
        return System.currentTimeMillis();
    }
}
