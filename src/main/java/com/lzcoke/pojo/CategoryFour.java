package com.lzcoke.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("四级分类信息")
public class CategoryFour {
    @ApiModelProperty(value = "四级分类编号", required = false, example = "0")
    private int four_id;
    @ApiModelProperty(value = "四级分类名称", required = false, example = "4")
    private String four_name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", required = false, example = "2020-10-22 20:20:00")
    private Date four_create_date;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", required = false, example = "2020-10-22 20:20:00")
    private Date four_update_date;
}
