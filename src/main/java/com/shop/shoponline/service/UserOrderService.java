package com.shop.shoponline.service;

import com.shop.shoponline.common.result.PageResult;
import com.shop.shoponline.entity.UserOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.shoponline.entity.UserOrderGoods;
import com.shop.shoponline.query.CancelGoodsQuery;
import com.shop.shoponline.query.OrderPreQuery;
import com.shop.shoponline.query.OrderQuery;
import com.shop.shoponline.vo.OrderDetailVO;
import com.shop.shoponline.vo.SubmitOrderVO;
import com.shop.shoponline.vo.UserOrderVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zero
 * @since 2023-11-25
 */
public interface UserOrderService extends IService<UserOrder> {
    /**
     * 新增订单
     *
     * @param orderVO
     * @return Integer
     */
    Integer addGoodsOrder(UserOrderVO orderVO);

    /**
     * 获取订单详情
     *
     * @param id
     * @return OrderDetailVO
     */
    OrderDetailVO getOrderDetail(Integer id);

    /**
     * 填写订单-获取预付订单
     *
     * @param userId
     * @return SubmitOrderVO
     */
    SubmitOrderVO getPreOrderDetail(Integer userId);

    /**
     * 填写订单-立即支付
     *
     * @param orderPreQuery
     * @return SubmitOrderVO
     */
    SubmitOrderVO getPreNowOrderDetail(OrderPreQuery orderPreQuery);

    /**
     * 填写订单-再次购买
     *
     * @param id
     * @return SubmitOrderVO
     */
    SubmitOrderVO getRepurchaseOrderDetail(Integer id);

    /**
     * 订单列表
     *
     * @param query
     * @return PageResult
     */
    PageResult<OrderDetailVO> getOrderList(OrderQuery query);

    /**
     * 取消订单
     *
     * @param query
     * @return OrderDetailVO
     */
    OrderDetailVO cancelOrder(CancelGoodsQuery query);

    /**
     * 删除订单
     *
     * @param ids
     */
    void deleteOrder(List<Integer> ids, Integer userId);
}
