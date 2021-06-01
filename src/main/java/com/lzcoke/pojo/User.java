package com.lzcoke.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户实体类")
@Data
public class User {
    @ApiModelProperty(value = "用户编号", required = false, example = "0")
    private int user_id;

    @ApiModelProperty(value = "用户昵称", required = false, example = "三通")
    private String nickname;

    @ApiModelProperty(value = "头像", required = false, example = "url")
    private String avatar;

    @ApiModelProperty(value = "邮箱", required = false, example = "lzcoke@163.com")
    private String email;

    @ApiModelProperty(value = "是否被冻结", required = false, example = "0")
    private int block;

    @ApiModelProperty(value = "性别", required = false, example = "0")
    private int sex;

    @ApiModelProperty(value = "省份", required = false, example = "浙江省")
    private String prov;

    @ApiModelProperty(value = "城市", required = false, example = "杭州市")
    private String city;

    @ApiModelProperty(value = "学校", required = false, example = "杭州电子科技大学")
    private String school;

}
