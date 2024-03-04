package com.kiseoky.itjobs.posting.dto;

import com.kiseoky.itjobs.question.dto.QuestionCreateDTO;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
public class PostingCreateDTO {
    private String title;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private List<QuestionCreateDTO> questions;

    public PostingCreateDTO() {
    }

    public PostingCreateDTO(String title, String content, String startDate, String endDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.title = title;
        this.content = content;
        this.startDate = dateFormat.parse(startDate);
        this.endDate = dateFormat.parse(endDate);
    }
}
