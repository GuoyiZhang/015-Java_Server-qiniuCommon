package pro.guoyi.qiniu.utils.response;

public class ResponseCode {
    public static final int STATUS_ERROR = -1;
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_AUTH_ERROR = 401;//用户token验证失败
    public static final int STATUS_HEADER_ERROR = 402;//用户请求无效，请求头验证失败
    public static final int STATUS_ROLE_ERROR = 403;//鉴权失败
    public static final int STATUS_NOT_FOUND = 404;//不存在
    public static final int STATUS_BALANCE_ERROR = 405;//资产问题
    public static final int STATUS_ORDER_ERROR = 406;//订单已存在
    public static final int STATUS_MAKE_ORDER_ERROR = 407;//下单失败
    public static final int STATUS_CANCEL_ORDER_ERROR = 408;//撤单失败
    public static final int STATUS_ORDER_LIST_ERROR = 409;//获取订单列表失败
    public static final int STATUS_ORDER_INFO_ERROR = 410;//获取订单列表失败
    public static final int STATUS_FINGERPRINT_ERROR = 411;//登录指纹失效或错误
    public static final int STATUS_USER_AUTH_ERROR = 412;//用户实名认证错误
    public static final int STATUS_USER_SET_SECURITY_ERROR = 413;//用户设置安全验证错误
    public static final int STATUS_WITHDRAW_ERROR = 414;//用户提币失败
    public static final int STATUS_OTC_PAY_CONFIRM_ERROR = 415;//订单支付确认失败
    public static final int STATUS_OTC_RECEIVE_CONFIRM_ERROR = 416;//订单收款确认失败
    public static final int STATUS_PARAMETER_NOTFOUND_ERROR = 421; //参数未找到错误
    public static final int STATUS_PARAMETER_ERROR = 422; //参数校验错误

    public static final int STATUS_INTERNAL_SERVER_ERROR = 500;
}
