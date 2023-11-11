package com.shop.shoponline.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserVO {
    @Schema(description = "登录token")
    private String token;
    @Schema(description = "主键id")
    @NotNull(message = "用户Id 不能为空")
    private Integer Id;
    @Schema(description = "用户手机号")
    private String mobile;
    @Schema(description = "昵称")
    private String nickname;
    @Schema(description = "用户头像")
    private String avatar;
    @Schema(description = "用户名")
    private String account;
    @Schema(description = "性别")
    private Integer gender;
    @Schema(description = "生日")
//    @JsonFormat(pattern = DateUtils.DATE_PATTERN)
    private Timestamp birthday;
    @Schema(description = "职业")
    private String profession;
    @Schema(description = "省份编码")
    private String provinceCode;
    @Schema(description = "城市编码")
    private String cityCode;
    @Schema(description = "区/县编码")
    private String countyCode;
}