package br.com.producer.modules.users.service;

import br.com.producer.modules.users.requests.UserCreatePostRequestBody;
import br.com.producer.modules.users.entity.User;

public sealed interface UserService permits UserServiceImpl{
    User createUser(UserCreatePostRequestBody userCreatePostRequestBody);
}
