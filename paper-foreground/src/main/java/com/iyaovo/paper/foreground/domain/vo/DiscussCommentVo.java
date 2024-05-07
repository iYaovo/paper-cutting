/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: DiscussCommentVo
 * Author: 22932
 * Date: 2024/5/7 15:03:48
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: DiscussCommentVo
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/5/7 15:03:48
 */
@Schema(description = "广场评论vo")
@Slf4j
@Data
@AllArgsConstructor
public class DiscussCommentVo {
   /**
    * 评论id
    */
   @Schema(defaultValue = "评论id")
   private Integer discussId;

   /**
    * 评论内容
    */
   @Schema(defaultValue = "评论内容")
   private String discussContent;

   /**
    * 评论人头像
    */
   @Schema(defaultValue = "评论人头像")
   private String picUrl;

   /**
    * 评论人昵称
    */
   @Schema(defaultValue = "评论人昵称")
   private String name;
}

