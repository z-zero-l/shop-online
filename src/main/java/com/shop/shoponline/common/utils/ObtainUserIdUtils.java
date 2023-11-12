package com.shop.shoponline.common.utils;

import com.shop.shoponline.common.exception.ServerException;
import jakarta.servlet.http.HttpServletRequest;

public class ObtainUserIdUtils {

    public static Integer getUserId(HttpServletRequest request) {
        if (request.getAttribute("userId") == null) {
            throw new ServerException("用户不存在");
        }
        Integer userId = Integer.parseInt(request.getAttribute("userId").toString());
        if (userId == null) {
            throw new ServerException("用户不存在");
        }
        return userId;
    }
}