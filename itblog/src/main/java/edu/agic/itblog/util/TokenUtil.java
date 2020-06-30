package edu.agic.itblog.util;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/27 0:12
 */
public class TokenUtil {
    private static long activeTime = 1 * 60 * 60 * 1000;

    public static String get(String input) {
        // 拼接一个需要加密的串
        long expires = TimeStampUtil.get() + activeTime; // 最终的过期时间
        input = expires + input; // 13+32=45  0,12 ~ 13,44
        // 拼接一个需要加密的串
        try {
            String encryptStr = RsaUtil.encrypt(input);
            String token = encryptStr.replaceAll("\\+", "%20")
                    .replaceAll("/", "%30")
                    .replaceAll("=", "%40")
                    .replaceAll("\r\n", "%50");
            return token;
        } catch (Exception e) {
            String err = String.format("异常[%s]：生成token错误，%s", TokenUtil.class, e.getMessage());
            System.err.println(err);
        }
        return null;
    }

    private static String parse(String token) {
        String encryptStr = token.replaceAll("%50", "\r\n").replaceAll("%40", "=").replaceAll("%30", "/").replaceAll("%20", "\\+");
        try {
            String input = RsaUtil.decrypt(encryptStr);// 将token解密为json字符串
            return input;
        } catch (Exception e) {
            String err = String.format("异常[%s]：解析token错误，%s", TokenUtil.class, e.getMessage());
            System.err.println(err);
        }
        return null;
    }

    public static boolean checkToken(String token) {
        if (token == null || token.length() == 0)
            return false;
        try {
            String parse = parse(token);
            if (parse == null || parse.length() != 45)
                return false;
            long expires = Long.parseLong(parse.substring(0, 13));
            return TimeStampUtil.get() < expires;
        } catch (Exception e) {
            return false;
        }
    }
    public static String parseToUserid(String token) {
        String parse = parse(token);
        if (parse == null || parse.length() != 45)
            return null;
        return parse.substring(13);
    }
}
