package com.shop.shoponline.convert;

import com.shop.shoponline.entity.UserShoppingAddress;
import com.shop.shoponline.vo.UserAddressVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserAddressConvert {

    UserAddressConvert INSTANCE = Mappers.getMapper(UserAddressConvert.class);

    UserAddressVO convertToUserAddressVO(UserShoppingAddress userShippingAddress);

    List<UserAddressVO> convertToUserAddressVOList(List<UserShoppingAddress> list);
}