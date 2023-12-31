package com.shop.shoponline.service;

import com.shop.shoponline.entity.UserOrderGoods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zero
 * @since 2023-11-25
 */
public interface UserOrderGoodsService extends IService<UserOrderGoods> {
    /**
     * 批量插入订单记录
     *
     * @param list
     */
    void batchUserOrderGoods(List<UserOrderGoods> list);

}
