package com.ryz2593.util;

import java.util.UUID;

/**
 * @author ryz2593
 * @date 2019/4/11
 * @desc
 */
public class UUIDUtil {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}
