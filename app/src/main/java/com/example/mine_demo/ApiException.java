package com.example.mine_demo;

/**
 * @author ryujin
 * @version $Rev$
 * @time 2017/6/10 23:31
 * @updateAuthor $Author$
 * @updateDate $Date$
 */

public class ApiException extends RuntimeException {

   private String msg;
    private int ckCode;
    public ApiException(int ckCode,String msg) {
        super(msg + "");
        this.msg = msg;
        this.ckCode = ckCode;
    }


    public String getReturnMessage(){
        return getMessage();
    }

    public int getCkCode(){
        return ckCode;
    }



}
