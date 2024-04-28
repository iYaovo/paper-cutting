/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: IdsParam
 * Author: 22932
 * Date: 2024/4/26 10:40:55
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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: IdsParam
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/26 10:40:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(defaultValue = "ids")
public class IdsParam {
   private long[] ids;
}

