package br.com.producer.modules.users.mapper;

import br.com.producer.modules.users.entity.User;
import br.com.producer.modules.users.requests.UserCreatePostRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Mappings({
            @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())"),
            @Mapping(target = "active", expression = "java(true)"),
            @Mapping(target = "password", expression = "java(passwordEncoder.encode(userCreatePostRequestBody.getPassword()))")
    })
    public abstract User mapperUserPostRequestBodyToUser(UserCreatePostRequestBody userCreatePostRequestBody);
}
