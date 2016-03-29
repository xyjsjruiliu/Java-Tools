package com.xy.lr.java.test;

/**
 * Created by xylr on 16-3-26.
 */
public class Client40 {
    public static void main(String[] args) {
        Calculator c1 = new Calculator(1, 2){
            {
                setOperator(Ops.ADD);
            }
        };
        System.out.println(c1.getResult());
    }
}
enum Ops{ADD, SUB}
class Calculator{
    private int i, j, result;

    public Calculator(){}

    public Calculator(int i, int j){
        this.i = i;
        this.j = j;
    }

    protected void setOperator(Ops _op) {
        result = _op.equals(Ops.ADD) ? i+j : i-j;
    }

    public int getResult() {
        return result;
    }
}
