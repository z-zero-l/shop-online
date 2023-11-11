package com.shop.shoponline.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shop.shoponline.common.exception.ServerException;
import com.shop.shoponline.common.utils.GeneratorCodeUtils;
import com.shop.shoponline.common.utils.JWTUtils;
import com.shop.shoponline.convert.UserConvert;
import com.shop.shoponline.entity.User;
import com.shop.shoponline.mapper.UserMapper;
import com.shop.shoponline.query.UserLoginQuery;
import com.shop.shoponline.service.RedisService;
import com.shop.shoponline.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.shoponline.vo.LoginResultVO;
import com.shop.shoponline.vo.UserTokenVO;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.shop.shoponline.constant.APIConstant.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zero
 * @since 2023-11-07
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final RedisService redisService;

    @Override
    public LoginResultVO login(UserLoginQuery query) {
        //  1、获取openId
        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
                "appid=" + APP_ID +
                "&secret=" + APP_SECRET +
                "&js_code=" + query.getCode() +
                "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String openIdResult = restTemplate.getForObject(url, String.class);
        if (StringUtils.contains(openIdResult, WX_ERR_CODE)) {
            throw new ServerException("openId获取失败" + openIdResult);
        }
        // 2、解析返回的数据
        JSONObject jsonObject = JSON.parseObject(openIdResult);
        String openId = jsonObject.getString(WX_OPENID);
        User user = baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getOpenId, openId));
        // 3、判断用户是否存在，如果用户不存在，直接注册新用户
        if (user == null) {
            user = new User();
            String account = "用户" + GeneratorCodeUtils.generateCode();
            user.setAvatar(DEFAULT_AVATAR);
            user.setAccount(account);
            user.setNickname(account);
            user.setOpenId(openId);
            user.setMobile("''");
            baseMapper.insert(user);
        }
        LoginResultVO userVO = UserConvert.INSTANCE.convertToLoginResultVO(user);
        // 4、生成token，存入redis并设置过期时间
        UserTokenVO tokenVO = new UserTokenVO(userVO.getId());
        String token = JWTUtils.generateToken(JWT_SECRET, tokenVO.toMap());
        redisService.set(APP_NAME + userVO.getId(), token, APP_TOKEN_EXPIRE_TIME);
        userVO.setToken(token);
        return userVO;
    }
}
