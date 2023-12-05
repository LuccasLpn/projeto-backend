package br.com.consumer.consumer.modules.users.service;

import br.com.consumer.consumer.modules.users.entity.User;
import br.com.consumer.consumer.modules.users.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = {"user-topic"}, groupId = "1")
    public void consumerUser(ConsumerRecord<String, String> consumerRecord) {
        try {
            User user = objectMapper.readValue(consumerRecord.value(), User.class);
            userRepository.save(user);
        } catch (Exception exception) {
            throw new RuntimeException("User message error");
        }
    }


}
