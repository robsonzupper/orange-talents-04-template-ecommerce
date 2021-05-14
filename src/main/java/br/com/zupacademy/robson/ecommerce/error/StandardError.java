package br.com.zupacademy.robson.ecommerce.error;

import java.util.List;
import java.time.Instant;
import java.util.ArrayList;
import java.io.Serializable;
import org.springframework.validation.FieldError;

/**
 *
 * @author Robson
 */
public class StandardError implements Serializable {

    private static final long serialVersionUID = 1l;
    private Instant timestamp;
    private Integer status;
    private String message;
    private String path;
    private List<SubError> subErrors = new ArrayList<>();

    public StandardError(Integer status, String error) {
    }

    public StandardError(Integer status, String message, String path) {
        this.timestamp = Instant.now();
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public void addValidationErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(field -> subErrors.
                add(new SubError(field.getField(), field.getDefaultMessage())));
    }
}
