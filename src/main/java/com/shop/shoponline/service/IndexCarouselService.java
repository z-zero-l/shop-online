package com.shop.shoponline.service;

import com.shop.shoponline.entity.IndexCarousel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zero
 * @since 2023-11-07
 */
public interface IndexCarouselService extends IService<IndexCarousel> {
    List<IndexCarousel> getList(Integer distributionSite);
}
