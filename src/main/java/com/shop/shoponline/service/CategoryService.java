package com.shop.shoponline.service;

import com.shop.shoponline.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.shoponline.vo.CategoryVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zero
 * @since 2023-11-11
 */
public interface CategoryService extends IService<Category> {
    /**
     * 首页 - 分类列表
     *
     * @return list
     */
    List<Category> getIndexCategoryList();

    /**
     * 分类tab页 - 分类列表以及各分类下的商品
     *
     * @return list
     */
    List<CategoryVO> getCategoryList();
}
