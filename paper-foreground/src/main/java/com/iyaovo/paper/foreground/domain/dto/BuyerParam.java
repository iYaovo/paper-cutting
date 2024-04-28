/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: BuyerLoginDto
 * Author: 22932
 * Date: 2024/4/12 22:29:16
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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName: BuyerLoginDto
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 22:29:16
 */
@Data
@AllArgsConstructor
@Schema(defaultValue = "买家登录DTO")
public class BuyerParam {
    @Schema(defaultValue = "账号")
    @NotEmpty
    @Size(max = 10,min = 5)
    private String buyerAccount;


    @Schema(defaultValue = "密码")
    @NotEmpty
    @Size(max = 10,min = 5)
    private String buyerPassword;
}

