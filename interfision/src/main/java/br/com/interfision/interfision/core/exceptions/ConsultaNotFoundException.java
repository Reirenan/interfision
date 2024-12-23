package br.com.interfision.interfision.core.exceptions;

public class ConsultaNotFoundException extends ModelNotFoundException {

    public ConsultaNotFoundException() {
        super("Consulta not found");
    }
    
    public ConsultaNotFoundException(String message) {
        super(message);
    }
    
}
