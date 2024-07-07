package org.apirest.springsecurity.controller.dto;

public record LoginResponse(
        String accessToken,
        Long expiresIn
) {}
