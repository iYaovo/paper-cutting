/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: BuyerRegisterDto
 * Author: 22932
 * Date: 2024/4/12 22:28:56
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.iyaovo.paper.common.domain.SexEnum;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @ClassName: BuyerRegisterDto
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 22:28:56
 */
@Schema(defaultValue = "买家注册DTO")
public class BuyerRegisterDto {

    @Schema(defaultValue = "买家id")
    private Long buyerId;


    @Schema(defaultValue = "买家名称")
    private String buyerName;

    @Schema(defaultValue = "账号")
    private String buyerAccount;

    @Schema(defaultValue = "密码")
    private String buyerPassword;

    @Schema(defaultValue = "验证码")
    private String verificationCode;
}

