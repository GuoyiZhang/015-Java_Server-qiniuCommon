package pro.guoyi.qiniu.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;
import static pro.guoyi.qiniu.utils.response.ResponseCode.*;

import pro.guoyi.qiniu.utils.MiscUtils;
import pro.guoyi.qiniu.utils.response.*;

//表明这是控制器的异常处理类
@ControllerAdvice
@Slf4j
public class GlobalErrorHandler {

    /**
     * 接口异常报错直接返回
     *
     * @param e 错误详情
     * @return Result
     */
    @ResponseBody
    @ResponseStatus(value = OK)
    @ExceptionHandler(value = ApiException.class)
    public Result apiExceptionHandler(ApiException e) {
        log.warn("ApiException:异常详情", e);
        //这里可以加上我们其他的异常处理代码，比如日志记录
        return Result.wrapErrorResult(e.getCode(), e.getMessage(), e.getData());
    }

    /**
     * 输入参数校验异常
     */
    @ResponseBody
    @ResponseStatus(value = OK)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Result NotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.warn("异常详情", e);
        BindingResult bindingResult = e.getBindingResult();
        return MiscUtils.getValidateError(bindingResult);
    }

    /**
     * 输入参数未找到
     */
    @ResponseBody
    @ResponseStatus(value = OK)
    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public Result NotFoundExceptionHandler(MissingServletRequestParameterException e) {
        log.warn("异常详情", e);
        String parameterName = e.getParameterName();
        String parameterType = e.getParameterType();
        String message = e.getMessage();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("parameterName", parameterName);
        hashMap.put("parameterType", parameterType);
        hashMap.put("errorMessage", message);
        return Result.wrapErrorResult(STATUS_PARAMETER_NOTFOUND_ERROR, "输入参数未找到", hashMap);
    }

    /**
     * 404异常处理
     */
    @ResponseBody
    @ResponseStatus(value = NOT_FOUND)
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public Result NoHandlerFoundExceptionHandler(Exception e) {
        log.error("异常详情: NoHandlerFoundException", e);
        return Result.wrapErrorResult(STATUS_NOT_FOUND, "页面不存在", e.getMessage());
    }

    /**
     * 默认异常处理，前面未处理
     *
     * @param e 异常
     * @return Result
     */
    @ResponseBody
    @ResponseStatus(value = INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {Exception.class, Throwable.class})
    public Result defaultHandler(Exception e) {
        log.error("异常详情：Exception", e);
        Map<String, Object> data = new HashMap<>();
        data.put("msg", e.getMessage());
        data.put("msgDetail", e.toString());
        //这里可以加上我们其他的异常处理代码，比如日志记录，，，
        return Result.wrapErrorResult(STATUS_INTERNAL_SERVER_ERROR, "服务器内部错误", data);
    }
}