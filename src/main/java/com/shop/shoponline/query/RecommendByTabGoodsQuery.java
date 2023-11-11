package com.shop.shoponline.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RecommendByTabGoodsQuery extends Query {
    @Schema(description = "分类 tabId")
    private Integer subType;
}