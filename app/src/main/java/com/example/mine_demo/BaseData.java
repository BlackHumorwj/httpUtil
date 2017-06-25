package com.example.mine_demo;

/**
 * @author ryujin
 * @version $Rev$
 * @time 2017/6/9 22:20
 * @updateAuthor $Author$
 * @updateDate $Date$
 */

public class BaseData <T>{

    private String returnMsg;
    private int returnCode;
    private String systemMsg;
    private int code;

    private T t;

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public void setSystemMsg(String systemMsg) {
        this.systemMsg = systemMsg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public String getSystemMsg() {
        return systemMsg;
    }

    public int getCode() {
        return code;
    }
}
