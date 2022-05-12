package com.xm.so;

import javax.validation.constraints.NotBlank;

public class SignatureSo {
    @NotBlank(message = "个性签名不能为空！")
    private String signature;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
