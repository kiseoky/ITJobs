package com.kiseoky.itjobs.user;

import com.kiseoky.itjobs.posting.Posting;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToMany(mappedBy = "writer")
    private List<Posting> postings;
}
