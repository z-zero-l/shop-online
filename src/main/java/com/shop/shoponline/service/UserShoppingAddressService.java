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
 * @since 2023-11-12
 */
public interface UserShoppingAddressService extends IService<UserShoppingAddress> {
    /**
     * 添加收货地址
     *
     * @param addressVO
     * @return Integer
     */
    Integer saveShoppingAddress(AddressVO addressVO);

    /**
     * 修改收货地址
     *
     * @param addressVO
     * @return Integer
     */
    Integer editShoppingAddress(AddressVO addressVO);

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
     * @param userId
     * @return AddressVO
     */
    AddressVO getAddress(Integer id, Integer userId);

    /**
     * 删除收货地址
     *
     * @param id
     * @param userId
     * @return Integer
     */
    Integer deleteShoppingAddress(Integer id, Integer userId);
}
