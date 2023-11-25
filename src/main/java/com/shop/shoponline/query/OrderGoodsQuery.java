package com.shop.shoponline.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class OrderGoodsQuery {
    @Schema(description = "商品id")
    private Integer id;
    @Schema(description = "商品数量")
    private Integer count;
    @Schema(description = "选中的商品属性")
    private String skus;
}

