package com.xuluqin.common.exception;

/***
 * 错误码和错误信息定义类
 * 1. 错误码定义规则为 5 为数字
 * 2. 前两位表示业务场景，最后三位表示错误码。例如：100001。10:通用 001:系统未知异常
 * 3. 维护错误码后需要维护错误描述，将他们定义为枚举形式
 * 错误码列表：
 * 10: 通用
 *    001：参数格式校验
 * 11: 商品
 * 12: 订单
 * 13: 购物车
 * 14: 物流
 *
 *
 */
public enum BizCodeEnum {
    UNKNOWN(100000, "系统未知异常"),
    VAILD_EXCEPTION(100001, "参数格式校验失败"),
    SMS_CODE_EXCEPTION(100002, "验证码错误"),
    SMS_SEND_CODE_EXCEPTION(100003, "验证码发送频率太高，稍后再试"),
    USER_EXIST_EXCEPTION(100004, "用户名已存在");

    private int code;
    private String msg;
    BizCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
