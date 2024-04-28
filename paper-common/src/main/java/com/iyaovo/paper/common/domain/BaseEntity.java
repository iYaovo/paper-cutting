/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: BaseEntity
 * Author: 22932
 * Date: 2024/4/11 21:18:40
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.common.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName: BaseEntity
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/11 21:18:40
 */
   @Data
   @AllArgsConstructor
   @NoArgsConstructor
   public class BaseEntity implements Serializable {
      private static final long serialVersionUID = 1L;
      /**
       * 创建时间
       */
      @JsonIgnore
      @TableField("create_time")
      private LocalDateTime createTime;
      /**
       * 修改时间
       */
      @JsonIgnore
      @TableField("update_time")
      private LocalDateTime updateTime;
      /**
       * 逻辑删除(1删除 0未删除)
       */
      @JsonIgnore
      @TableLogic
      @TableField("del_flag")
      private boolean delFlag;
   }


