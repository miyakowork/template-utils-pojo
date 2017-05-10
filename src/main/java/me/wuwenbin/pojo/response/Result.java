package me.wuwenbin.pojo.response;

import java.io.Serializable;
import java.util.Map;

/**
 * 返回对象
 * created by zmx on 2016/8/19, modified by wuwenbin on 2017/1/3.
 *
 * @author zhangmingxing
 * @author wuwenbin
 * @since 1.1.0
 */
public class Result<T> implements Serializable {

    /**
     * the response code
     */
    private int code;

    /**
     * whether the data is success
     */
    private boolean success;

    /**
     * the returned message
     */
    private String message;

    /**
     * the extra params apart from {@link #message}
     */
    private Map<String, String> params;

    /**
     * the returned object
     */
    private T data;

    /**
     * the base construct method
     *
     * @param #code
     * @param #params
     * @param #message
     * @param #data
     */

    public Result(int code, Map<String, String> params, String message, T data) {
        this.code = code;
        this.success = (ResultStatus.SUCCESS == code);
        this.message = message;
        this.params = params;
        this.data = data;
    }

    //some construct methods

    public Result() {
        this(ResultStatus.SUCCESS, null, null, null);
    }

    public Result(int code) {
        this(code, null, null, null);
    }

    public Result(int code, Map<String, String> params) {
        this(code, params, null, null);
    }

    public Result(int code, T data) {
        this(code, null, null, data);
    }

    public Result(int code, Map<String, String> params, T data) {
        this(code, params, null, data);
    }

    public Result(int code, String message, T data) {
        this(code, null, message, data);
    }

    public Result(boolean isSuccess, String message, T data) {
        this((isSuccess ? ResultStatus.SUCCESS : ResultStatus.ERROR), null, message, data);
    }


    //some static methods

    public static Result newResult(boolean isSuccess) {
        return new Result(isSuccess, null, null);
    }

    public static <T> Result newResult(int code, T result) {
        return new Result(code, result);
    }

    public static Result newResult(int code, Map<String, String> params) {
        return new Result(code, params, null);
    }

    public static <T> Result newResult(int code, Map<String, String> params, T result) {
        return new Result(code, params, result);
    }

    public static <T> Result newResult(int code, String message, T result) {
        return new Result(code, message, result);
    }

    public static <T> Result newResult(boolean isSuccess, String message, T result) {
        return new Result(isSuccess, message, result);
    }

    public static Result newSuccessResult() {
        return newResult(true, null, null);
    }

    public static <T> Result newSuccessResult(T result) {
        return newResult(true, null, result);
    }

    public static <T> Result newSuccessResult(String message, T result) {
        return newResult(ResultStatus.SUCCESS, message, result);
    }

    public static Result newFailureResult(String message) {
        return newResult(ResultStatus.ERROR, message, null);
    }

    public static Result newFailureResult(Map<String, Object> params) {
        return newResult(ResultStatus.ERROR, params);
    }

    //getters and setters

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
