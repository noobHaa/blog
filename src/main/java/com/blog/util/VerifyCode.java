package com.blog.util;

/**
 * 随机生成验证码
 */
public class VerifyCode {
    private static char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static String code() {
        char[] code = new char[6];
        for (int i = 0; i < 6; i++) {
            code[i]=chars[(int) (Math.random()*10)];
        }
        return new String(code);
    }

    public static void main(String[] args) {
        System.out.println(code());
    }
}
