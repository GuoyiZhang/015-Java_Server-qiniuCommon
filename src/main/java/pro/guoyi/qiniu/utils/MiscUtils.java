package pro.guoyi.qiniu.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import pro.guoyi.qiniu.utils.response.Result;

import javax.xml.bind.DatatypeConverter;
import java.util.ArrayList;
import java.util.HashMap;

import static pro.guoyi.qiniu.utils.response.ResponseCode.STATUS_PARAMETER_ERROR;


/**
 * 解析参数错误
 */
public class MiscUtils {

    static public Result getValidateError(BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            return null;

        ArrayList<Object> fieldErrors = new ArrayList<>();
        for (FieldError error : bindingResult.getFieldErrors()) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("parameterName", error.getField());
            hashMap.put("parameterMsg", error.getDefaultMessage());
            hashMap.put("rejectedValue", error.getRejectedValue());
            fieldErrors.add(hashMap);
        }
        return Result.wrapErrorResult(STATUS_PARAMETER_ERROR, "输入参数校验异常", fieldErrors);
    }

    public static String toHexString(byte[] array) {
        return DatatypeConverter.printHexBinary(array);
    }

    public static byte[] toByteArray(String s) {
        return DatatypeConverter.parseHexBinary(s);
    }
}