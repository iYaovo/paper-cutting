/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: ReceivingAddressServiceImpl
 * Author: 22932
 * Date: 2024/4/13 20:42:31
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iyaovo.paper.foreground.domain.dto.ReceivingAddressDto;
import com.iyaovo.paper.foreground.domain.entity.ReceivingAddress;
import com.iyaovo.paper.foreground.mapper.ReceivingAddressMapper;
import com.iyaovo.paper.foreground.service.IBuyerInfoService;
import com.iyaovo.paper.foreground.service.IReceivingAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ReceivingAddressServiceImpl
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/13 20:42:31
 */
@Service
@RequiredArgsConstructor
public class ReceivingAddressServiceImpl extends ServiceImpl<ReceivingAddressMapper, ReceivingAddress> implements IReceivingAddressService{

   private final ReceivingAddressMapper receivingAddressMapper;

   private final IBuyerInfoService iBuyerInfoService;

   @Override
   public void createReceivingAddress(ReceivingAddressDto receivingAddressDto) {
      receivingAddressMapper.insert(new ReceivingAddress(receivingAddressDto.getReceivingAddressId(),iBuyerInfoService.getBuyerInfo().getBuyerId(),receivingAddressDto.getRecipientName(),
              receivingAddressDto.getRecipientPhone(),receivingAddressDto.getRecipientRegion(),receivingAddressDto.getRecipientAddress()));
   }

   @Override
   public void updateReceivingAddress(ReceivingAddressDto receivingAddressDto) {
      receivingAddressMapper.updateById(new ReceivingAddress(receivingAddressDto.getReceivingAddressId(),iBuyerInfoService.getBuyerInfo().getBuyerId(),receivingAddressDto.getRecipientName(),
              receivingAddressDto.getRecipientPhone(),receivingAddressDto.getRecipientRegion(),receivingAddressDto.getRecipientAddress()));
   }

   @Override
   public List<ReceivingAddress> showReceivingAddress() {
      QueryWrapper<ReceivingAddress> receivingAddressQueryWrapper = new QueryWrapper<ReceivingAddress>();
      receivingAddressQueryWrapper.eq("buyer_id",iBuyerInfoService.getBuyerInfo().getBuyerId());
      return receivingAddressMapper.selectList(receivingAddressQueryWrapper);
   }

   @Override
   public ReceivingAddress getReceivingAddressById(Integer receivingAddressId) {
      QueryWrapper<ReceivingAddress> receivingAddressQueryWrapper = new QueryWrapper<ReceivingAddress>();
      receivingAddressQueryWrapper.eq("receiving_address_id",receivingAddressId);
      return receivingAddressMapper.selectOne(receivingAddressQueryWrapper);
   }

   @Override
   public void deleteReceivingAddressById(Integer receivingAddressId) {
      receivingAddressMapper.deleteById(receivingAddressId);
   }
}

