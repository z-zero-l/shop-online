package com.shop.shoponline.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class CategoryChildrenGoodsVO {
    @Schema(description = "主键id")
    private Integer id;
    @Schema(description = "分类名称")
    private String name;
    @JsonProperty("picture")
    @Schema(description = "封面图")
    private String icon;
    @Schema(description = "父级id")
    private Integer parentId;
    @Schema(description = "父级分类名称")
    private String parentName;
    @Schema(description = "商品列表")
    private List<RecommendGoodsVO> goods;
}