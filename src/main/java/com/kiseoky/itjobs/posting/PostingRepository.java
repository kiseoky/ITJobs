package com.kiseoky.itjobs.posting;

import com.kiseoky.itjobs.posting.dto.PostingCreateDTO;
import com.kiseoky.itjobs.posting.dto.PostingUpdateDTO;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PostingRepository {
    private final EntityManager em;

    public Posting save(PostingCreateDTO dto) {
        Posting posting = Posting.create(dto);
        em.persist(posting);
        return posting;
    }

    public Optional<Posting> findById(Long id) {
        return Optional.ofNullable(em.find(Posting.class, id));
    }

    public void delete(Posting posting) {
        em.remove(posting);
    }

    public Posting update(Long id, PostingUpdateDTO postingUpdateDTO) {
        Posting posting = em.find(Posting.class, id);
        return posting.update(postingUpdateDTO);
    }

    public List<Posting> findAll() {
        return em.createQuery("select p from Posting p", Posting.class)
                .getResultList();
    }
}
