/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: BuyerInfoController
 * Author: 22932
 * Date: 2024/4/12 22:50:41
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.controller;

import com.iyaovo.paper.common.api.CommonResult;
import com.iyaovo.paper.foreground.domain.dto.BuyerChangeInformationDto;
import com.iyaovo.paper.foreground.domain.dto.BuyerLoginDto;
import com.iyaovo.paper.foreground.domain.dto.BuyerRegisterDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: BuyerInfoController
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 22:50:41
 */
@RestController
@RequestMapping("/foreground")
@Tag(name = "买家信息处理接口")
@Slf4j
@RequiredArgsConstructor
public class BuyerInfoController {


   /**
    * 用户注册
    * @param buyerRegisterDto 用户注册DTO
    * @return CommonResult
    */
   @PostMapping("/buyer/register")
   @Operation(summary = "用户注册")
   public CommonResult registerBuyer(@Valid @RequestBody BuyerRegisterDto buyerRegisterDto) {
      return CommonResult.success();
   }

   /**
    * 用户登录
    * @param buyerLoginDto
    * @return
    */
   @PostMapping("/buyer/login")
   @Operation(summary = "用户登录")
   public CommonResult loginBuyer(@Valid @RequestBody BuyerLoginDto buyerLoginDto) {
      return CommonResult.success();
   }

   /**
    * 用户登出
    * @param
    * @return
    */
   @PutMapping("/buyer/logout")
   @Operation(summary = "用户登出")
   public CommonResult logoutBuyer() {
      return CommonResult.success();
   }

   /**
    * 更换头像
    * @return
    */
   @PutMapping("/buyer/changeAvatar")
   @Operation(summary = "用户更换头像")
   public CommonResult changeAvatar() {
      return CommonResult.success();
   }

   /**
    * 更改信息
    * @param buyerChangeInformationDto
    * @return
    */
   @PostMapping("/buyer/changeInformation")
   @Operation(summary = "用户更改信息")
   public CommonResult changeInformation(@Valid @RequestBody BuyerChangeInformationDto buyerChangeInformationDto) {
      return CommonResult.success();
   }

   /**
    * 每日签到
    * @param
    * @return
    */
   @PostMapping("/buyer/dailySign")
   @Operation(summary = "用户每日签到")
   public CommonResult dailySign() {
      return CommonResult.success();
   }

}

