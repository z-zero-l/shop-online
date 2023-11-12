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
 * 服务类
 * </p>
 *
 * @author zero
 * @since 2023-11-11
 */
public interface GoodsService extends IService<Goods> {
    /**
     * 首页-热门推荐 根据tabId获取该推荐下的商品列表
     *
     * @return IndexTabRecommendVO
     */
    IndexTabRecommendVO getTabRecommendGoodsByTabId(RecommendByTabGoodsQuery query);

    /**
     * 首页推荐 - 猜你喜欢(分页)
     *
     * @param query
     * @return PageResult
     */
    PageResult<RecommendGoodsVO> getRecommendGoodsByPage(Query query);

    /**
     * 根据id 获取商品详情
     *
     * @param id
     * @return GoodsVO
     */
    GoodsVO getGoodsDetail(Integer id);
}
