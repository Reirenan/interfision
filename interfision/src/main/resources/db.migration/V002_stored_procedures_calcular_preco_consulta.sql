CREATE DEFINER=`root`@`localhost` PROCEDURE `CalcularPrecoConsulta`(
    IN especialidadeID INT, 
    IN profissionalID INT, 
    OUT precoConsulta DOUBLE
)
BEGIN
    DECLARE precoBase DOUBLE DEFAULT 0;
    DECLARE salarioProfissional DOUBLE DEFAULT 0;

    IF especialidadeID IS NOT NULL THEN
        SELECT preco_especialidade 
        INTO precoBase
        FROM inter.especialidade
        WHERE id = especialidadeID;
    END IF;

    IF profissionalID IS NOT NULL THEN
        SELECT salario 
        INTO salarioProfissional
        FROM inter.profissional
        WHERE id = profissionalID;
    END IF;

    SET precoConsulta = precoBase + (salarioProfissional * 0.1);
END