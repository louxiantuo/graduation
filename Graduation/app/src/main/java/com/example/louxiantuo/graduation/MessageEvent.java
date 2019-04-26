package com.example.louxiantuo.graduation;

/**
 * Created by louxiantuo on 19-3-20.
 */

public class MessageEvent {
    private int id;
    private String message;
    private Object obj;

    public MessageEvent(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
