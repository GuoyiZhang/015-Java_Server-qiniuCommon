package pro.guoyi.qiniu.utils.response;

public class ResponseMessage {
    public static final String REQUEST_SUCCESS = "请求成功";
    public static final String REQUEST_ERROR = "请求失败";
    public static final String OPERATION_SUCCESS = "操作成功";
    public static final String OPERATION_ERROR = "操作失败";
    public static final String MES_BALANCE_ERROR = "余额不足";
    public static final String MES_ORDER_ERROR = "下单失败：订单号存在";
    public static final String MES_MAKE_ORDER_ERROR = "下单失败：服务器内部错误";
    public static final String MES_CANCEL_ORDER_ERROR = "撤单失败";
    public static final String MES_ORDER_LIST_ERROR = "获取订单列表失败";
    public static final String MES_OTC_ORDER_PAY_CONFIRM_ERROR = "法币订单支付确认失败";
    public static final String MES_OTC_ORDER_RECEIVE_CONFIRM_ERROR = "法币订单收款确认失败";
    public static final String MES_ORDER_INFO_ERROR = "获取订单详情失败";
    public static final String MES_CANCEL_ORDER_SUCCESS = "撤单成功";
    public static final String MES_MAKE_ORDER_SUCCESS = "下单成功";
    public static final String MES_REQUEST_HEADER_ERROR = "请求无效";
    public static final String MES_REQUEST_AUTH_ERROR = "Token无效";
    public static final String MES_WITHDRAW_ERROR = "提币失败";
    public static final String MES_REQUEST_ROLE_ERROR = "用户鉴权失败";
}
