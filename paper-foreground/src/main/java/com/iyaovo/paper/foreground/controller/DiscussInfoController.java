/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: DiscussInfoController
 * Author: 22932
 * Date: 2024/5/7 15:37:43
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.common.api.CommonResult;
import com.iyaovo.paper.foreground.domain.dto.DiscussDto;
import com.iyaovo.paper.foreground.domain.entity.BuyerInfo;
import com.iyaovo.paper.foreground.domain.entity.DiscussInfo;
import com.iyaovo.paper.foreground.domain.vo.DiscussCommentVo;
import com.iyaovo.paper.foreground.domain.vo.DiscussInfoVo;
import com.iyaovo.paper.foreground.service.IDiscussInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DiscussInfoController
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/5/7 15:37:43
 */
@RestController
@RequestMapping("/discuss")
@Tag(name = "广场讨论接口")
@Slf4j
@RequiredArgsConstructor
public class DiscussInfoController {

   private final IDiscussInfoService iDiscussInfoService;

   @GetMapping("/show/discuss")
   @Operation(summary = "展示讨论")
   public CommonResult<CommonPage<DiscussInfoVo>> showDiscuss(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
      return CommonResult.success(iDiscussInfoService.showDiscuss(pageNum,pageSize));
   }

   @GetMapping("/show/comment/{discussId}")
   @Operation(summary = "展示评论")
   public CommonResult<List<DiscussCommentVo>> showDiscussComments(@PathVariable("discussId") Integer discussId) {
      return CommonResult.success(iDiscussInfoService.showDiscussComments(discussId));
   }

   @GetMapping("/like/{discussId}")
   @Operation(summary = "点赞讨论")
   public CommonResult like(@PathVariable("discussId") Integer discussId) {
      iDiscussInfoService.like(discussId);
      return CommonResult.success();
   }

   @PostMapping("/publish")
   @Operation(summary = "发表讨论")
   public CommonResult publishDiscuss(@RequestBody DiscussDto discussDto) {
      iDiscussInfoService.publishDiscuss(discussDto);
      return CommonResult.success();
   }
}

