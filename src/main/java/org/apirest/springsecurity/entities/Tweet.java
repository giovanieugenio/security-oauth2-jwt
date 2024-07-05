package org.apirest.springsecurity.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID tweetId;

    private User user;

    private String content;

    @CreationTimestamp
    private Instant creationTimestamp;

}
