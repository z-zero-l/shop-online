package com.shop.shoponline.vo;

import com.shop.shoponline.query.OrderGoodsQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class UserOrderVO {
    @Schema(description = "商品集合")
    List<OrderGoodsQuery> goods;
    @Schema(description = "用户id")
    private Integer userId;
    @Schema(description = "收货地址id")
    @NotNull(message = "收货地址不能为空")
    private Integer addressId;
    @Schema(description = "配送时间类型，1：不限，2：工作日，3：双休或假日")
    @NotNull(message = "配送类型不能为空")
    private Integer deliveryType;
    @Schema(description = "买家留言")
    private String buyerMessage;
    @Schema(description = "支付方式，1：在线支付，2：货到付款")
    @NotNull(message = "支付方式不能为空")
    private Integer payType;
    @Schema(description = "支付渠道，1-支付宝，2-微信")
    @NotNull(message = "支付方渠道不能为空")
    private Integer payChannel;
}