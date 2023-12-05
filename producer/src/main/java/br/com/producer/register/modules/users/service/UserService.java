package br.com.producer.register.modules.users.service;

import br.com.producer.register.modules.users.requests.UserCreatePostRequestBody;
import br.com.producer.register.modules.users.entity.User;

public sealed interface UserService permits UserServiceImpl{
    User createUser(UserCreatePostRequestBody userCreatePostRequestBody);
}
