package com.xy.lr.java.serialize;

import java.io.Serializable;

/**
 * Created by xylr on 16-3-25.
 */
public class Salary implements Serializable {
    private static final long serialVersionUID = 44663L;

    private int basePay;

    private int bonus;

    public Salary(int _basePay, int _bonus){
        this.basePay = _basePay;
        this.bonus = _bonus;
    }

    public int getBasePay() {
        return basePay;
    }

    public void setBasePay(int basePay) {
        this.basePay = basePay;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
