package com.xy.lr.java.test;

/**
 * Created by xylr on 16-3-26.
 */
public class Client41 {
}

interface Father{
    public int Strong();
}

interface Mother{
    public int kind();
}
class FatherImpl implements Father{
    public int Strong() {
        return 8;
    }
}

class MotherImpl implements Mother{

    public int kind() {
        return 8;
    }
}

class Som extends FatherImpl implements Mother{

    @Override
    public int Strong() {
        return super.Strong() + 1;
    }

    public int kind() {
        return new MotherSpecial().kind();
    }

    private class MotherSpecial extends MotherImpl {
        public int kind() {
            return super.kind() - 1;
        }
    }
}

class Daughter extends MotherImpl implements Father{

    public int Strong() {
        return new FatherImpl(){
            public int Strong(){
                return super.Strong() - 2;
            }
        }.Strong();
    }
}