# Projeto Backend de Gerenciamento de Usuários e Autenticação

Este é um projeto backend Java Spring Boot que oferece funcionalidades de gerenciamento de usuários e autenticação. Inclui endpoints RESTful para a criação de usuários e autenticação utilizando Kafka para mensagens e PostgreSQL como banco de dados.

## Conteúdo do Projeto

- **UserController.java:** Controlador responsável pelos endpoints relacionados ao gerenciamento de usuários.
- **AuthenticationController.java:** Controlador responsável pelos endpoints de autenticação.
- **application.properties:** Arquivo de configuração para propriedades da aplicação, incluindo configurações do Kafka e PostgreSQL.

## Como Utilizar

1. Clone este repositório em sua máquina local:

    ```bash
    git clone https://github.com/seu-usuario/nome-do-repositorio.git
    ```

2. Configure o arquivo `application.properties` para definir as propriedades do Kafka e PostgreSQL.

3. Execute o projeto Spring Boot:

    ```bash
    ./mvnw spring-boot:run
    ```

4. Os endpoints estarão disponíveis em `http://localhost:8080`.

## Endpoints

### Gerenciamento de Usuários

#### Criar Usuário

- **Endpoint**: `POST /users/create`
- **Descrição**: Cria um novo usuário.
- **Corpo da Requisição**: UserCreatePostRequestBody
- **Resposta**: User
- **Códigos de Status HTTP**:
    - 201 Created: Usuário criado com sucesso
    - 400 Bad Request: Corpo da requisição inválido
    - 500 Internal Server Error: Erro do servidor

### Autenticação

#### Entrar

- **Endpoint**: `POST /auth/signin`
- **Descrição**: Autentica um usuário e gera um token JWT.
- **Corpo da Requisição**: SigninRequest
- **Resposta**: JwtAuthenticationResponse
- **Códigos de Status HTTP**:
    - 200 OK: Entrada bem-sucedida
    - 401 Unauthorized: Credenciais inválidas
    - 500 Internal Server Error: Erro do servidor

## Integração com o Kafka

O projeto se integra ao Apache Kafka para mensagens. Certifique-se de que o Kafka esteja em execução e configurado corretamente.

## Banco de Dados

A aplicação utiliza o PostgreSQL como banco de dados. Certifique-se de configurar as propriedades de conexão do banco de dados no arquivo `application.properties`.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests para melhorias ou correções.

## Licença

Este projeto é licenciado sob a [MIT License](LICENSE).
