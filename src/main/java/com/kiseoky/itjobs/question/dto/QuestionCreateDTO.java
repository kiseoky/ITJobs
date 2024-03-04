package com.kiseoky.itjobs.question.dto;

import lombok.Data;

@Data
public class QuestionCreateDTO {
    private String content;
    private Long maxLength;

    public QuestionCreateDTO(String content, long maxLength) {
        this.content = content;
        this.maxLength = maxLength;
    }
}
