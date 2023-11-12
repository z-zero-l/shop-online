package com.shop.shoponline.service;

import com.shop.shoponline.entity.IndexRecommend;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.shoponline.vo.IndexRecommendVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zero
 * @since 2023-11-11
 */
public interface IndexRecommendService extends IService<IndexRecommend> {
    /**
     * 首页-热门推荐
     *
     * @return list
     */
    List<IndexRecommendVO> getList();
}
