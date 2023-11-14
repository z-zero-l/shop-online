package com.shop.shoponline.service;

import com.shop.shoponline.entity.UserShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.shoponline.query.CartQuery;
import com.shop.shoponline.vo.CartGoodsVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zero
 * @since 2023-11-14
 */
public interface UserShoppingCartService extends IService<UserShoppingCart> {
    /**
     * 添加购物车
     *
     * @param cartQuery
     * @return CartGoodsVO
     */
    CartGoodsVO addShopCart(CartQuery cartQuery);

}
