CREATE TABLE especialidade (
  id BIGINT NOT NULL AUTO_INCREMENT,
  descricao TEXT,
  nome VARCHAR(45) NOT NULL,
  preco_especialidade DOUBLE,
  PRIMARY KEY (id),
  UNIQUE (nome)
);
