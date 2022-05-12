package com.xm.common;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//MD5工具，严格说 MD5 不是一种加密算法，是一种摘要算法，摘要算法的主要特征是加密过程不需要密钥，并且经过加密的数据无法被解密, 无论多长的输入， MD5 都会输出长度为 16字节的字节数组
public class MD5Utils {
    //盐值常量
    private static final String SALT = "hdiwh6dhweuhid";

    //接收一个未加密的字符串，返回一个加密后的字符串
    public static String getMD5Str(String strValue) throws NoSuchAlgorithmException {
        //返回实现MD5摘要算法的MessageDigest对象
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //生成的哈希值的字节数组
        byte[] md5Bytes = md5.digest((strValue+SALT).getBytes());
        //Base64 编码的目的是把任意二进制编码成文本
        return Base64.encodeBase64String(md5Bytes);
    }
}


