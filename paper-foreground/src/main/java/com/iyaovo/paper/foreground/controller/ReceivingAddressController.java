/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: ReceivingAddressController
 * Author: 22932
 * Date: 2024/4/13 21:04:11
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.controller;

import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.common.api.CommonResult;
import com.iyaovo.paper.foreground.domain.dto.ReceivingAddressDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: ReceivingAddressController
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/13 21:04:11
 */
@RestController
@RequestMapping("/foreground/receivingAddress")
@Tag(name = "收货地址接口")
@Slf4j
@RequiredArgsConstructor
public class ReceivingAddressController {

   /**
    * 新建收货地址
    * @param
    */
   @PostMapping("")
   @Operation(summary = "新建收货地址")
   public CommonResult newReceivingAddress(@RequestBody ReceivingAddressDto receivingAddressDto) {
      return CommonResult.success();
   }

   /**
    * 更新收货地址
    * @param
    */
   @PutMapping("")
   @Operation(summary = "更改收货地址")
   public CommonResult updateReceivingAddress(@RequestBody ReceivingAddressDto receivingAddressDto) {
      return CommonResult.success();
   }

   /**
    * 展示全部收货地址
    * @param
    */
   @GetMapping("")
   @Operation(summary = "展示全部收货地址")
   public CommonResult<CommonPage<ReceivingAddressDto>> showReceivingAddress(@RequestParam("pageNum") Integer pageNum,
                                                               @RequestParam("pageSize") Integer pageSize) {
      return CommonResult.success();
   }
}

