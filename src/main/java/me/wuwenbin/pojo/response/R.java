package me.wuwenbin.pojo.response;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 返回Map类型，以R为返回类型
 * 参数为code，message，data
 * code：默认200为成功，500为失败，其余可以自定义。
 * Created by wuwenbin on 2017/4/18.
 */
public class R extends ConcurrentHashMap<String, Object> {


    public R() {
        put("code", ResultStatus.SUCCESS);
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static R ok() {
        return new R();
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("message", msg);
        return r;
    }

    public static R ok(String msg, Object data) {
        R r = ok(msg).put("data", data);
        return r;
    }

    public static R ok(Map<String, Object> jsonMap) {
        R r = new R();
        r.putAll(jsonMap);
        return r;
    }

    public static <T> R error(String message, T data) {
        return error(message).put("data", data);
    }

    public static R error(String message) {
        return ok().put("code", ResultStatus.ERROR).put("message", message);
    }

    public static R custom(int code, String message) {
        return ok().put("code", code).put("message", message);
    }

    public static <T> R custom(int code, String message, T data) {
        return custom(code, message).put("data", data);
    }
}
