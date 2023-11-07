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
@TableName("t_user_order")
@ApiModel(value = "UserOrder对象", description = "")
public class UserOrder {

    @ApiModelProperty("自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("收货地址")
    @TableField("address_id")
    private Integer addressId;

    @ApiModelProperty("应付金额")
    @TableField("total_price")
    private Double totalPrice;

    @ApiModelProperty("总数量")
    @TableField("total_count")
    private Integer totalCount;

    @ApiModelProperty("总运费")
    @TableField("total_freight")
    private Double totalFreight;

    @ApiModelProperty("订单编号")
    @TableField("order_number")
    private String orderNumber;

    @ApiModelProperty("订单状态，1为待付款、2为待发货、3为待收货、4为待评价、5为已完成、6为已取消，未传该参数或0为全部")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("1-不限，2-工作日，3-双休或假日")
    @TableField("delivery_time_type")
    private Integer deliveryTimeType;

    @ApiModelProperty("订单备注")
    @TableField("buyer_message")
    private String buyerMessage;

    @ApiModelProperty("1-在线支付，2-货到付款")
    @TableField("pay_type")
    private Integer payType;

    @ApiModelProperty("线上支付渠道，1-支付宝，2-微信")
    @TableField("pay_channel")
    private Integer payChannel;

    @ApiModelProperty("订单取消理由")
    @TableField("cancel_reason")
    private String cancelReason;

    @ApiModelProperty("删除标识（0-未删除，1-已删除）")
    @TableField("delete_flag")
    @TableLogic
    private Integer deleteFlag;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("付款时间")
    @TableField("pay_time")
    private LocalDateTime payTime;

    @ApiModelProperty("发货时间")
    @TableField("consign_time")
    private LocalDateTime consignTime;

    @ApiModelProperty("预计到货时间")
    @TableField("arrival_estimated_time")
    private LocalDateTime arrivalEstimatedTime;

    @ApiModelProperty("交易完成时间")
    @TableField("end_time")
    private LocalDateTime endTime;

    @ApiModelProperty("交易关闭时间")
    @TableField("close_time")
    private LocalDateTime closeTime;
}
