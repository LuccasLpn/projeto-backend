package br.com.register.modules.users.service;

import br.com.register.modules.users.entity.User;
import br.com.register.modules.users.requests.UserCreatePostRequestBody;

public sealed interface UserService permits UserServiceImpl{
    User createUser(UserCreatePostRequestBody userCreatePostRequestBody);
}
