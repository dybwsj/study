package com.self.study.utils;

import java.util.regex.Pattern;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 11:22
 * @description:
 */
public class PhoneValidationUtil {
    private static final Pattern PATTERN = Pattern.compile("^1[345678]\\d{9}$");

    public static boolean isPhone(String phone) {
        return PATTERN.matcher(phone).matches();
    }
}
