/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: ResourceVo
 * Author: 22932
 * Date: 2024/5/8 11:12:51
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.admin.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: ResourceVo
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/5/8 11:12:51
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "资源")
public class ResourceVo {

   /**
    * 资源名称path
    */
   @Schema(description = "资源path")
   private String resourcePath;


   /**
    * 资源base64形式
    */
   @Schema(description = "资源的base64形式")
   private String resourceBase64;
}


