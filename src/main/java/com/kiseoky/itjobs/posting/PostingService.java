package com.kiseoky.itjobs.posting;

import com.kiseoky.itjobs.posting.dto.PostingCreateDTO;
import com.kiseoky.itjobs.posting.dto.PostingUpdateDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PostingService {
    private final PostingRepository postingRepository;

    public Posting post(PostingCreateDTO posting) {
        return postingRepository.save(posting);
    }

    public void delete(Long id) {
        postingRepository.findById(id)
                .ifPresent(postingRepository::delete);
    }

    @Transactional(readOnly = true)
    public Optional<Posting> getPosting(Long id) {
        return postingRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Posting> getPostings() {
        return postingRepository.findAll();
    }

    // TODO: Add Authentication
    public Posting update(Long id, PostingUpdateDTO postingUpdateDTO) {
        return postingRepository.update(id, postingUpdateDTO);
    }


}
