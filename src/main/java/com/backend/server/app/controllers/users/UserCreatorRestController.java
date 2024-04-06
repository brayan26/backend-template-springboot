package com.backend.server.app.controllers.users;

import com.backend.server.contexts.users.application.create.UserCreator;
import com.backend.server.contexts.users.domain.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCreatorRestController {
    @Autowired
    private UserCreator userCreatorUseCase;

    @PostMapping(path = "/users/add", produces = {"application/json"})
    public ResponseEntity<?> run(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreatorUseCase.run(user));
    }
}
