package edu.agic.itblog.util;

import edu.agic.itblog.model.ReturnCode;
import edu.agic.itblog.model.ReturnModel;
import edu.agic.itblog.util.TimeStampUtil;

import java.time.LocalDateTime;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 23:13
 */
public class ReturnUtil {
    public static ReturnModel get(int code, Object data) {
        long timestamp = TimeStampUtil.get();
        String msg = ReturnCode.get(code) == null ? "未知错误":ReturnCode.get(code);
        return new ReturnModel(timestamp, code, msg, data);
    }
}
