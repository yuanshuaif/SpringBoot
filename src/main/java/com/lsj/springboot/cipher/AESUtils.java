package com.lsj.springboot.cipher;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES 加密算法是密码学中的高级加密标准，该加密算法采用对称分组密码体制，密钥长度的最少支持为 128（16）、192（24）、256（32），分组长度 128 位
 * 在设置 Cipher 类的时候有几个注意点：Cipher 在使用时需以参数方式指定 transformation。
 * transformation 的格式为 algorithm/mode/padding，其中 algorithm 为必输项，如: AES/DES/CBC/PKCS5Padding，具体有哪些可看下表。
 * 缺省的 mode 为 ECB，缺省的 padding 为 PKCS5Padding。\
 * 在 block 算法与流加密模式组合时, 需在 mode 后面指定每次处理的 bit 数, 如 DES/CFB8/NoPadding, 如未指定则使用缺省值, SunJCE 缺省值为 64bits。
 * Cipher 有 4 种操作模式：ENCRYPT_MODE(加密)、DECRYPT_MODE(解密)、WRAP_MODE(导出Key)、UNWRAP_MODE(导入Key)，初始化时需指定某种操作模式。
 * Created by 10326 on 2021/7/7.
 */
public class AESUtils {

    private final static String AES = "AES";

    public static void main(String[] args) throws Exception {
    /*
        * 此处使用AES-128-ECB加密模式，key需要为16位。
        */
        String cKey = "1234567890123456";
        // 需要加密的字串
        String cSrc = "buxuewushu";
        System.out.println(cSrc);
        // 加密
        String enString = Encrypt(cSrc, cKey);
        System.out.println("加密后的字串是：" + enString);

        // 解密
        String DeString = Decrypt(enString, cKey);
        System.out.println("解密后的字串是：" + DeString);
    }

    // 加密
    public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, AES);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        return new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, AES);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

}
