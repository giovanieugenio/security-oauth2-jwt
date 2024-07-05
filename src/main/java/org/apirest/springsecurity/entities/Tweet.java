package org.apirest.springsecurity.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Table(name = "tb_tweeters")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "tweet_id")
    private UUID tweetId;

    private User user;

    private String content;

    @CreationTimestamp
    private Instant creationTimestamp;

}
