package com.smile.uisizetest;

/**
 * Created by smile on 9/4/15.
 */
public class Msg {

    public static final int RECEIVED = 0;
    public static final int SEND = 1;
    public String content;
    public int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
