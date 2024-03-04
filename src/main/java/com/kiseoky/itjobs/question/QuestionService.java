package com.kiseoky.itjobs.question;

import com.kiseoky.itjobs.posting.Posting;
import com.kiseoky.itjobs.question.dto.QuestionCreateDTO;
import com.kiseoky.itjobs.question.dto.QuestionDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class QuestionService {
    private final QuestionRepository questionRepository;

    public void saveQuestions(List<QuestionCreateDTO> questions, Posting posting) {
        questionRepository.saveAll(questions.stream().map(dto -> QuestionDTO.create(dto, posting)).toList());
    }

    @Transactional(readOnly = true)
    public Question findById(Long id) {
        return questionRepository.findById(id);
    }

    public void delete(Question question) {
        questionRepository.delete(question);
    }

    public Question update(Question question) {
        return questionRepository.update(question);
    }

    @Transactional(readOnly = true)
    public List<Question> findAll() {
        return questionRepository.findAll();
    }
}
