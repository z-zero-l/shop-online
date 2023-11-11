package com.shop.shoponline.convert;

import com.shop.shoponline.entity.UserShoppingAddress;
import com.shop.shoponline.vo.AddressVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AddressConvert {
    AddressConvert INSTANCE = Mappers.getMapper(AddressConvert.class);

    UserShoppingAddress convert(AddressVO addressVO);

    List<AddressVO> convertToAddressVOList(List<UserShoppingAddress> addressList);

    AddressVO convertToAddressVO(UserShoppingAddress userShoppingAddress);
}