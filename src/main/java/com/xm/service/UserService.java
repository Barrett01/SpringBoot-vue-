package com.xm.service;

import com.alibaba.fastjson.JSONObject;
import com.xm.common.ApiResponse;
import com.xm.common.MD5Utils;
import com.xm.mapper.UserMapper;
import com.xm.entity.User;
import com.xm.so.UserSo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    public ApiResponse register(String username, String password){
        User res=userMapper.selectByUsername(username);
        if(res!=null){
            return new ApiResponse(false, "该用户已经被注册");
        }
        else {
            User user = new User();
            user.setUsername(username);
            try {
                user.setPassword(MD5Utils.getMD5Str(password));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            int count=userMapper.insertSelective(user);
            if(count==0){
                return new ApiResponse(false,"插入数据库失败");
            }else{
                return new ApiResponse(true, "注册成功");
            }
        }
    }

    public ApiResponse login(String username, String password){
        String md5Password = null;
        try {
            //将密码进行加密处理后再和数据库的进行一致性校验
            md5Password = MD5Utils.getMD5Str(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //调用mapper层去数据库中进行一致性校验
        User user = userMapper.selectByUsername(username);
        if(user == null){
            return new ApiResponse(false, "该用户名未被注册，请先注册！");
        }
        else{
            if(user.getPassword().equals(md5Password)){
                String token = UUID.randomUUID().toString();
                String strUser =JSONObject.toJSONString(user);
                redisTemplate.opsForValue().set(token,strUser );

                UserSo userSo= new UserSo();
                userSo.setId(user.getId());
                userSo.setUsername(user.getUsername());
                userSo.setRole(user.getRole());
                userSo.setPersonalizedSignature(user.getPersonalizedSignature());
                userSo.setToken(token);

                return new ApiResponse(true, "登录成功！", userSo);
            }else {
                return new ApiResponse(false, "密码错误");
            }

        }
    }
    public ApiResponse updateSignature(User user){
        int count = userMapper.updateByPrimaryKeySelective(user);
        if(count==0){
            return new ApiResponse(true,"更新失败");
        }else {
            return new ApiResponse(true,"更新成功");
        }
    }


}
