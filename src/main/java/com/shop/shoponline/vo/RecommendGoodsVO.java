package com.shop.shoponline.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RecommendGoodsVO {
    @Schema(description = "主键id")
    private String Id;
    @Schema(description = "商品名称")
    private String  name;
    @JsonProperty("desc")
    @Schema(description = "商品简介")
    private String description;
    @Schema(description = "售价")
    private String price;
    @Schema(description = "封面图")
    @JsonProperty("picture")
    private String cover;
    @Schema(description = "销售额")
    @JsonProperty("orderNum")
    private String salesCount;
}