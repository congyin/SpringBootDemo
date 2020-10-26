package com.yc.jpa.model;

import java.util.HashMap;
import java.util.Map;

public class Result extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public Result(){
        this.put("code", 0);
        this.put("msg", "success");
    }

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static Result ok(String msg) {
        Result result = new Result();
        result.put("msg", msg);
        return result;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result Result() {
        return new Result();
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
