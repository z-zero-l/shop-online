package com.shop.shoponline.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class OrderQuery extends Query {
    @Schema(description = "订单状态，1为待付款、2为待发货、3为待收货、4为待评价、5为已完成、6为已取消，未传该参数或0为全部")
    private Integer orderType;
    @Schema(description = "用户id")
    private Integer userId;
}