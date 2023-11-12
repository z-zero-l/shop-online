package com.shop.shoponline.service;

import com.shop.shoponline.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.shoponline.query.UserLoginQuery;
import com.shop.shoponline.vo.LoginResultVO;
import com.shop.shoponline.vo.UserVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zero
 * @since 2023-11-07
 */
public interface UserService extends IService<User> {
    /**
     * 用户登录
     *
     * @param query
     * @return LoginResultVO
     */
    LoginResultVO login(UserLoginQuery query);

    /**
     * 根据用户id 获取用户信息
     *
     * @param userId
     * @return User
     */
    User getUserInfo(Integer userId);

    /**
     * 修改用户信息
     *
     * @param userVO
     * @return UserVO
     */
    UserVO editUserInfo(UserVO userVO);

    /**
     * 修改用户头像
     *
     * @param userId
     * @param file
     * @return String
     */
    String editUserAvatar(Integer userId, MultipartFile file);

}
