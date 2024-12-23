package br.com.interfision.interfision.core.exceptions;

public class ResponsavelNotFoundException extends ModelNotFoundException {

    public ResponsavelNotFoundException() {
        super("Responsavel not found");
    }
    
    public ResponsavelNotFoundException(String message) {
        super(message);
    }
    
}
