package com.lzcoke.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class Collect {
    private int collect_id;

    private int user_id;

    private int paper_id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date collect_create_date;
}
