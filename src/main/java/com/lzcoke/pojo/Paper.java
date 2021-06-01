package com.lzcoke.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("试卷信息")
public class Paper {
    @ApiModelProperty(value = "试卷编号", required = false, example = "0")
    private int paper_id;
    @ApiModelProperty(value = "试卷名称", required = false, example = "数学")
    private String paper_name;
    @ApiModelProperty(value = "试卷链接", required = false, example = "rul")
    private String paper_url;
    @ApiModelProperty(value = "创建时间", required = false, example = "2020-10-22 20:20:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date paper_create_date;
    @ApiModelProperty(value = "更新时间", required = false, example = "2020-10-22 20:20:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date paper_update_date;
}
