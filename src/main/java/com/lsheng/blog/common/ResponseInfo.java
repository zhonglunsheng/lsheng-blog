package com.lsheng.blog.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhonglunsheng
 * @Description 响应封装类
 * @create 2020-08-02 21:21
 */
@Getter
@Setter
public class ResponseInfo <T> {
    private String code;
    private T data;
    private String msg;

    public ResponseInfo(String code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    /**
     * 默认返回成功状态
     */
    public ResponseInfo() {
        this.code = ResponseCode.SUCCESS.code;
        this.msg = ResponseCode.SUCCESS.msg;
    }

    public static <T> ResponseInfo<T> createResponseInfo(String code, T data, String msg) {
        return new ResponseInfo<>(code, data, msg);
    }

    public static <T> ResponseInfo<T> createResponseInfoByEnum(ResponseCode codeEnum, T data) {
        return new ResponseInfo<>(codeEnum.code, data, codeEnum.msg);
    }

}
