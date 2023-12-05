package br.com.producer.modules.users.service;

import br.com.producer.modules.users.requests.UserCreatePostRequestBody;
import br.com.producer.modules.users.entity.User;
import br.com.producer.modules.users.mapper.UserMapper;
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
            throw new RuntimeException("Error to send message to kafka");
        }
        return user;
    }
}
