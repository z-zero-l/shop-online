package com.shop.shoponline.common.result;

import com.shop.shoponline.common.exception.ErrorCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


/* 接口统一响应体 */
@Data
@Schema(description = "响应数据")
public class Result<T> {
    @Schema(description = "编码 0 表示成功，其他值表示失败")
    private int code = 0;

    @Schema(description = "消息内容")
    private String msg = "success";

    @Schema(description = "响应数据")
    private T result;

    // 成功 - 不携带数据
    public static <T> Result<T> ok() {
        return ok(null);
    }

    // 成功 - 携带数据
    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setResult(data);
        return result;
    }

    // 失败 - 不携带自定义消息内容 500，服务器异常
    public static <T> Result<T> error() {
        return error(ErrorCode.INTERNAL_SERVER_ERROR);
    }

    // 失败 - 携带自定义消息内容 500，msg
    public static <T> Result<T> error(String msg) {
        return error(ErrorCode.INTERNAL_SERVER_ERROR.getCode(), msg);
    }

    // 失败 - 携带自定义code，msg
    public static <T> Result<T> error(ErrorCode errorCode) {
        return error(errorCode.getCode(), errorCode.getMsg());
    }

    // 失败 - 携带自定义code，msg 以对象传输
    public static <T> Result<T> error(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}