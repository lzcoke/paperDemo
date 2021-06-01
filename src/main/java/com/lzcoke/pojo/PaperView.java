package com.lzcoke.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PaperView {

    private int view_id;

    private int paper_id;

    private int user_id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date view_create_date;
}
