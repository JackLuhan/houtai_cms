package com.ypxx.manage.common.utils;

import org.apache.commons.lang3.Validate;
import org.apache.shiro.codec.Hex;
import org.apache.commons.lang3.StringEscapeUtils;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * Created by xuwei on 2018/10/9.
 */
public class PasswordUtils {

    private static final String SHA1 = "SHA-1";
    private static SecureRandom random = new SecureRandom();

    /**
     * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
     */
    public static String entryPassword(String plainPassword) {
        String plain = unescapeHtml(plainPassword);
        byte[] salt = generateSalt(8);
        byte[] hashPassword = sha1(plain.getBytes(), salt, 1024);
        return encodeHex(salt) + encodeHex(hashPassword);
    }

    private static String unescapeHtml(String htmlEscaped) {
        return StringEscapeUtils.unescapeHtml4(htmlEscaped);
    }

    private static byte[] generateSalt(int numBytes) {
        Validate.isTrue(numBytes > 0, "numBytes argument must be a positive integer (1 or larger)", numBytes);
        byte[] bytes = new byte[numBytes];
        random.nextBytes(bytes);
        return bytes;
    }

    private static byte[] sha1(byte[] input, byte[] salt, int iterations) {
        return digest(input, SHA1, salt, iterations);
    }

    /**
     * 对字符串进行散列, 支持md5与sha1算法.
     */
    private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);

            if (salt != null) {
                digest.update(salt);
            }

            byte[] result = digest.digest(input);

            for (int i = 1; i < iterations; i++) {
                digest.reset();
                result = digest.digest(result);
            }
            return result;
        } catch (GeneralSecurityException e) {
            throw new RuntimeException();
        }
    }

    /**
     * Hex编码.
     */
    private static String encodeHex(byte[] input) {
        return Hex.encodeToString(input);
    }

    /**
     * Hex解码.
     */
    public static byte[] decodeHex(String input) {
        return Hex.decode(input.toCharArray());

    }

}
