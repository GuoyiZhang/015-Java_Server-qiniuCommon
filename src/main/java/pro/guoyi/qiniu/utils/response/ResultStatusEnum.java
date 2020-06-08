package pro.guoyi.qiniu.utils.response;

/**
 * 响应结果状态枚举类
 *
 * @date 2019/11/25
 */
public enum ResultStatusEnum {
    /**
     * 请求成功
     */
    REQUEST_SUCCESS(ResponseCode.STATUS_SUCCESS, ResponseMessage.REQUEST_SUCCESS),
    /**
     * 请求失败
     */
    REQUEST_ERROR(ResponseCode.STATUS_ERROR, ResponseMessage.REQUEST_ERROR),
    /**
     * 操作成功
     */
    OPERATION_SUCCESS(ResponseCode.STATUS_SUCCESS, ResponseMessage.OPERATION_SUCCESS),
    /**
     * 操作失败
     */
    OPERATION_ERROR(ResponseCode.STATUS_ERROR, ResponseMessage.OPERATION_ERROR),
    /**
     * 参数size或page错误
     */
    SIZE_OR_PAGE_ERROR(ResponseCode.STATUS_PARAMETER_ERROR, "参数size或page错误"),

    /**
     * 密码错误
     */
    PASSWORD_NOT_MATCHING(ResponseCode.STATUS_AUTH_ERROR, "用户名或密码不正确"),

    /**
     * 密码不能为空
     */
    PASSWORD_NOT_NULL(ResponseCode.STATUS_AUTH_ERROR, "密码不能为空"),
    /**
     * 用户不存在
     */
    USER_NOT_FIND(ResponseCode.STATUS_AUTH_ERROR, "用户不存在"),
    /**
     * 登录失败
     */
    USER_LOGIN_FAIL(ResponseCode.STATUS_AUTH_ERROR, "登录失败"),
    /**
     * 重置密码失败
     */
    USER_RESET_PASSWORD_FAIL(ResponseCode.STATUS_AUTH_ERROR, "重置密码失败"),
    /**
     * 重置密码失败
     */
    USER_SET_SECURITY_FAIL(ResponseCode.STATUS_USER_SET_SECURITY_ERROR, "操作安全验证错误"),
    /**
     * 请求指纹错误
     */
    USER_FINGERPRINT_ERROR(ResponseCode.STATUS_FINGERPRINT_ERROR, "请求指纹错误"),
    /**
     * 实名认证提交错误
     */
    USER_AUTHENTICATION_ERROR(ResponseCode.STATUS_USER_AUTH_ERROR, "实名认证提交错误"),
    /**
     * 法币高级认证提交错误
     */
    USER_AUTH_SENIOR_ERROR(ResponseCode.STATUS_USER_AUTH_ERROR, "法币高级认证提交错误"),
    /**
     * 账户已被冻结
     */
    USER_LOGIN_FROZEN(ResponseCode.STATUS_AUTH_ERROR, "账户登录或安全验证错误超过5次，账户已被冻结"),
    /**
     * 余额不足
     */
    BALANCE_ERROR(ResponseCode.STATUS_BALANCE_ERROR, ResponseMessage.MES_BALANCE_ERROR),

    /**
     * 订单存在
     */
    ORDER_EXISTENCE(ResponseCode.STATUS_ORDER_ERROR, ResponseMessage.MES_ORDER_ERROR),

    /**
     * 订单下单失败
     */
    MAKE_ORDER_ERROR(ResponseCode.STATUS_MAKE_ORDER_ERROR, ResponseMessage.MES_MAKE_ORDER_ERROR),
    /**
     * 订单撤销失败
     */
    CANCEL_ORDER_ERROR(ResponseCode.STATUS_CANCEL_ORDER_ERROR, ResponseMessage.MES_CANCEL_ORDER_ERROR),
    /**
     * 订单撤销成功
     */
    CANCEL_ORDER_SUCCESS(ResponseCode.STATUS_SUCCESS, ResponseMessage.MES_CANCEL_ORDER_SUCCESS),
    /**
     * 获取订单列表失败
     */
    ORDER_LIST_ERROR(ResponseCode.STATUS_ORDER_LIST_ERROR, ResponseMessage.MES_ORDER_LIST_ERROR),
    /**
     * 获取订单列表失败
     */
    ORDER_INFO_ERROR(ResponseCode.STATUS_ORDER_INFO_ERROR, ResponseMessage.MES_ORDER_INFO_ERROR),
    /**
     * 订单下单成功
     */
    MAKE_ORDER_SUCCESS(ResponseCode.STATUS_SUCCESS, ResponseMessage.MES_MAKE_ORDER_SUCCESS),
    /**
     * 请求头验证失败
     */
    REQUEST_HEADER_ERROR(ResponseCode.STATUS_HEADER_ERROR, ResponseMessage.MES_REQUEST_HEADER_ERROR),
    /**
     * 401 token验证失败
     */
    REQUEST_AUTH_ERROR(ResponseCode.STATUS_AUTH_ERROR, ResponseMessage.MES_REQUEST_AUTH_ERROR),
    /**
     * 403 token鉴权失败
     */
    REQUEST_ROLE_ERROR(ResponseCode.STATUS_ROLE_ERROR, ResponseMessage.MES_REQUEST_ROLE_ERROR),
    /**
     * 提币失败
     */
    WITHDRAW_ERROR(ResponseCode.STATUS_WITHDRAW_ERROR, ResponseMessage.MES_WITHDRAW_ERROR),

    /**
     * 订单支付确认失败
     */
    OTC_ORDER_PAY_CONFIRM_ERROR(ResponseCode.STATUS_OTC_PAY_CONFIRM_ERROR, ResponseMessage.MES_OTC_ORDER_PAY_CONFIRM_ERROR),
    /**
     * 订单收款确认失败
     */
    OTC_ORDER_RECEIVE_CONFIRM_ERROR(ResponseCode.STATUS_OTC_RECEIVE_CONFIRM_ERROR, ResponseMessage.MES_OTC_ORDER_RECEIVE_CONFIRM_ERROR);

    private int code;

    private String message;

    ResultStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}