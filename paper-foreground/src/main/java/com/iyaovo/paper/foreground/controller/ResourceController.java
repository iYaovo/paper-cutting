/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: ResourceController
 * Author: 22932
 * Date: 2024/5/8 11:32:35
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
import com.iyaovo.paper.foreground.domain.vo.ResourceVo;
import com.iyaovo.paper.foreground.service.IResourceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: ResourceController
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/5/8 11:32:35
 */
@RestController
@RequestMapping("/resource")
@Tag(name = "图片资源接口")
@Slf4j
@RequiredArgsConstructor
public class ResourceController {

  private final IResourceService iResourceService;

   @PostMapping("/add")
   @Operation(summary = "添加资源")
   public CommonResult addResource(MultipartFile file) {
      return CommonResult.success(iResourceService.addResource(file));
   }

}

