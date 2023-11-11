package com.shop.shoponline.common.utils;

import java.util.Random;

/**
 * 生成6位随机数
 * @return
 */
public class GeneratorCodeUtils {
    public static String generateCode() {
        int n = 6;
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            code.append(Integer.valueOf(random.nextInt(10)).toString());
        }
        return code.toString();
    }
}