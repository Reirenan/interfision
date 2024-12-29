package br.com.interfision.interfision.core.exceptions;

public class ProfissionalNotFoundException extends ModelNotFoundException {

    public ProfissionalNotFoundException() {
        super("Profissional not found");
    }

    public ProfissionalNotFoundException(String message) {
        super(message);
    }
}
