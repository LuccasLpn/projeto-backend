package br.com.producer.register.modules.users.service;

import br.com.producer.register.modules.users.requests.UserCreatePostRequestBody;
import br.com.producer.register.modules.users.entity.User;
import br.com.producer.register.modules.users.mapper.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public final class UserServiceImpl implements UserService {

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public User createUser(UserCreatePostRequestBody userCreatePostRequestBody) {
        User user = UserMapper.INSTANCE.mapperUserPostRequestBodyToUser(userCreatePostRequestBody);
        try {
            String message = objectMapper.writeValueAsString(user);
            kafkaTemplate.send("user-topic", message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }
}
