package com.backend.server.contexts.users.application.find;

import com.backend.server.contexts.users.domain.dto.User;
import com.backend.server.contexts.users.infrastructure.services.MysqlUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersFinder {
    @Autowired
    private MysqlUserService service;

    public List<User> run() {
        return service.find();
    }
}
