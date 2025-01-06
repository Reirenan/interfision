DELIMITER //

CREATE TRIGGER before_insert_consultas
BEFORE INSERT ON consulta
FOR EACH ROW
BEGIN
    DECLARE precoConsulta DOUBLE;

    CALL CalcularPrecoConsulta(
        NEW.especialidade_id,     
        NEW.profissional_id,   
        precoConsulta        
    );

    SET NEW.preco_consulta = precoConsulta;
END;
//

DELIMITER ;
