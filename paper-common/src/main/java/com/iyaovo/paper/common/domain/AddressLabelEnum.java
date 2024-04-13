package com.iyaovo.paper.common.domain;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AddressLabelEnum {
    HOME(0,"家"),
    COMPANY(1,"公司"),
    SCHOOL(2,"学校"),
    PARENT(3,"父母"),
    FRIEND(4,"朋友");

    @EnumValue
    private Integer addressLabelId;
    @JsonValue
    private String addressLabelName;

    AddressLabelEnum(Integer addressLabelId, String addressLabelName) {
        this.addressLabelId = addressLabelId;
        this.addressLabelName = addressLabelName;
    }
}
