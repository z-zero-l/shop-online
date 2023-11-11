package com.shop.shoponline.service;

import com.shop.shoponline.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.shoponline.vo.CategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zero
 * @since 2023-11-07
 */
public interface CategoryService extends IService<Category> {
    List<Category> getIndexCategoryList();
    List<CategoryVO> getCategoryList();
}
