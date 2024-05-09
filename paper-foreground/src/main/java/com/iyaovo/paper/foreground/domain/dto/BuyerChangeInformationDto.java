/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: BuyerInfoDto
 * Author: 22932
 * Date: 2024/4/12 22:17:34
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
import lombok.Data;


/**
 * @ClassName: BuyerInfoDto
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 22:17:34
 */
@Data
@Schema(defaultValue = "买家更改信息DTO")
public class BuyerChangeInformationDto {

    @Schema(defaultValue = "买家爱好")
    private String buyerHobby;

    @Schema(defaultValue = "买家个签")
    private String buyerAutograph;

    @Schema(defaultValue = "买家头像url")
    private String picUrl;

}

