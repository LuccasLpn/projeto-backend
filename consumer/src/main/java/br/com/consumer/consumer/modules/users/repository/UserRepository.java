package br.com.consumer.consumer.modules.users.repository;

import br.com.consumer.consumer.modules.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
