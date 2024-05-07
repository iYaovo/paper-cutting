/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: DiscussDto
 * Author: 22932
 * Date: 2024/5/7 15:26:39
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: DiscussDto
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/5/7 15:26:39
 */
@Data
@Schema(defaultValue = "广场讨论DTO")
public class DiscussDto implements Serializable {

   private static final long serialVersionUID = 1L;

   @Schema(defaultValue = "父评论id(0为一级评论)")
   private Integer parentId;

   @Schema(defaultValue = "评论内容")
   private String discussContent;
}

