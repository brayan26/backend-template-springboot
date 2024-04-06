package com.backend.server.contexts.users.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private Long id;
    private String name;
    private String username;
    private String password;

    public static User create(Long id, String name, String username, String password) {
        return new User(id, name, username, password);
    }
}
