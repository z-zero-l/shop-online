package com.shop.shoponline.convert;

import com.shop.shoponline.entity.UserOrder;
import com.shop.shoponline.vo.OrderDetailVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserOrderDetailConvert {

    UserOrderDetailConvert INSTANCE = Mappers.getMapper(UserOrderDetailConvert.class);

    OrderDetailVO convertToDetailVO(UserOrder userOrder);

    OrderDetailVO convertToOrderDetailVO(UserOrder userOrder);


}
