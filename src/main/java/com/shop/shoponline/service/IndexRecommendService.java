package com.shop.shoponline.service;

import com.shop.shoponline.entity.IndexRecommend;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.shoponline.vo.IndexRecommendVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zero
 * @since 2023-11-07
 */
public interface IndexRecommendService extends IService<IndexRecommend> {
    List<IndexRecommendVO> getList();
}
