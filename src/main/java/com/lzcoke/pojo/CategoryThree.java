package com.lzcoke.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("三级分类信息")
public class CategoryThree {
    @ApiModelProperty(value = "三级分类编号", required = false, example = "0")
    private int three_id;
    @ApiModelProperty(value = "三级分类名称", required = false, example = "哈哈")
    private String three_name;
    @ApiModelProperty(value = "创建时间", required = false, example = "2020-10-22 20:20:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date three_create_date;
    @ApiModelProperty(value = "更新时间", required = false, example = "2020-10-22 20:20:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date three_update_date;
}
