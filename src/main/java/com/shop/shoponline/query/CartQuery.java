package com.shop.shoponline.query;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CartQuery {
    @Schema(description = "商品id")
    @NotNull(message = "商品主键id不能为空")
    private String id;
    @Schema(description = "加入购物车数量")
    @NotNull(message = "加入购物车数量不能为空")
    private Integer count;
    @Schema(description = "选中商品属性")
    @NotBlank(message = "选中商品属性不能为空")
    private String attrsText;
    @Schema(description = "用户id")
    private Integer userId;
}