package com.iyaovo.paper.common.domain;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatusEnum {
    PENDING_PAYMENT(0,"待付款"),
    PENDING_DELIVERY(1,"待发货"),
    PENDING_RECEIVING(2,"待收货"),
    PENDING_EVALUATE(3,"待评价"),
    REFUND_SERVICE(4,"退款/售后");

    @EnumValue
    private Integer orderStatusId;
    @JsonValue
    private String orderStatusName;

    OrderStatusEnum(Integer orderStatusId, String orderStatusName) {
        this.orderStatusId = orderStatusId;
        this.orderStatusName = orderStatusName;
    }
}
