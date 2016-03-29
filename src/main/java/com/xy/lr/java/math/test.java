package com.xy.lr.java.math;

/**
 * Created by xylr on 16-3-16.
 */
public class test {

    private VectorDistance a = new BinaryVectorDistance();
    public double getDistance(Double vector1, Double vector2) {
        return vector1 - vector2;
    }

    public static void main(String[] args) {
        System.out.println(new test().a instanceof VectorDistance);
    }
}
