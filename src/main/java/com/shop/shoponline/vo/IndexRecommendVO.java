package com.shop.shoponline.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "首页热门推荐")
public class IndexRecommendVO {
    @Schema(description = "主键Id")
    private Integer id;
    @Schema(description = "推荐商品图片集合")
    private List<String> pictures;
    @JsonProperty("title")
    @Schema(description = "推荐名称")
    private String name;
    @JsonProperty("alt")
    @Schema(description = "推荐简介")
    private String description;
}