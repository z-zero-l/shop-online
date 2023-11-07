package com.shop.shoponline.service.impl;

import com.shop.shoponline.entity.Category;
import com.shop.shoponline.mapper.CategoryMapper;
import com.shop.shoponline.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zero
 * @since 2023-11-07
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
