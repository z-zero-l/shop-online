package com.shop.shoponline.controller;

import com.shop.shoponline.common.result.PageResult;
import com.shop.shoponline.common.result.Result;
import com.shop.shoponline.query.RecommendByTabGoodsQuery;
import com.shop.shoponline.service.GoodsService;
import com.shop.shoponline.vo.IndexTabRecommendVO;
import com.shop.shoponline.vo.RecommendGoodsVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zero
 * @since 2023-11-07
 */
@Tag(name = "商品模块")
@RestController
@RequestMapping("goods")
@AllArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;

    @Operation(summary = "首页-热门推荐商品列表")
    @PostMapping("preference")
    public Result<IndexTabRecommendVO> getTabRecommendGoodsByTabId(@RequestBody @Validated RecommendByTabGoodsQuery query) {
        IndexTabRecommendVO result = goodsService.getTabRecommendGoodsByTabId(query);
        return Result.ok(result);
    }

    @Operation(summary = "首页-猜你喜欢")
    @PostMapping("guessLike")
    public Result<PageResult<RecommendGoodsVO>> getRecommendGoodsByPage(@RequestBody @Validated RecommendByTabGoodsQuery query) {
        PageResult<RecommendGoodsVO> result = goodsService.getRecommendGoodsByPage(query);
        return Result.ok(result);
    }


}
