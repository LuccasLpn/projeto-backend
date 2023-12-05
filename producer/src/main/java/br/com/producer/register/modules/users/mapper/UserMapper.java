package br.com.producer.register.modules.users.mapper;

import br.com.producer.register.modules.users.entity.User;
import br.com.producer.register.modules.users.requests.UserCreatePostRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "active", expression = "java(true)")
    public abstract User mapperUserPostRequestBodyToUser(UserCreatePostRequestBody userCreatePostRequestBody);
}
