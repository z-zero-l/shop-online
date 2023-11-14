package com.shop.shoponline.service;

import com.shop.shoponline.entity.UserShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.shoponline.query.CartQuery;
import com.shop.shoponline.query.EditCartQuery;
import com.shop.shoponline.vo.CartGoodsVO;

import java.util.List;

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

    /**
     * 查询购物车列表
     *
     * @param userId
     * @return list
     */
    List<CartGoodsVO> shopCartList(Integer userId);

    /**
     * 修改购物车单品
     *
     * @param query
     * @return CartGoodsVO
     */
    CartGoodsVO editCart(EditCartQuery query);

    /**
     * 删除购物车单品
     *
     * @param userId
     * @param ids
     */
    void removeCartGoods(Integer userId, List<Integer> ids);

    /**
     * 购物车全选/取消全选
     *
     * @param selected
     * @param userId
     */
    void editCartSelected(Boolean selected, Integer userId);
}
