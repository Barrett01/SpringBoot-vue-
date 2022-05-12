package com.xm.so;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//注册业务实体类
public class RegisterSo{
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank
    @Size(min = 6, message = "密码的长度不能少于6个字符")
    private String password;

    @NotBlank
    @Size(min = 6, message = "确认密码的长度不能少于6个字符")
    private String checkPassword;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }
}
