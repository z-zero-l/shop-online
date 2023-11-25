package com.shop.shoponline.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class OrderInfoVO {
    @Schema(description = "商品件数")
    private Integer goodsCount;
    @Schema(description = "价格总计")
    private Double totalPrice;
    @Schema(description = "应付总计")
    private Double totalPayPrice;
    @Schema(description = "邮费")
    private Double postFee;
    @Schema(description = "折扣总计")
    private Double discountPrice;
}