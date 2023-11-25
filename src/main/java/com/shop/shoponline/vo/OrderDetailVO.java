package com.shop.shoponline.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shop.shoponline.common.utils.DateUtils;
import com.shop.shoponline.entity.UserOrderGoods;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDetailVO {
    @Schema(description = "订单id")
    private Integer id;
    @Schema(description = "支付方式 1-在线支付，2-货到付款")
    private Integer payType;
    @Schema(description = "订单状态，1-待付款，2-待发货，3-待收货，4-待评价，5-已完成，6-已取消")
    @JsonProperty("orderState")
    private Integer status;
    @Schema(description = "付款截止时间")
    private LocalDateTime payLatestTime;
    @Schema(description = "倒计时--剩余的秒数 -1 表示已经超时，正数表示倒计时未结束")
    private Integer countdown = -1;
    @Schema(description = "邮费")
    @JsonProperty("postFree")
    private Double totalFreight;
    @Schema(description = "实付金额")
    @JsonProperty("payMoney")
    private Double totalPrice;
    @Schema(description = "支付渠道，1支付宝、2微信")
    private Integer payChannel;
    @Schema(description = "金额合计")
    private Double totalMoney;
    @Schema(description = "数量合计")
    @JsonProperty("totalNum")
    private Integer totalCount;
    @Schema(description = "配送时间类型，1为不限，2为工作日，3为双休或假日")
    private Integer deliveryTimeType;
    @Schema(description = "收货人")
    private String receiverContact;
    @Schema(description = "收货人手机")
    private String receiverMobile;
    @Schema(description = "收货人地址")
    private String receiverAddress;
    @Schema(description = "付款时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime payTime;
    @Schema(description = "发货时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime consignTime;
    @Schema(description = "预计到货时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime arrivalEstimatedTime;
    @Schema(description = "交易完成时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime endTime;
    @Schema(description = "交易关闭时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime closeTime;
    @Schema(description = "完成评价时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime evaluationTime;
    @Schema(description = "订单创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime createTime;
    @Schema(description = "商品集合")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    List<UserOrderGoods> skus;
}