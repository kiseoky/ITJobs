package com.kiseoky.itjobs.posting.dto;

import lombok.Data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class PostingCreateDTO {
    private String title;
    private String content;
    private Date startDate;
    private Date endDate;

    public PostingCreateDTO(String title, String content, String startDate, String endDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.title = title;
        this.content = content;
        this.startDate = dateFormat.parse(startDate);
        this.endDate = dateFormat.parse(endDate);
    }
}
