package com.lsj.springboot.cipher;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.SecureRandom;

/**
 * DES 加密算法是一种分组密码，以 64 位为分组对数据加密。
 * 它的密钥长度是 56？？？（64（8）） 位，加密解密用同一算法。DES 加密算法是对密钥进行保密，而公开算法，包括加密和解密算法。
 * 这样，只有掌握了和发送方相同密钥的人才能解读由 DES 加密算法加密的密文数据。
 * 因此，破译 DES 加密算法实际上就是搜索密钥的编码。对于 56 位长度的密钥来说，如果用穷举法来进行搜索的话，其运算次数为 2 的 56 次方。
 *
 * 在 Java 中用 DES 加密有一个特殊的地方：
 * 秘钥设置的长度必须大于等于 8。
 * 秘钥设置的长度如果大于 8 的话，那么只会取前 8 个字节作为秘钥。
 * 为什么呢，我们可以看到在初始化 DESKeySpec 类的时候有下面一段，其中 var1 是我们传的秘钥。可以看到它进行了截取，只截取前八个字节。
 * public DESKeySpec(byte[] var1, int var2) throws InvalidKeyException {
 *    if (var1.length - var2 < 8) {
 *          throw new InvalidKeyException("Wrong key size");
 *     } else {
 *          this.key = new byte[8];
 *          System.arraycopy(var1, var2, this.key, 0, 8);
 *     }
 * }
 * Created by 10326 on 2021/7/7.
 */
public class DESUtils {

    private final static String DES = "DES";

    public static void main(String[] args) throws Exception {
        String data = "123 456";
        String key = "wang!@#$";
        System.err.println(encrypt(data, key));
        System.err.println(decrypt(encrypt(data, key), key));

    }

    /**
     * Description 根据键值进行加密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    public static String encrypt(String data, String key) throws Exception {
        byte[] bt = encrypt(data.getBytes(), key.getBytes());
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }

    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws IOException, Exception {
        if (data == null) return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf,key.getBytes());
        return new String(bt);
    }

    /**
     * Description 根据键值进行加密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }


    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

}
