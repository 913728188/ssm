package com.lmf.VO;

import org.aspectj.apache.bcel.generic.RET;

/**
 * com.lmf.VO
 * <p>
 * root创建于18-6-4
 * TODO:进行描述
 **/
public class RetData {
    int code;
    String msg;
    Object Data;

    public RetData() {
        this.code = 200;
        this.msg = "success!";
    }

    public  RetData build(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.Data = data;
        return this;
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
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "RetData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", Data=" + Data +
                '}';
    }


}
