package com.lzcoke.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("五级分类信息")
public class CategoryFive {
    @ApiModelProperty(value = "五级分类编号", required = false, example = "0")
    private int five_id;
    @ApiModelProperty(value = "五级分类名称", required = false, example = "5")
    private String five_name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", required = false, example = "2020-10-22 20:20:00")
    private Date five_create_date;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间",required = false, example = "2020-10-22 20:20:00")
    private Date five_update_date;
}
