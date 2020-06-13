package com.lyy.client.model;

import lombok.Data;

@Data
public class Result {
    private Boolean success;
    private String message;
    private String resultType;
    private String resultValue;

    public Result(Boolean success, String message, String resultType, String resultValue) {
        this.success = success;
        this.message = message;
        this.resultType = resultType;
        this.resultValue = resultValue;
    }

    public Boolean isSuccess() {
        return success;
    }

    public static Result getSuccessResult(String resultType, String resultValue) {
        return new Result(true, "成功", resultType, resultValue);
    }

    public static Result getFailResult(String reason) {
        return new Result(false, reason, null, null);
    }
}
