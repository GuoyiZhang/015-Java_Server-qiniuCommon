package pro.guoyi.qiniu.handler;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pro.guoyi.qiniu.utils.response.ResultStatusEnum;

/**
 * 自定制异常类
 *
 * @author Guoyi
 * @date 2019/09/15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ApiException extends RuntimeException {
    private int code;
    private String message;
    private Object data;

    public ApiException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiException(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiException(ResultStatusEnum resultStatusEnum) {
        this.code = resultStatusEnum.getCode();
        this.message = resultStatusEnum.getMessage();
    }

    public ApiException(ResultStatusEnum resultStatusEnum, Object data) {
        this.code = resultStatusEnum.getCode();
        this.message = resultStatusEnum.getMessage();
        this.data = data;
    }
}