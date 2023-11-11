package com.shop.shoponline.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.shoponline.entity.UserShoppingAddress;
import com.shop.shoponline.vo.AddressVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zero
 * @since 2023-11-07
 */
public interface UserShoppingAddressService extends IService<UserShoppingAddress> {
    /**
     * 添加收货地址
     *
     * @param addressVO
     * @return Integer
     */
    Integer saveShippingAddress(AddressVO addressVO);

    /**
     * 修改收货地址
     *
     * @param addressVO
     * @return Integer
     */
    Integer editShippingAddress(AddressVO addressVO);

    /**
     * 获取收货地址
     *
     * @param userId
     * @return List
     */
    List<AddressVO> getList(Integer userId);

    /**
     * 收货地址详情
     *
     * @param id
     * @return AddressVO
     */
    AddressVO getAddress(Integer id);

    /**
     * 删除收货地址
     *
     * @param id
     * @return Integer
     */
    Integer deleteShippingAddress(Integer id);
}
