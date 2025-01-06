package br.com.interfision.interfision.core.exceptions;

public class EspecialidadeNotFoundException extends ModelNotFoundException {

    public EspecialidadeNotFoundException() {
        super("Especialidade not found");
    }
    
    public EspecialidadeNotFoundException(String message) {
        super(message);
    }
    
}
