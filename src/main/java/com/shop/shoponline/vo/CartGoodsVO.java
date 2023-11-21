package com.shop.shoponline.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CartGoodsVO {
    @Schema(description = "主键id")
    private Integer id;
    @Schema(description = "商品id")
    private Integer goodsId;
    @Schema(description = "商品名称")
    private String name;
    @Schema(description = "属性")
    private String attrsText;
    @Schema(description = "商品图片")
    private String picture;
    @Schema(description = "加入时价格")
    private Double price;
    @Schema(description = "当前价格")
    private Double nowPrice;
    @Schema(description = "是否选中")
    private Boolean selected;
    @Schema(description = "库存")
    private Integer stock;
    @Schema(description = "数量")
    private Integer count;
    @Schema(description = "折扣信息")
    private Double discount;
    @Schema(description = "是否为有效信息")
    private Boolean isEffective = true;
}