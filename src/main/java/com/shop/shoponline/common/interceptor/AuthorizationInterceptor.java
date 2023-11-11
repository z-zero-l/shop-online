package com.shop.shoponline.common.interceptor;


import com.shop.shoponline.common.exception.ServerException;
import com.shop.shoponline.common.utils.JWTUtils;
import com.shop.shoponline.constant.APIConstant;
import com.shop.shoponline.service.RedisService;
import com.shop.shoponline.vo.UserTokenVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

public class AuthorizationInterceptor implements HandlerInterceptor {

    @Resource
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//       从header中得到token
        String authorization = request.getHeader(APIConstant.AUTHORIZATION);

        if (authorization == null) {
            throw new ServerException("access denied");
        }

//        如果token存在，需要验证token的真伪，如果 token 是真的，对 token 解析，获取用户id
        Map map = JWTUtils.getClaims(APIConstant.JWT_SECRET, authorization);

        if (map == null) {
            throw new ServerException("access denied");
        } else {
            String userId = map.get("userId").toString();
            request.setAttribute("userId", userId);
        }

//        判断token是否过期
        UserTokenVO userTokenVO = new UserTokenVO().fromMap(map);

        boolean isExist = redisService.existsKey(userTokenVO.getUserId().toString());

        if (isExist) {
            String originToken = redisService.getValue(userTokenVO.getUserId().toString(), String.class);
            if (originToken != null && originToken.equals(authorization)) {
                return true;
            } else {
                throw new ServerException("token expire");
            }
        }
        return true;
    }
}