package com.gc.order.util;

import java.util.Random;

public class KeyUtil {

    public static synchronized String genUniqueKey() {
        return System.currentTimeMillis() + String.valueOf(new Random().nextInt(900000) + 100000);
    }
}
