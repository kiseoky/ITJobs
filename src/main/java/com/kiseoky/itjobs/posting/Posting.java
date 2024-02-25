package com.kiseoky.itjobs.posting;

import com.kiseoky.itjobs.posting.dto.PostingCreateDTO;
import com.kiseoky.itjobs.posting.dto.PostingUpdateDTO;
import com.kiseoky.itjobs.user.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private Date startDate;

    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User writer;

    public Posting update(PostingUpdateDTO postingUpdateDTO) {
        this.title = postingUpdateDTO.getTitle();
        this.content = postingUpdateDTO.getContent();
        this.startDate = postingUpdateDTO.getStartDate();
        this.endDate = postingUpdateDTO.getEndDate();
        return this;
    }

    public static Posting create(PostingCreateDTO dto) {
        Posting posting = new Posting();
        posting.title = dto.getTitle();
        posting.content = dto.getContent();
        posting.startDate = dto.getStartDate();
        posting.endDate = dto.getEndDate();
        return posting;
    }
}
