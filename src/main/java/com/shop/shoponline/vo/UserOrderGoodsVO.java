package com.shop.shoponline.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserOrderGoodsVO {
    @Schema(description = "商品主键")
    private String id;
    @Schema(description = "商品名称")
    private String name;
    @Schema(description = "商品封面")
    private String picture;
    @Schema(description = "购买数量")
    private Integer count;
    @Schema(description = "属性集合")
    private String attrsText;
    @Schema(description = "商品原价")
    private Double price;
    @Schema(description = "实付价格")
    private Double payPrice;
    @Schema(description = "小计总价")
    private Double totalPrice;
    @Schema(description = "实付价格小计")
    private Double totalPayPrice;
}