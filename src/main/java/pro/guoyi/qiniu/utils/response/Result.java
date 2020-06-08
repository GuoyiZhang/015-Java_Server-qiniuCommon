package pro.guoyi.qiniu.utils.response;


import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private int code = 0;
    private boolean success = false;
    private String message = "";
    private T data = null;

    public Result() {
    }

    public static <T> Result<T> wrapSuccessfulResult(T data) {
        Result<T> result = new Result<T>();
        result.data = data;
        result.success = true;
        result.code = 200;
        result.message = ResponseMessage.REQUEST_SUCCESS;
        return result;
    }

    public static <T> Result<T> wrapSuccessfulResult(ResultStatusEnum resultStatusEnum, T data) {
        Result<T> result = new Result<T>();
        result.data = data;
        result.success = true;
        result.message = resultStatusEnum.getMessage();
        result.code = 200;
        return result;
    }


    public static <T> Result<T> wrapSuccessfulResult(String message) {
        Result<T> result = new Result<T>();
        result.message = message;
        result.data = null;
        result.success = true;
        result.code = 200;
        return result;
    }

    public static <T> Result<T> wrapSuccessfulResult() {
        Result<T> result = new Result<T>();
        result.data = null;
        result.success = true;
        result.code = 200;
        return result;
    }

    public static <T> Result<T> wrapSuccessfulResult(String message, T data) {
        Result<T> result = new Result<T>();
        result.data = data;
        result.success = true;
        result.code = 200;
        result.message = message;
        return result;
    }

    public static <T> Result<T> wrapErrorResult(String message) {
        Result<T> result = new Result<T>();
        result.success = false;
        result.data = null;
        result.code = ResponseCode.STATUS_ERROR;
        result.message = message;
        return result;
    }

    public static <T> Result<T> wrapErrorResult(T data) {
        Result<T> result = new Result<T>();
        result.data = data;
        result.success = false;
        result.code = ResponseCode.STATUS_ERROR;
        result.message = ResponseMessage.REQUEST_ERROR;
        return result;
    }

    public static <T> Result<T> wrapErrorResult(ResultStatusEnum resultStatusEnum, T data) {
        Result<T> result = new Result<T>();
        result.data = data;
        result.success = false;
        result.message = resultStatusEnum.getMessage();
        result.code = resultStatusEnum.getCode();
        return result;
    }

    public static <T> Result<T> wrapErrorResult(ResultStatusEnum resultStatusEnum) {
        Result<T> result = new Result<T>();
        result.success = false;
        result.message = resultStatusEnum.getMessage();
        result.code = resultStatusEnum.getCode();
        return result;
    }

    public static <T> Result<T> wrapErrorResult(String message, T data) {
        Result<T> result = new Result<T>();
        result.success = false;
        result.data = data;
        result.code = ResponseCode.STATUS_ERROR;
        result.message = message;
        return result;
    }

    public static <T> Result<T> wrapErrorResult(Integer code, String message) {
        Result<T> result = new Result<T>();
        result.success = false;
        result.data = null;
        result.code = code;
        result.message = message;
        return result;
    }


    public static <T> Result<T> wrapErrorResult(Integer code, String message, T data) {
        Result<T> result = new Result<T>();
        result.success = false;
        result.data = data;
        result.code = code;
        result.message = message;
        return result;
    }
}