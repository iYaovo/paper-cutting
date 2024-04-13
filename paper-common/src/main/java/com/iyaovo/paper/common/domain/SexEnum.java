/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: SexEnum
 * Author: 22932
 * Date: 2024/4/12 18:01:08
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.common.domain;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: SexEnum
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/12 18:01:08
 */
public enum SexEnum {

    MAN(0,"男"),
    WOMAN(1,"女"),
    UNKNOWN(2,"未知");


    @EnumValue
    private Integer sexId;
    @JsonValue
    private String sexName;

    SexEnum(Integer sexId, String sexName) {
        this.sexId = sexId;
        this.sexName = sexName;
    }
}

