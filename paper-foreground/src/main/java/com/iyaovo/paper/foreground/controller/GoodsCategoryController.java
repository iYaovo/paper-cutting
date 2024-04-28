/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: GoodsCategoryController
 * Author: 22932
 * Date: 2024/4/24 19:27:10
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
import com.iyaovo.paper.foreground.domain.dto.GoodsCategoryWithChildrenItem;
import com.iyaovo.paper.foreground.service.IGoodsCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: GoodsCategoryController
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/24 19:27:10
 */
@RestController
@RequestMapping("/category")
@Tag(name = "商品类别接口")
@Slf4j
@RequiredArgsConstructor
public class GoodsCategoryController {

   private final IGoodsCategoryService iGoodsCategoryService;

   /**
    * 展示类别
    */
   @Operation(summary = "查询所有一级分类及子分类")
   @RequestMapping(value = "/category/withChildren", method = RequestMethod.GET)
   @ResponseBody
   public CommonResult<List<GoodsCategoryWithChildrenItem>> listWithChildren() {
      List<GoodsCategoryWithChildrenItem> list = iGoodsCategoryService.listWithChildren();
      return CommonResult.success(list);
   }
}

