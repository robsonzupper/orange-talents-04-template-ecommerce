package br.com.zupacademy.robson.ecommerce.error;

/**
 *
 * @author Robson
 */
public class SubError {

    private String field;
    private String message;

    public SubError(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
