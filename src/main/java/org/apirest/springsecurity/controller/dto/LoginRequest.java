package org.apirest.springsecurity.controller.dto;

public record LoginRequest(
        String username,
        String password
) {}
