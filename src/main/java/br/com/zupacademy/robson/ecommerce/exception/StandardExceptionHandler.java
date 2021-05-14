package br.com.zupacademy.robson.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import br.com.zupacademy.robson.ecommerce.error.StandardError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Robson
 */
@ControllerAdvice
public class StandardExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        StandardError error = new StandardError(BAD_REQUEST.value(),
                "validation error", request.getDescription(false));

        error.addValidationErrors(ex.getBindingResult().getFieldErrors());
        return new ResponseEntity<>(error, BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatus status,
            WebRequest request) {

        String error = "Malformed JSON request";
        StandardError standardError = new StandardError(BAD_REQUEST.value(), error,
                request.getDescription(false));
        return new ResponseEntity<>(standardError, BAD_REQUEST);
    }
}
