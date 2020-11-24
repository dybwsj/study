package com.self.study.utils;

import com.self.study.exception.MyException;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 13:44
 * @description:
 */
public class AssertUtil {
    public static void isNull(Object o, String message) {
        if (o != null) {
            throw new MyException(message);
        }
    }

    public static void notNull(Object o, String message) {
        if (o == null) {
            throw new MyException(message);
        }
    }

    public static void isTrue(boolean b, String message) {
        if (!b) {
            throw new MyException(message);
        }
    }

    public static void notTrue(boolean b, String message) {
        if (b) {
            throw new MyException(message);
        }
    }
}
