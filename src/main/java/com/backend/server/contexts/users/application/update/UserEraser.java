package com.backend.server.contexts.users.application.update;

import com.backend.server.contexts.users.infrastructure.services.MysqlUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEraser {
    @Autowired
    private MysqlUserService service;

    public void run(Long id) {
        service.delete(id);
    }
}
