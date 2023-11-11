package com.shop.shoponline.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddressDefaultEnum {
    NOT_DEFAULT_ADDRESS(0, "不是默认地址"),
    DEFAULT_ADDRESS(1, "默认地址");
    private final Integer value;
    private final String name;
}