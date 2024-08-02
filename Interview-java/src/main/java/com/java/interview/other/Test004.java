package com.java.interview.other;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author liaowenhui
 * @date 2023/11/1 10:25
 */
public class Test004 {
    public static void main(String[] args) {
        String uniqueId = "小红" + "man" + "20231119";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(uniqueId.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            String encode = encode(uniqueId);

            System.out.println("结果为：" + hexString.toString());
            System.out.println("encode结果为：" + encode);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    //265800930ccdd219793c14d01fc48345
    //bccef5a780909bddd2b3238594b24adf
    //f67814687a37c81fff16ebee05aaffd9

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * Takes the raw bytes from the digest and formats them correct.
     *
     * @param bytes the raw bytes from the digest.
     * @return the formatted bytes.
     */
    public static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
