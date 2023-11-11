package com.shop.shoponline.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shop.shoponline.entity.Category;
import com.shop.shoponline.enums.CategoryRecommendEnum;
import com.shop.shoponline.mapper.CategoryMapper;
import com.shop.shoponline.mapper.GoodsMapper;
import com.shop.shoponline.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zero
 * @since 2023-11-07
 */
@Service
@AllArgsConstructor
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    private final GoodsMapper goodsMapper;

    public List<Category> getIndexCategoryList() {
        LambdaQueryWrapper<Category> wrapper=new LambdaQueryWrapper<>();
        //
        wrapper.eq(Category::getIsRecommend, CategoryRecommendEnum.ALL_RECOMMEND.getValue());
        wrapper.orderByDesc(Category::getCreateTime);
        return baseMapper.selectList(wrapper);
    }
}
