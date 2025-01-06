CREATE TABLE consulta (
  id BIGINT NOT NULL AUTO_INCREMENT,
  data DATE NOT NULL,
  horario TIME NOT NULL,
  observacoes VARCHAR(500),
  preco_consulta DECIMAL(38,2),
  status VARCHAR(50) NOT NULL,
  especialidade_id BIGINT,
  paciente_id BIGINT,
  profissional_id BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (paciente_id) REFERENCES paciente (id),
  FOREIGN KEY (profissional_id) REFERENCES profissional (id),
  FOREIGN KEY (especialidade_id) REFERENCES especialidade (id)
);
