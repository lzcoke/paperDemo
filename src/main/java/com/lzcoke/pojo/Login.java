package com.lzcoke.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("登录实体类")
public class Login {
    @ApiModelProperty(value = "邮箱", required = false, example = "lzcoke@163.com")
    private String email;

    @ApiModelProperty(value = "密码", required = false, example = "123456")
    private String password;


}
