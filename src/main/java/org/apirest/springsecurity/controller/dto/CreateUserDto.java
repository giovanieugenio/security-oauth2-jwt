package org.apirest.springsecurity.controller.dto;

public record CreateUserDto (
        String username,
        String password
){}
