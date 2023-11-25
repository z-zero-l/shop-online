package com.shop.shoponline.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shop.shoponline.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogisticItemVO {
    @Schema(description = "id")
    private String id;
    @Schema(description = "信息文字")
    private String text;
    @Schema(description = "时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime time;
}
