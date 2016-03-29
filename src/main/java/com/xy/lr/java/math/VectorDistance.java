package com.xy.lr.java.math;

/**
 * Created by xylr on 16-3-16.
 * 计算两个向量之间距离的接口
 */
public interface VectorDistance<T> {
    /**
     * 计算向量距离
     * @param vector1 向量1
     * @param vector2 向量2
     * @return 距离
     */
    double getDistance(T vector1, T vector2);
}
