package com.xy.lr.java.test;

/**
 * Created by xylr on 16-3-25.
 */
public class SimpleServer extends Server {
    private int port = 100;

    public SimpleServer(int port) {
        this.port = port;
    }

    protected int getPort() {
        return Math.random() > 0.5 ? port : DEFAULT_PORT;
    }
}
