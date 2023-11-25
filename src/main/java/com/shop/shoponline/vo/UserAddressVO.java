package com.shop.shoponline.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserAddressVO {
    @Schema(description = "主键id")
    private Integer id;
    @Schema(description = "省份编码")
    private String provinceCode;
    @Schema(description = "城市编码")
    private String cityCode;
    @Schema(description = "所在区/县编码")
    private String countyCode;
    @Schema(description = "详细地址")
    private String address;
    @Schema(description = "是否为默认地址")
    private Integer isDefault;
    @Schema(description = "表示选中的地址")
    private Boolean selected;
}