package edu.agic.itblog.model;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 23:12
 */
public class ReturnModel {

    private long timestamp;
    private int code;
    private String msg;
    private Object data;

    public ReturnModel() {

    }

    public ReturnModel(long timestamp, int code, String msg, Object data) {
        this.timestamp = timestamp;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}