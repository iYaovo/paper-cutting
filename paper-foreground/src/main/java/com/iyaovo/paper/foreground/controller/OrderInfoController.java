/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: OrderInfoController
 * Author: 22932
 * Date: 2024/4/13 21:01:49
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
import com.iyaovo.paper.foreground.domain.entity.OrderInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: OrderInfoController
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/13 21:01:49
 */
@RestController
@RequestMapping("/foreground/order")
@Tag(name = "订单信息接口")
@Slf4j
@RequiredArgsConstructor
public class OrderInfoController {

   /**
    * 展示全部订单
    * @param
    */
   @GetMapping("")
   @Operation(summary = "展示全部订单")
   public CommonResult<CommonPage<OrderInfo>> showOrderInfo(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
      return CommonResult.success();
   }

   /**
    * 展示订单by状态
    * @param
    */
   @GetMapping("/{orderStatus}")
   @Operation(summary = "展示订单by状态")
   public CommonResult<CommonPage<OrderInfo>> showOrderInfoByStatus(@PathVariable("orderStatus") Integer orderStatus,
                                                      @RequestParam("pageNum") Integer pageNum,
                                                      @RequestParam("pageSize") Integer pageSize) {
      return CommonResult.success();
   }
}

