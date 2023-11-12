package com.shop.shoponline.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeleteFlagEnum {

    OPEN_DELETE_FLAG(1, "错误标识开启"),
    CLOSE_DELETE_FLAG(0, "错误标识不开启");
    
    private final Integer value;
    private final String name;
}
