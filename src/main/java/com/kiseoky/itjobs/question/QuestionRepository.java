package com.kiseoky.itjobs.question;

import com.kiseoky.itjobs.question.dto.QuestionDTO;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionRepository {
    private final EntityManager em;

    public Question save(QuestionDTO dto) {
        Question question = Question.create(dto);
        em.persist(question);
        return question;
    }


    public Question findById(Long id) {
        return em.find(Question.class, id);
    }

    public void delete(Question question) {
        em.remove(question);
    }

    public Question update(Question question) {
        return em.merge(question);
    }

    public void saveAll(List<QuestionDTO> questions) {
        for (QuestionDTO question : questions) {
            save(question);
        }
    }

    public List<Question> findAll() {
        return em.createQuery("select q from Question q", Question.class)
                .getResultList();
    }
}
