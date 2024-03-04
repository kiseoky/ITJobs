package com.kiseoky.itjobs.question.dto;

import com.kiseoky.itjobs.posting.Posting;
import lombok.Data;

@Data
public class QuestionDTO {
    private String content;
    private Long maxLength;
    private Posting posting;

    public QuestionDTO(String content, Long maxLength, Posting posting) {
        this.content = content;
        this.maxLength = maxLength;
        this.posting = posting;
    }

    public static QuestionDTO create(QuestionCreateDTO dto, Posting posting) {
        return new QuestionDTO(dto.getContent(), dto.getMaxLength(), posting);
    }


}
