package com.backend.server.contexts.users.application.find;

import com.backend.server.contexts.users.infrastructure.services.MysqlUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {
    @Autowired
    private MysqlUserService service;

    public void run(String username, String password) {
        service.validateUser(username, password);
    }
}
