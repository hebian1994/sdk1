package com.example.demo_azure_key_vault.rtn;

public enum ResultCode {
    //各种响应根据需求去编写
    HTTP_SUCCESS(200, "请求成功"),
    HTTP_FAIL(500, "请求失败");


    private final Integer code;
    private final String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }


}
