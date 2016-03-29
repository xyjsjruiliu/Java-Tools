package com.xy.lr.java.test;


/**
 * Created by xylr on 16-3-25.
 */
abstract class Server {
    public final static int DEFAULT_PORT = 40000;

    public Server() {
        int port = getPort();
        System.out.println(port);
    }

    protected abstract int getPort();
}
