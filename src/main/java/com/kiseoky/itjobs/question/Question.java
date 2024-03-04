package com.kiseoky.itjobs.question;

import com.kiseoky.itjobs.posting.Posting;
import com.kiseoky.itjobs.question.dto.QuestionDTO;
import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Posting posting;

    private Long maxLength;

    public static Question create(QuestionDTO dto) {
        Question question = new Question();
        question.content = dto.getContent();
        question.maxLength = dto.getMaxLength();
        question.posting = dto.getPosting();
        return question;
    }
}
