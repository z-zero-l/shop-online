package com.shop.shoponline.service.impl;

import com.shop.shoponline.entity.UserOrderGoods;
import com.shop.shoponline.mapper.UserOrderGoodsMapper;
import com.shop.shoponline.service.UserOrderGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zero
 * @since 2023-11-25
 */
@Service
public class UserOrderGoodsServiceImpl extends ServiceImpl<UserOrderGoodsMapper, UserOrderGoods> implements UserOrderGoodsService {

    @Override
    public void batchUserOrderGoods(List<UserOrderGoods> list) {
        saveBatch(list);
    }
}
