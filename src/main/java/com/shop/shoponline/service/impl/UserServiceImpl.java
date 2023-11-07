package com.shop.shoponline.service.impl;

import com.shop.shoponline.entity.User;
import com.shop.shoponline.mapper.UserMapper;
import com.shop.shoponline.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zero
 * @since 2023-11-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
