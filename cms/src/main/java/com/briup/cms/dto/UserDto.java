package com.briup.cms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/8/2022-11-08-11:36 AM
 * @Description：com.briup.cms.dto
 */
@Data
public class UserDto {
    @ApiModelProperty(value = "用户名", name = "username", example = "admin", required = true)
    private String username;
    @ApiModelProperty(value = "密码", name = "password", example = "123456", required = true)
    private String password;

}
