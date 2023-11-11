package com.shop.shoponline.service;

import com.shop.shoponline.common.result.PageResult;
import com.shop.shoponline.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.shoponline.query.Query;
import com.shop.shoponline.query.RecommendByTabGoodsQuery;
import com.shop.shoponline.vo.GoodsVO;
import com.shop.shoponline.vo.IndexTabRecommendVO;
import com.shop.shoponline.vo.RecommendGoodsVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zero
 * @since 2023-11-07
 */
public interface GoodsService extends IService<Goods> {
    IndexTabRecommendVO getTabRecommendGoodsByTabId(RecommendByTabGoodsQuery query);
    PageResult<RecommendGoodsVO> getRecommendGoodsByPage(Query query);
    GoodsVO getGoodsDetail(Integer id);
}
