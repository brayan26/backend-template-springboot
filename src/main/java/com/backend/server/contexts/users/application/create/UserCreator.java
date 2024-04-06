package com.backend.server.contexts.users.application.create;

import com.backend.server.contexts.users.domain.dto.User;
import com.backend.server.contexts.users.infrastructure.services.MysqlUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCreator {
    @Autowired
    private MysqlUserService service;

    public User run(User user) {
        return service.create(user);
    }
}
