package com.iyaovo.paper.foreground.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.foreground.domain.dto.ReceivingAddressDto;
import com.iyaovo.paper.foreground.domain.entity.ReceivingAddress;

public interface IReceivingAddressService extends IService<ReceivingAddress> {

    /**
     * 创建地址
     */
    void newReceivingAddress(ReceivingAddressDto receivingAddressDto);

    /**
     * 更改地址
     */
    void updateReceivingAddress(ReceivingAddressDto receivingAddressDto);

    /**
     * 展示所有地址
     */
    CommonPage<ReceivingAddressDto> showReceivingAddress(Integer pageNum,
                                                         Integer pageSize);

}
