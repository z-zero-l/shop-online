package com.shop.shoponline.controller;

import com.shop.shoponline.common.result.Result;
import com.shop.shoponline.entity.IndexCarousel;
import com.shop.shoponline.service.IndexCarouselService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zero
 * @since 2023-11-07
 */
@Tag(name = "首页管理")
@RestController
@RequestMapping("home")
@AllArgsConstructor
public class IndexCarouselController {
    private final IndexCarouselService indexCarouselService;

    @Operation(summary = "首页/商品分类页-推荐轮播图")
    @GetMapping("banner")
    public Result<List<IndexCarousel>> getList(@RequestParam Integer distributionSite) {

        List<IndexCarousel> list = indexCarouselService.getList(distributionSite);
        return Result.ok(list);

    }
}

