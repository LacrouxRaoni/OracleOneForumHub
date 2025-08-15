# 📚 ForumHub API
```API RESTful``` para um fórum de discussão com autenticação JWT, gerenciamento de tópicos e migrações de banco de dados automatizadas.

## 🚀 Tecnologias Principais
### Backend
-   Spring Boot 3.5.4

-   Spring Security (Autenticação JWT)

-   Spring Data JPA (Persistência)

-   Flyway (Migrações de banco de dados)

-   MySQL (Banco de dados principal)

-   OpenAPI 3.0 (Documentação via Swagger UI)

### Autenticação
-   JWT (JSON Web Tokens)

    -   java-jwt:4.5.0 (Auth0)
    -   jjwt-api:0.11.5

## 📋 Endpoints Principais

### 🔐 Autenticação

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/login` | Autentica usuário e retorna JWT |

### 📝 Tópicos (Requer autenticação)
| Método | Endpoint | Descrição | Autenticação |
|--------|----------|-----------|--------------|
| `GET`  | `/topicos` | Lista todos os tópicos | ❌ Público |
| `GET`  | `/topicos/{id}` | Busca tópico por ID | ❌ Público |
| `POST` | `/topicos` | Cria novo tópico | ✅ Requerida |
| `PUT`  | `/topicos/{id}` | Atualiza tópico existente | ✅ Requerida |
| `DELETE` | `/topicos/{id}` | Remove tópico | ✅ Requerida |

## ⚙️ Configuração

### Banco de Dados (MySQL)

```
spring.application.name=forumhub
spring.datasource.url=jdbc:mysql://localhost:3306/forumhub?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8
spring.datasource.username=admin
spring.datasource.password=admin
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
### JPA/Hibernate
```
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

### Flyway (Migrações de Banco)
```
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
spring.flyway.baseline-on-migrate=true
spring.flyway.baseline-version=1
spring.flyway.sql-migration-prefix=V
spring.flyway.sql-migration-separator=__
spring.flyway.sql-migration-suffixes=.sql
```

### Usuário Admin Padrão
Ao iniciar a aplicação:

-   Email: ```admin@forumhub.com```
-   Senha: ```123``` (altere para produção!)

## 🛠️ Dependências Principais

```
- Spring Boot 3.5.4:
    - spring-boot-starter-data-jpa
    - spring-boot-starter-security
    - spring-boot-starter-web
    - spring-boot-starter-validation

- Banco de Dados:
    - mysql-connector-j
    - flyway-core
    - flyway-mysql

- Segurança:
    - java-jwt:4.5.0
    - jjwt-api:0.11.5

- Utilidades:
    - lombok
    - springdoc-openapi-starter-webmvc-ui:2.7.0  
```
## 🏁 Como Executar
1. Pré-requisitos:
   -   Java 17
   -   MySQL 8+

2.  Configuração inicial:

```
# Criar banco de dados
CREATE DATABASE forumhub_db;
```
3. Iniciar aplicação:
```
./mvnw spring-boot:run
```
4.  Acessar:
   -   API: http://localhost:8080
   -   Swagger UI: http://localhost:8080/swagger-ui.html
   - Flyway (migrações): Executadas automaticamente no startup

## 📌 Exemplo de Uso

### Autenticação:
```
curl -X POST http://localhost:8080/login \
-H "Content-Type: application/json" \
-d '{"nome":"admin","email":"admin@forumhub.com","password":"123"}'
```

### Criar Tópico:
```
curl -X POST http://localhost:8080/topicos \
-H "Authorization: Bearer <JWT>" \
-H "Content-Type: application/json" \
-d '{"titulo":"Dúvida","mensagem":"Como usar JWT?","curso":"Spring Boot"}'
```

## 📌 Dicas de Configuração
1.  Para produção:
    -   Altere as credenciais do banco de dados
    -   Configure useSSL=true com certificado válido
    - Utilize variáveis de ambiente para dados sensíveis


2.  As migrações Flyway serão executadas automaticamente:

    -   Arquivos devem estar em src/main/resources/db/migration
    -   Padrão de nomenclatura: V1__Descricao.sql