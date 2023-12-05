package br.com.register.modules.users.requests;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserCreatePostRequestBody {
    private String username;
    private String email;
    private String password;
    private LocalDateTime birthDate;
}
