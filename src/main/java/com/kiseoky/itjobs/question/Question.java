package com.kiseoky.itjobs.question;

import com.kiseoky.itjobs.posting.Posting;
import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Posting posting;
}
