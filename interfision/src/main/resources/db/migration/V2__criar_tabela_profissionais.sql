CREATE TABLE profissional (
  id BIGINT NOT NULL AUTO_INCREMENT,
  anos_experiencia INT NOT NULL,
  data_nascimento VARCHAR(255) NOT NULL,
  email VARCHAR(100) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  registro_profissional VARCHAR(12) NOT NULL,
  salario DOUBLE NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (email),
  UNIQUE (registro_profissional)
);
