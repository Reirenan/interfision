package br.com.interfision.interfision.core.exceptions;

public class ResponsavelNotFoundException extends ModelNotFoundException {

    public ResponsavelNotFoundException() {
        super("Skill not found");
    }
    
    public ResponsavelNotFoundException(String message) {
        super(message);
    }
    
}
