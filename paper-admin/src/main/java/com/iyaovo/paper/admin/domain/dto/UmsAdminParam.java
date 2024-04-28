package com.iyaovo.paper.admin.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


/**
 * 用户注册参数
 * Created by macro on 2018/4/26.
 */
@Getter
@Setter
public class UmsAdminParam {
    @NotEmpty
    @Schema(defaultValue="用户名", required = true)
    private String username;
    @NotEmpty
    @Schema(defaultValue="密码", required = true)
    private String password;
    @Schema(defaultValue="用户头像")
    private String icon;
    @Email
    @Schema(defaultValue="邮箱")
    private String email;
    @Schema(defaultValue="用户昵称")
    private String nickName;
    @Schema(defaultValue="备注")
    private String note;
}
