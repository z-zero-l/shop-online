package com.shop.shoponline.convert;

import com.shop.shoponline.entity.User;
import com.shop.shoponline.vo.LoginResultVO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);
    LoginResultVO convertToLoginResultVO(User user);
}
