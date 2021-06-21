package com.life.common.exception;

import com.life.common.api.IErrorCode;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * 断言处理类，用于抛出各种API异常
 *
 * @author WangYinfeng
 */
public class Asserts extends Assert {

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }

    public static void notEmpty(String string, String message) {
        if (StringUtils.isEmpty(string)) {
            fail(message);
        }
    }

    public static void notEmpty(String string, IErrorCode errorCode) {
        if (StringUtils.isEmpty(string)) {
            fail(errorCode);
        }
    }

    public static void checkTrue(Boolean b, String message) {
        if (b) {
            fail(message);
        }
    }

    public static void checkFalse(Boolean b, String message) {
        if (!b) {
            fail(message);
        }
    }
}
