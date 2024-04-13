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

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.foreground.domain.dto.ReceivingAddressDto;
import com.iyaovo.paper.foreground.domain.entity.ReceivingAddress;
import com.iyaovo.paper.foreground.mapper.ReceivingAddressMapper;
import com.iyaovo.paper.foreground.service.IReceivingAddressService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ReceivingAddressServiceImpl
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/13 20:42:31
 */
@Service
public class ReceivingAddressServiceImpl extends ServiceImpl<ReceivingAddressMapper, ReceivingAddress> implements IReceivingAddressService{

   @Override
   public void newReceivingAddress(ReceivingAddressDto receivingAddressDto) {

   }

   @Override
   public void updateReceivingAddress(ReceivingAddressDto receivingAddressDto) {

   }

   @Override
   public CommonPage<ReceivingAddressDto> showReceivingAddress(Integer pageNum, Integer pageSize) {
      return null;
   }
}

