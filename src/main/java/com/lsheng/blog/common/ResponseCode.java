package com.lsheng.blog.common;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2020-08-02 21:23
 */
public enum ResponseCode {

    /**
     * 通用响应成功返回码
     */
    SUCCESS("0000", "操作成功"),
    LOGIN_ERROR ("5555", "登录失败"),
    ERROR("1111", "操作失败");

    String code;
    String msg;

    ResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
