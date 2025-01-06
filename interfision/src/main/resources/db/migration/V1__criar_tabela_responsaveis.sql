CREATE TABLE responsavel (
  id BIGINT NOT NULL AUTO_INCREMENT,
  data_nascimento VARCHAR(255) NOT NULL,
  email VARCHAR(50) NOT NULL,
  endereco VARCHAR(100) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (email),
  UNIQUE (nome)
);
