package com.shop.shoponline.vo;

import com.alibaba.fastjson2.JSONObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class OrderLogisticVO {
    @Schema(description = "快递公司")
    private JSONObject company;
    @Schema(description = "商品件数")
    private Integer count;
    @Schema(description = "物流日志")
    private List<LogisticItemVO> list;
}
