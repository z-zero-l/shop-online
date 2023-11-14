package com.shop.shoponline.mapper;

import com.shop.shoponline.entity.UserShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop.shoponline.vo.CartGoodsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zero
 * @since 2023-11-14
 */
public interface UserShoppingCartMapper extends BaseMapper<UserShoppingCart> {

    List<CartGoodsVO> getCartGoodsInfo(@Param("id") Integer id);
}
