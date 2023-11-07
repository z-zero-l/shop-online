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
@TableName("t_index_recommend")
@ApiModel(value = "IndexRecommend对象", description = "")
public class IndexRecommend {

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("推荐标题")
    @TableField("name")
    private String name;

    @ApiModelProperty("推荐描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("tab封面图")
    @TableField("cover")
    private String cover;

    @ApiModelProperty("推荐首页封面图，逗号分开")
    @TableField("pictures")
    private String pictures;

    @ApiModelProperty("逻辑删除(0-未删除，1-删除)")
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
