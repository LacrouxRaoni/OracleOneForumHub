-- V2__add_course_data.sql
-- Desabilita verificações de FK temporariamente
SET FOREIGN_KEY_CHECKS = 0;

-- Limpa a tabela se existir (usando DELETE em vez de TRUNCATE para evitar problemas com FK)
DELETE FROM course;

-- Insere os novos dados
INSERT INTO course (name, category) VALUES
-- Mobile
('Flutter', 'Mobile'),
('Android', 'Mobile'),
('iOS', 'Mobile'),
('Kotlin', 'Mobile'),

-- Programação
('Lógica de programação', 'Programação'),
('.NET', 'Programação'),
('Automação e Produtividade', 'Programação'),
('Testes e Quality Assurance', 'Programação'),
('Elixir', 'Programação'),
('Node.JS', 'Programação'),
('Python web', 'Programação'),
('Java', 'Programação'),
('C#', 'Programação'),
('PHP', 'Programação'),
('Desenvolvimento de jogos', 'Programação'),
('Clojure', 'Programação'),
('GoLang', 'Programação'),
('C e C++', 'Programação'),
('Computação', 'Programação'),

-- Front-end
('HTML e CSS', 'Front-end'),
('Svelte', 'Front-end'),
('VueJS', 'Front-end'),
('React', 'Front-end'),
('Next.JS', 'Front-end'),
('Angular', 'Front-end'),
('JavaScript', 'Front-end'),
('Automação e Performance', 'Front-end'),
('WordPress', 'Front-end'),

-- DevOps
('Linux', 'DevOps'),
('FinOps', 'DevOps'),
('Automação de processos', 'DevOps'),
('Confiabilidade', 'DevOps'),
('Começando em DevOps', 'DevOps'),
('Arquitetura', 'DevOps'),
('Google Cloud Platform', 'DevOps'),
('OCI', 'DevOps'),
('Azure', 'DevOps'),
('Segurança', 'DevOps'),
('Containers', 'DevOps'),
('Infraestrutura como Código', 'DevOps'),
('Builds e Controle de versão', 'DevOps'),
('AWS', 'DevOps'),
('Entrega Contínua', 'DevOps'),
('Mensageria/Streams', 'DevOps'),
('Redes', 'DevOps'),
('Windows', 'DevOps'),

-- UX & Design
('UI Design', 'UX & Design'),
('Design System', 'UX & Design'),
('UX Writing', 'UX & Design'),
('UX Research', 'UX & Design'),
('Manipulação Fotografica', 'UX & Design'),
('Modelagem 3D', 'UX & Design'),
('Escultura Digital', 'UX & Design'),
('Engine', 'UX & Design'),
('Tratamento de Imagem', 'UX & Design'),
('Arte Vetorial', 'UX & Design'),
('UX Design', 'UX & Design'),
('Stream', 'UX & Design'),
('Design Editorial', 'UX & Design'),
('Composição e VFX', 'UX & Design'),
('Colorização', 'UX & Design'),
('Design Gráfico', 'UX & Design'),
('Animação', 'UX & Design'),
('Edição de Vídeo', 'UX & Design'),
('3D', 'UX & Design'),
('Motion Design', 'UX & Design'),
('Design de Jogos', 'UX & Design'),
('Ilustração Digital', 'UX & Design'),
('Pintura Digital', 'UX & Design'),
('Fotografia', 'UX & Design'),
('Áudio (Produção e Pós-Produção)', 'UX & Design'),

-- Data Science
('SQL e Banco de Dados', 'Data Science'),
('Engenharia de Dados', 'Data Science'),
('Data Science', 'Data Science'),
('Data Visualization', 'Data Science'),
('Machine Learning', 'Data Science'),
('Excel', 'Data Science'),
('Business Intelligence', 'Data Science'),
('NoSQL', 'Data Science'),
('Estatística', 'Data Science'),
('Matemática', 'Data Science'),

-- Inovação & Gestão
('Agilidade', 'Inovação & Gestão'),
('Liderança', 'Inovação & Gestão'),
('Ensino e Aprendizagem', 'Inovação & Gestão'),
('Marketing Digital', 'Inovação & Gestão'),
('SEO', 'Inovação & Gestão'),
('Tráfego Pago', 'Inovação & Gestão'),
('Marketing Analytics', 'Inovação & Gestão'),
('Social Media', 'Inovação & Gestão'),
('Transformação Ágil', 'Inovação & Gestão'),
('Administração e Gestão', 'Inovação & Gestão'),
('E-commerce', 'Inovação & Gestão'),
('Gestão de Pessoas', 'Inovação & Gestão'),
('Softskills e Carreira', 'Inovação & Gestão'),
('Ferramentas de Apoio à Gestão', 'Inovação & Gestão'),
('Certificação PMP e CAPM', 'Inovação & Gestão'),
('Gerenciamento de serviços', 'Inovação & Gestão'),
('Gestão de Produtos', 'Inovação & Gestão'),
('Empreendedorismo e Startups', 'Inovação & Gestão'),
('Vendas', 'Inovação & Gestão'),
('Práticas de Gestão - Waterfall & Híbridas', 'Inovação & Gestão'),
('Conformidade Legal', 'Inovação & Gestão'),

-- Inteligência Artificial
('IA para Criativos', 'Inteligência Artificial'),
('IA para Programação', 'Inteligência Artificial'),
('IA para Negócios', 'Inteligência Artificial'),
('IA para Mobile', 'Inteligência Artificial'),
('IA para Marketing Digital', 'Inteligência Artificial'),
('IA para Front End', 'Inteligência Artificial'),
('IA para Dados', 'Inteligência Artificial'),
('IA para UX & Design', 'Inteligência Artificial');

-- Reabilita verificações de FK
SET FOREIGN_KEY_CHECKS = 1;
