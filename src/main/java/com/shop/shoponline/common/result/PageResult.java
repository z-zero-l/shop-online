package com.shop.shoponline.common.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(description = "总记录数")
    private int counts;
    @Schema(description = "分页条数")
    private int pageSize;
    @Schema(description = "当前页码")
    private int page;
    @Schema(description = "总页数")
    private int pages;
    @Schema(description = "列表数据")
    private List<T> list;

    public PageResult(long counts, int pageSize, int page, long pages, List<T> list) {
        this.counts = (int) counts;
        this.pageSize = pageSize;
        this.page = page;
        this.pages = (int) pages;
        this.list = list;
    }
}
