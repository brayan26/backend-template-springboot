package com.backend.server.contexts.users.infrastructure.services;

import com.backend.server.contexts.shared.domain.errors.UsersError;
import com.backend.server.contexts.shared.domain.exceptions.GenericBadRequestException;
import com.backend.server.contexts.users.application.create.UserCreator;
import com.backend.server.contexts.users.application.find.UserValidator;
import com.backend.server.contexts.users.domain.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceHandler {
    @Autowired
    private UserCreator userCreatorUseCase;
    @Autowired
    private UserValidator userValidatorUseCase;
    @Autowired
    private PasswordEncoder encoder;

    public User create(User user) {
        //TODO: some logic here
        user.setPassword(encoder.encode(user.getPassword()));
        return this.userCreatorUseCase.run(user);
    }

    public void validateUser(String username, String password) {
        User user = userValidatorUseCase.run(username);
        if (!encoder.matches(password, user.getPassword())) {
            throw new GenericBadRequestException(
                    String.format("<UserServiceHandler - validateUser> password for the username '%s' does not match", username),
                    UsersError.create().invalidUser().build());
        }
    }
}
