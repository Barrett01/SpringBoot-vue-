package com.xm.controller;


import com.alibaba.fastjson.JSONObject;
import com.xm.common.ApiResponse;
import com.xm.entity.User;
import com.xm.service.UserService;
import com.xm.so.LoginSo;
import com.xm.so.RegisterSo;
import com.xm.so.SignatureSo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/register")
    public ApiResponse register(@Valid @RequestBody RegisterSo registerSo){
        if (registerSo.getPassword().equals(registerSo.getCheckPassword())==false){
            return new ApiResponse(false, "两次密码不一致");
        }
        return userService.register(registerSo.getUsername(), registerSo.getPassword());
    }

    @PostMapping("/login")
    public ApiResponse login(@Valid @RequestBody LoginSo loginSo){
        return userService.login(loginSo.getUsername(), loginSo.getPassword());
    }

    @PostMapping("/signature")
    public ApiResponse updatesignature(@Valid @RequestBody SignatureSo signatureSo, @RequestHeader("token") String token){
        if(token==null||token.equals("")){
            return  new ApiResponse(false,"请先登录！");
        }else {
            String strUser= (String) redisTemplate.opsForValue().get(token);
            User user = JSONObject.parseObject(strUser,User.class);
            if(user==null){
                return new ApiResponse(false,"用户认证不正确，请重新登录！");
            }else{
                user.setPersonalizedSignature(signatureSo.getSignature());
                return userService.updateSignature(user);
            }
        }
    }
    @PostMapping("/logout")
    public ApiResponse logout(@RequestHeader("token") String token){
        if(token==null||token.equals("")){
            return  new ApiResponse(false,"未登录");
        }else {
            String strUser= (String) redisTemplate.opsForValue().get(token);
            User user = JSONObject.parseObject(strUser,User.class);
            if(user==null){
                return new ApiResponse(false,"用户认证不正确！");
            }else{
               redisTemplate.delete(token);
                return new ApiResponse(true,"已经退出登录");
            }
        }
    }
}
