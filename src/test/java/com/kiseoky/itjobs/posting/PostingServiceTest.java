package com.kiseoky.itjobs.posting;

import com.kiseoky.itjobs.posting.dto.PostingCreateDTO;
import com.kiseoky.itjobs.posting.dto.PostingUpdateDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PostingServiceTest {
    @Autowired
    PostingService postingService;

    @Test
    void post() throws ParseException {
        // given
        PostingCreateDTO postingCreateDTO = new PostingCreateDTO(
                "title",
                "content",
                "2021-08-01",
                "2021-08-31"
        );

        // when
        Posting post = postingService.post(postingCreateDTO);
        // then
        Assertions.assertThat(postingService.getPosting(post.getId())).isNotEmpty();
    }

    @Test
    void delete() throws ParseException {
        // given
        PostingCreateDTO postingCreateDTO = new PostingCreateDTO(
                "title",
                "content",
                "2021-08-01",
                "2021-08-31"
        );
        Posting post = postingService.post(postingCreateDTO);

        // when

        postingService.delete(post.getId());

        // then
        Assertions.assertThat(postingService.getPosting(post.getId())).isEmpty();
    }

    @Test
    void getPosting() throws ParseException {
        // given
        PostingCreateDTO postingCreateDTO = new PostingCreateDTO(
                "title",
                "content",
                "2021-08-01",
                "2021-08-31"
        );
        Posting post = postingService.post(postingCreateDTO);

        // when
        Optional<Posting> posting = postingService.getPosting(post.getId());

        // then
        Assertions.assertThat(posting).isNotEmpty();
        Assertions.assertThat(posting.get().getId()).isEqualTo(post.getId());
    }

    @Test
    void getPostings() throws ParseException {
        // given
        PostingCreateDTO postingCreateDTO1 = new PostingCreateDTO(
                "title",
                "content",
                "2021-08-01",
                "2021-08-31"
        );
        PostingCreateDTO postingCreateDTO2 = new PostingCreateDTO(
                "title",
                "content",
                "2021-08-01",
                "2021-08-31"
        );

        postingService.post(postingCreateDTO1);
        postingService.post(postingCreateDTO2);

        // when
        List<Posting> postings = postingService.getPostings();

        // then
        Assertions.assertThat(postings).hasSize(2);
    }

    @Test
    void update() throws ParseException {
        // given
        PostingCreateDTO postingCreateDTO = new PostingCreateDTO(
                "title",
                "content",
                "2021-08-01",
                "2021-08-31"
        );
        Posting post = postingService.post(postingCreateDTO);

        // when
        PostingUpdateDTO postingUpdateDTO = new PostingUpdateDTO(
                "updated title",
                "updated content",
                "2021-08-01",
                "2021-08-31"
        );
        Posting updatedPost = postingService.update(post.getId(), postingUpdateDTO);

        // then
        Assertions.assertThat(updatedPost.getTitle()).isEqualTo("updated title");
        Assertions.assertThat(updatedPost.getContent()).isEqualTo("updated content");
    }
}