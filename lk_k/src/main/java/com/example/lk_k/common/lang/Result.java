package com.example.lk_k.common.lang;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private int code;
    private String msg;
    private Object mt;

    public static Result succ(Object mt){
        return succ(200,"ok",mt);
    }
    public static Result succ(String msg,Object mt){
        return succ(200,msg,mt);
    }
    public static Result fail(String msg){
        return succ(400,msg,null);
    }
    public static Result fail(String msg,Object mt){
        return succ(400,msg,mt);
    }
    public static Result succ(int code, String msg, Object mt){
        Result r=new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setMt(mt);
        return r;
    }
    public static Result fail(int code, String msg, Object mt){
        Result r=new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setMt(mt);
        return r;
    }
}
