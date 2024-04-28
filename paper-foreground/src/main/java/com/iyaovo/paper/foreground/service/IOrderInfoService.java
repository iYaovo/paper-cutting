package com.iyaovo.paper.foreground.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.foreground.domain.dto.IdsParam;
import com.iyaovo.paper.foreground.domain.entity.OrderInfo;

public interface IOrderInfoService extends IService<OrderInfo> {
    /**
     * 展示所有订单
     */
    CommonPage<OrderInfo> showOrderInfo(Integer pageNum,
                                        Integer pageSize);

    /**
     * 通过订单状态获取订单
     */
    CommonPage<OrderInfo> showOrderInfoByStatus(Integer orderStatus,
                                                Integer pageNum,
                                                Integer pageSize);

    void deleteOrderInfo(IdsParam idsParam);

}
