package com.iyaovo.paper.foreground.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.foreground.domain.dto.ReceivingAddressDto;
import com.iyaovo.paper.foreground.domain.entity.ReceivingAddress;

import java.util.List;

public interface IReceivingAddressService extends IService<ReceivingAddress> {

    /**
     * 创建地址
     */
    void createReceivingAddress(ReceivingAddressDto receivingAddressDto);

    /**
     * 更改地址
     */
    void updateReceivingAddress(ReceivingAddressDto receivingAddressDto);

    /**
     * 展示所有地址
     */
    List<ReceivingAddress> showReceivingAddress();

    ReceivingAddress getReceivingAddressById(Integer receivingAddressId);

    void deleteReceivingAddressById(Integer receivingAddressId);
}
