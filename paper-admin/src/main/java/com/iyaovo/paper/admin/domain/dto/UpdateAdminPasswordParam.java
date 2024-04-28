package com.iyaovo.paper.admin.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


/**
 * 修改用户名密码参数
 * Created by macro on 2019/10/9.
 */
@Getter
@Setter
public class UpdateAdminPasswordParam {
    @NotEmpty
    @Schema(defaultValue="用户名", required = true)
    private String username;
    @NotEmpty
    @Schema(defaultValue="旧密码", required = true)
    private String oldPassword;
    @NotEmpty
    @Schema(defaultValue="新密码", required = true)
    private String newPassword;
}
