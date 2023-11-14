package com.shop.shoponline.service.impl;

import com.shop.shoponline.common.exception.ServerException;
import com.shop.shoponline.entity.Goods;
import com.shop.shoponline.entity.UserShoppingCart;
import com.shop.shoponline.mapper.GoodsMapper;
import com.shop.shoponline.mapper.UserShoppingCartMapper;
import com.shop.shoponline.query.CartQuery;
import com.shop.shoponline.service.UserShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.shoponline.vo.CartGoodsVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zero
 * @since 2023-11-14
 */
@Service
@AllArgsConstructor
public class UserShoppingCartServiceImpl extends ServiceImpl<UserShoppingCartMapper, UserShoppingCart> implements UserShoppingCartService {

    private final GoodsMapper goodsMapper;

    @Override
    public CartGoodsVO addShopCart(CartQuery cartQuery) {
        Goods goods = goodsMapper.selectById(cartQuery.getId());
        // 商品是否存在
        if (goods == null) {
            throw new ServerException("商品信息不存在");
        }
        // 库存是否充足
        if (cartQuery.getCount() > goods.getInventory()) {
            throw new ServerException("商品库存不足");
        }
        // 插入购物车信息
        UserShoppingCart userShoppingCart = new UserShoppingCart();
        userShoppingCart.setUserId(cartQuery.getUserId());
        userShoppingCart.setGoodsId(goods.getId());
        userShoppingCart.setPrice(goods.getPrice());
        userShoppingCart.setCount(cartQuery.getCount());
        userShoppingCart.setAttrsText(cartQuery.getAttrsText());
        userShoppingCart.setSelected(false);
        baseMapper.insert(userShoppingCart);
        // 返回用户添加购物车信息
        CartGoodsVO cartGoodsVO = new CartGoodsVO();
        cartGoodsVO.setId(userShoppingCart.getId());
        cartGoodsVO.setName(goods.getName());
        cartGoodsVO.setAttrsText(cartQuery.getAttrsText());
        cartGoodsVO.setPrice(userShoppingCart.getPrice());
        cartGoodsVO.setNowPrice(goods.getPrice());
        cartGoodsVO.setSelected(userShoppingCart.getSelected());
        cartGoodsVO.setStock(goods.getInventory());
        cartGoodsVO.setCount(cartQuery.getCount());
        cartGoodsVO.setPicture(goods.getCover());
        cartGoodsVO.setDiscount(goods.getDiscount());
        return cartGoodsVO;
    }

    @Override
    public List<CartGoodsVO> shopCartList(Integer userId) {
        return baseMapper.getCartGoodsInfo(userId);
    }
}
