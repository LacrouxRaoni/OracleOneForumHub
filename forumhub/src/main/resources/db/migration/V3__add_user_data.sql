-- V3__add_user_data.sql
-- Desabilita verificações de FK temporariamente
SET FOREIGN_KEY_CHECKS = 0;

-- Limpa a tabela se existir (usando DELETE em vez de TRUNCATE para evitar problemas com FK)
DELETE FROM user;

-- Insere perfis básicos primeiro
INSERT INTO profile (name) VALUES
                                      ('ADMIN'),
                                      ('USER'),
                                      ('MODERATOR');

-- Insere os novos dados
INSERT INTO user (name, email, password) VALUES
-- User
('admin', 'admin@forumhub.com', '$2a$12$ZVwr55LJo7CW7RiMx1546uu/Echrql1WWvnWW200mSBdihJnBRe6K');

-- Associa usuário ao perfil (ajuste os IDs conforme necessário)
INSERT INTO user_profile (user_id, profile_id) VALUES
(1, 1);

-- Reabilita verificações de FK
SET FOREIGN_KEY_CHECKS = 1;
