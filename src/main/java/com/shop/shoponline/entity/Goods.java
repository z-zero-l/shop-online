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
@TableName("t_goods")
@ApiModel(value = "Goods对象", description = "")
public class Goods {

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty("商品价格")
    @TableField("price")
    private Double price;

    @ApiModelProperty("商品原价")
    @TableField("old_price")
    private Double oldPrice;

    @ApiModelProperty("封面图")
    @TableField("cover")
    private String cover;

    @ApiModelProperty("分类id")
    @TableField("category_id")
    private Integer categoryId;

    @ApiModelProperty("推荐tab_id")
    @TableField("tab_id")
    private Integer tabId;

    @ApiModelProperty("商品名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("备注")
    @TableField("description")
    private String description;

    @ApiModelProperty("库存数量")
    @TableField("inventory")
    private Integer inventory;

    @ApiModelProperty("折扣")
    @TableField("discount")
    private Double discount;

    @ApiModelProperty("销量")
    @TableField("sales_count")
    private Integer salesCount;

    @ApiModelProperty("运费")
    @TableField("freight")
    private Double freight;

    @ApiModelProperty("商品详情页轮播图(逗号分隔)")
    @TableField("main_pictures")
    private String mainPictures;

    @ApiModelProperty("商品详情图片(逗号分隔)")
    @TableField("product_pictures")
    private String productPictures;

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
