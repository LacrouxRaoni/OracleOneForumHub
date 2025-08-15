-- Criação do banco com charset UTF-8 (suporte a emojis e caracteres especiais)
CREATE DATABASE IF NOT EXISTS forumhub
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE forumhub;

-- Tabela Perfil
CREATE TABLE IF NOT EXISTS profile (
                                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                       name VARCHAR(50) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabela Curso
CREATE TABLE IF NOT EXISTS course (
                                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                      name VARCHAR(100) NOT NULL,
                                      category VARCHAR(50) NOT NULL,
                                      INDEX idx_course_category (category)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabela Usuário
CREATE TABLE IF NOT EXISTS user (
                                    id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                    name VARCHAR(100) NOT NULL,
                                    email VARCHAR(100) NOT NULL UNIQUE,
                                    password VARCHAR(255) NOT NULL,
                                    INDEX idx_user_email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabela de junção User-Profile
CREATE TABLE IF NOT EXISTS user_profile (
                                            user_id BIGINT NOT NULL,
                                            profile_id BIGINT NOT NULL,
                                            PRIMARY KEY (user_id, profile_id),
                                            FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,
                                            FOREIGN KEY (profile_id) REFERENCES profile(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabela Tópico
CREATE TABLE IF NOT EXISTS topic (
                                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                     title VARCHAR(150) NOT NULL,
                                     message TEXT NOT NULL,
                                     creation_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                     status ENUM('NOT_ANSWERED', 'NOT_SOLVED', 'SOLVED', 'CLOSED') NOT NULL DEFAULT 'NOT_ANSWERED',
                                     creator_id BIGINT NOT NULL,
                                     course_id BIGINT NOT NULL,
                                     created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                                     updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                     FOREIGN KEY (creator_id) REFERENCES user(id) ON DELETE CASCADE,
                                     FOREIGN KEY (course_id) REFERENCES course(id) ON DELETE CASCADE,
                                     INDEX idx_topic_status (status),
                                     FULLTEXT INDEX idx_topic_search (title, message)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabela Resposta
CREATE TABLE IF NOT EXISTS answer (
                                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                      message TEXT NOT NULL,
                                      creation_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                      solution BOOLEAN NOT NULL DEFAULT FALSE,
                                      topic_id BIGINT NOT NULL,
                                      creator_id BIGINT NOT NULL,
                                      created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                                      updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                      FOREIGN KEY (topic_id) REFERENCES topic(id) ON DELETE CASCADE,
                                      FOREIGN KEY (creator_id) REFERENCES user(id) ON DELETE CASCADE,
                                      INDEX idx_answer_solution (solution)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;