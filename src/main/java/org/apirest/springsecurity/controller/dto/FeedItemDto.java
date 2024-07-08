package org.apirest.springsecurity.controller.dto;

public record FeedItemDto (
        long twwetId,
        String content,
        String username
){}
