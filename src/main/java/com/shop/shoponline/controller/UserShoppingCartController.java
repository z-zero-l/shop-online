package com.shop.shoponline.controller;

import com.shop.shoponline.common.exception.ServerException;
import com.shop.shoponline.common.result.Result;
import com.shop.shoponline.query.CartQuery;
import com.shop.shoponline.query.EditCartQuery;
import com.shop.shoponline.service.UserShoppingCartService;
import com.shop.shoponline.vo.CartGoodsVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.shop.shoponline.common.utils.ObtainUserIdUtils.getUserId;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zero
 * @since 2023-11-14
 */

@Tag(name = "购物车管理")
@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class UserShoppingCartController {

    private final UserShoppingCartService userShoppingCartService;
    @Resource
    private HttpServletRequest request;

    @Operation(summary = "加入购物车")
    @PostMapping("add")
    public Result<CartGoodsVO> addShopCart(@RequestBody @Validated CartQuery query) {
        query.setUserId(getUserId(request));
        CartGoodsVO goodsVO = userShoppingCartService.addShopCart(query);
        return Result.ok(goodsVO);
    }

    @Operation(summary = "获取购物车列表")
    @GetMapping("list")
    public Result<List<CartGoodsVO>> shopCartList(HttpServletRequest request) {
        Integer userId = getUserId(request);
        List<CartGoodsVO> list = userShoppingCartService.shopCartList(userId);
        return Result.ok(list);
    }

    @Operation(summary = "修改购物车单品")
    @PutMapping("edit")
    public Result<CartGoodsVO> editShopCart(@RequestBody @Validated EditCartQuery query) {
        CartGoodsVO goodsVO = userShoppingCartService.editCart(query);
        return Result.ok(goodsVO);
    }

    @Operation(summary = "删除/清空购物车单品")
    @DeleteMapping("remove")
    public Result removeShopCart(@RequestBody List<Integer> ids, HttpServletRequest request) {
        Integer userId = getUserId(request);
        if (ids.size() == 0) {
            throw new ServerException("请选择需要删除的购物车商品");
        }
        userShoppingCartService.removeCartGoods(userId, ids);
        return Result.ok();
    }

    @Operation(summary = "购物车全选/取消全选")
    @PutMapping("selected")
    public Result editCartSelected(@RequestParam Boolean selected, HttpServletRequest request) {
        Integer userId = getUserId(request);
        userShoppingCartService.editCartSelected(selected, userId);
        return Result.ok();
    }
}
