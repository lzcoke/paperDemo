package com.lzcoke.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("二级分类信息")
@Data
public class CategorySecond {
    @ApiModelProperty(value = "二级分类信息编号", required = false, example = "0")
    private int second_id;

    @ApiModelProperty(value = "二级分类名", required = false, example = "2")
    private String second_name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", required = false, example = "2020-10-22 20:20:00")
    private Date second_create_date;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发布时间", required = false, example = "2020-10-22 20:20:00")
    private Date second_update_date;


}
