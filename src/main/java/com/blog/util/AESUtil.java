package com.blog.util;


import com.blog.base.Constant;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESUtil {

    public static void main(String[] args) {

        String content = "oEokc5Gbn1_yLbVJgxY2X-XGBT4w#key#fp03vJjFtsx6CoGoSAFfBg";
        String addPwd = "lzcj";

        byte[] enAccount = encrypt(content, addPwd);
        String encryptResultStr = parseByte2HexStr(enAccount);

        // 解密 ——账号/身份证号
        byte[] accountFrom = AESUtil.parseHexStr2Byte(encryptResultStr);
        byte[] deAccount = AESUtil.decrypt(accountFrom, addPwd);
        String userAccount = new String(deAccount);
        System.out.println(userAccount);
    }

    public static String getEncrypt(String content) {
        byte[] enAccount = encrypt(content, Constant.SALT);
        return parseByte2HexStr(enAccount);
    }

    public static String getDecrypt(String content) {
        byte[] accountFrom = AESUtil.parseHexStr2Byte(content);
        byte[] deAccount = AESUtil.decrypt(accountFrom, Constant.SALT);
        return new String(deAccount);
    }

    /**
     * AES加密
     *
     * @param content  要加密的内容
     * @param password 加密使用的密钥
     * @return 加密后的字节数组
     */
    public static byte[] encrypt(String content, String password) {
        SecureRandom random = null;
        try {
            random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }

        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            // kgen.init(128, new SecureRandom(password.getBytes()));
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            return cipher.doFinal(byteContent); // 加密
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | InvalidKeyException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将二进制转换成16进制 加密
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 解密
     *
     * @param content  待解密内容
     * @param password 解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] content, String password) {
        SecureRandom random = null;
        try {
            random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            // kgen.init(128, new SecureRandom(password.getBytes()));
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            return cipher.doFinal(content); // 加密
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | InvalidKeyException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
                    16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
}

