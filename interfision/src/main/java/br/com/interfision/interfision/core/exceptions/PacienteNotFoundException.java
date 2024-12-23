package br.com.interfision.interfision.core.exceptions;

public class PacienteNotFoundException extends ModelNotFoundException {

    public PacienteNotFoundException() {
        super("Paciente not found");
    }
    
    public PacienteNotFoundException(String message) {
        super(message);
    }
    
}
