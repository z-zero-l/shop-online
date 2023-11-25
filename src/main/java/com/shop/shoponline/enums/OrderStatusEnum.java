package com.shop.shoponline.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
    WAITING_FOR_PAYMENT(1, "待付款"),
    WAITING_FOR_SHIPMENT(2, "待发货"),
    WAITING_FOR_DELIVERY(3, "待收货"),
    WAITING_FOR_REVIEW(4, "待评价"),
    COMPLETED(5, "已完成"),
    CANCELLED(6, "已取消");

    private final Integer value;
    private final String name;
}