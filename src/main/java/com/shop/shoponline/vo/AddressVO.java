package com.shop.shoponline.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddressVO {
    @Schema(description = "用户id")
    Integer userId;
    @Schema(description = "主键id")
    Integer id;
    @Schema(description = "收件人姓名")
    @NotBlank(message = "收货人姓名不能为空")
    private String receiver;
    @Schema(description = "联系方式")
    @NotBlank(message = "联系方式不能为空")
    private String contact;
    @Schema(description = "省份编码")
    @NotBlank(message = "省份编码不能为空")
    private String provinceCode;
    @Schema(description = "城市编码")
    @NotBlank(message = "城市编码不能为空")
    private String cityCode;
    @Schema(description = "区/县编码")
    @NotBlank(message = "区县编码不能为空")
    private String countyCode;
    @Schema(description = "详细地址")
    @NotBlank(message = "详细地址不能为空")
    private String address;
    @Schema(description = "是否为默认地址")
    private Integer isDefault;
}