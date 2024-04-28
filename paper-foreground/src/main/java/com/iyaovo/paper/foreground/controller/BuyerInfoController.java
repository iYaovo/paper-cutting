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

import cn.hutool.core.collection.CollUtil;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.common.api.CommonResult;
import com.iyaovo.paper.foreground.domain.dto.BuyerChangeInformationDto;
import com.iyaovo.paper.foreground.domain.dto.BuyerParam;
import com.iyaovo.paper.foreground.domain.entity.GoodsInfo;
import com.iyaovo.paper.foreground.domain.entity.ShopInfo;
import com.iyaovo.paper.foreground.domain.vo.BuyerInfoSimpleVo;
import com.iyaovo.paper.foreground.domain.vo.BuyerInfoVo;
import com.iyaovo.paper.foreground.service.IBuyerInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @ClassName: BuyerInfoController
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 22:50:41
 */
@RestController
@RequestMapping("/buyer")
@Tag(name = "买家信息处理接口")
@Slf4j
@RequiredArgsConstructor
public class BuyerInfoController {

   @Value("${jwt.tokenHeader}")
   private String tokenHeader;
   @Value("${jwt.tokenHead}")
   private String tokenHead;

   private final IBuyerInfoService iBuyerInfoService;


   /**
    * 用户注册
    * @param buyerParam 用户注册param
    * @return CommonResult
    */
   @PostMapping("/register")
   @Operation(summary = "用户注册")
   public CommonResult registerBuyer(@Valid @RequestBody BuyerParam buyerParam) {
      iBuyerInfoService.registerBuyer(buyerParam);
      return CommonResult.success();
   }

   /**
    * 用户登录
    * @param buyerParam
    * @return
    */
   @PostMapping("/login")
   @Operation(summary = "用户登录")
   public CommonResult loginBuyer(@Valid @RequestBody BuyerParam buyerParam) {
      return CommonResult.success(iBuyerInfoService.loginBuyer(buyerParam));
   }

   /**
    * 用户登出
    * @param
    * @return
    */
   @PutMapping("/logout")
   @Operation(summary = "用户登出")
   public CommonResult logoutBuyer() {
      return CommonResult.success();
   }

   /**
    * 用户更改密码
    * @param
    * @return
    */
   @PostMapping("/updatePassword")
   @Operation(summary = "用户更改密码")
   public CommonResult updatePassword(@RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword) {
      iBuyerInfoService.updatePassword(oldPassword,newPassword);
      return CommonResult.success();
   }

   /**
    * 更换头像
    * @return
    */
   @PostMapping("/changeAvatar")
   @Operation(summary = "用户更换头像")
   public CommonResult changeAvatar() {
      return CommonResult.success();
   }

   /**
    * 更改信息
    * @param buyerChangeInformationDto
    * @return
    */
   @PostMapping("/changeInformation")
   @Operation(summary = "用户更改信息")
   public CommonResult changeInformation(@Valid @RequestBody BuyerChangeInformationDto buyerChangeInformationDto) {
      iBuyerInfoService.changeInformation(buyerChangeInformationDto);
      return CommonResult.success();
   }

   /**
    * 每日签到
    * @param
    * @return
    */
   @PostMapping("/dailySign")
   @Operation(summary = "用户每日签到")
   public CommonResult dailySign() {
      iBuyerInfoService.dailySign();
      return CommonResult.success();
   }

   /**
    * 查询签到
    */
   @GetMapping("/showSign")
   @Operation(summary = "查询用户签到")
   public CommonResult showSign(@RequestParam("time") Long time) {
      Map<String,List> signMap = new HashMap<>();
      signMap.put("signList",iBuyerInfoService.showSign(time));
      return CommonResult.success(signMap);
   }

   /**
    * 展示用户简易信息
    * @return
    */
   @GetMapping("/showSimpleInformation")
   @Operation(summary = "展示用户简易信息(主页)")
   public CommonResult showSimpleInformation() {
      return CommonResult.success(iBuyerInfoService.showSimpleInformation());
   }

   /**
    * 展示信息
    * @return
    */
   @GetMapping("/showInformation")
   @Operation(summary = "展示用户信息")
   public CommonResult showInformation() {
      return CommonResult.success(iBuyerInfoService.showInformation());
   }

   /**
    * 展示用户收藏
    * @param pageNum
    * @param pageSize
    * @return
    */
   @GetMapping("/showGoodsCollection")
   @Operation(summary = "展示商品收藏")
   public CommonResult showGoodsCollection(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
      return CommonResult.success(iBuyerInfoService.showGoodsCollection(pageNum,pageSize));
   }

   /**
    * 展示店铺关注
    * @param pageNum
    * @param pageSize
    * @return
    */
   @GetMapping("/showShopFollow")
   @Operation(summary = "展示店铺关注")
   public CommonResult showShopFollow(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
      return CommonResult.success(iBuyerInfoService.showShopFollow(pageNum,pageSize));
   }

   /**
    * 展示近期浏览
    * @param pageNum
    * @param pageSize
    * @return
    */
   @GetMapping("/showGoodsViews")
   @Operation(summary = "展示商品浏览")
   public CommonResult showGoodsViews(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
      return CommonResult.success(iBuyerInfoService.showGoodsViews(pageNum,pageSize));
   }
}

