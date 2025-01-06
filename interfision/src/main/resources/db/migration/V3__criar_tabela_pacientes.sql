CREATE TABLE paciente (
  id BIGINT NOT NULL AUTO_INCREMENT,
  data_nascimento VARCHAR(255) NOT NULL,
  endereco VARCHAR(100) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  responsavel_id BIGINT NULL,
  PRIMARY KEY (id),
  UNIQUE (nome),
  FOREIGN KEY (responsavel_id) REFERENCES responsavel (id)
);
