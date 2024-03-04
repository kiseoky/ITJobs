package com.kiseoky.itjobs.question;

import com.kiseoky.itjobs.posting.Posting;
import com.kiseoky.itjobs.posting.PostingRepository;
import com.kiseoky.itjobs.posting.dto.PostingCreateDTO;
import com.kiseoky.itjobs.question.dto.QuestionCreateDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.List;

@SpringBootTest
class QuestionServiceTest {
    @Autowired
    QuestionService questionService;
    @Autowired
    PostingRepository postingRepository;

    @Test
    void 문항_리스트_저장_테스트() throws ParseException {
        // given
        Posting posting = postingRepository.save(new PostingCreateDTO("title", "content", "2021-01-01", "2021-01-02"));
        int size = questionService.findAll().size();

        List<QuestionCreateDTO> questions = List.of(
                new QuestionCreateDTO("content1", 100),
                new QuestionCreateDTO("content2", 200),
                new QuestionCreateDTO("content3", 300)
        );

        // when
        questionService.saveQuestions(questions, posting);

        // then
        List<Question> savedQuestions = questionService.findAll();
        Assertions.assertThat(savedQuestions.size()).isEqualTo(size + 3);
    }
}