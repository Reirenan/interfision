package br.com.interfision.interfision.api.profissionais.common.handlers;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.interfision.interfision.api.profissionais.common.dtos.ErrorResponse;
import br.com.interfision.interfision.api.profissionais.common.dtos.ValidationErrorResponse;
import br.com.interfision.interfision.core.exceptions.ModelNotFoundException;

@RestControllerAdvice
public class ProfissionalApiExceptionHandler {

    @ExceptionHandler(ModelNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ErrorResponse handleModelNotFoundException(
        ModelNotFoundException exception
    ) {
        return ErrorResponse.builder()
            .message(exception.getLocalizedMessage())
            .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse handleMethodArgumentNotValidException(
        MethodArgumentNotValidException exception
    ) {
        var errors = exception.getBindingResult().getFieldErrors()
            .stream()
            .collect(Collectors.groupingBy(
                fieldError -> fieldError.getField(),
                Collectors.mapping(
                    fieldError -> fieldError.getDefaultMessage(),
                    Collectors.toList()
                )
            ));
        return ValidationErrorResponse.builder()
            .message("Validation error")
            .errors(errors)
            .build();
    }
}
