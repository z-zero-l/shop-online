package com.shop.shoponline.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author zero
 * @since 2023-11-07
 */
@Getter
@Setter
@TableName("t_goods_specification_detail")
@ApiModel(value = "GoodsSpecificationDetail对象", description = "")
public class GoodsSpecificationDetail {

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("规格id")
    @TableField("goods_id")
    private String goodsId;

    @ApiModelProperty("商品名称")
    @TableField("cover")
    private String cover;

    @ApiModelProperty("库存数量")
    @TableField("inventory")
    private Integer inventory;

    @ApiModelProperty("当前价格")
    @TableField("price")
    private Double price;

    @ApiModelProperty("原价")
    @TableField("old_price")
    private Double oldPrice;

    @ApiModelProperty("规格详情")
    @TableField("specs")
    private String specs;

    @ApiModelProperty("逻辑删除(0-未删除，1-已删除)")
    @TableField("delete_flag")
    @TableLogic
    private Integer deleteFlag;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
