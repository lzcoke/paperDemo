package com.lzcoke.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("一级分类信息")
@Data
public class CategoryFirst {
    @ApiModelProperty(value = "分类信息编号", required = false, example = "0")
    private int category_id;

    @ApiModelProperty(value = "分类名称", required = false, example = "1")
    private String category_name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", required = false, example = "2020-10-22 20:20:00")
    private Date category_create_date;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", required = false, example = "2020-10-22 20:20:00")
    private Date category_update_date;
}
