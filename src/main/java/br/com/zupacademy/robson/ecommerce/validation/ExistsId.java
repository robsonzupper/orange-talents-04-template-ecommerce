package br.com.zupacademy.robson.ecommerce.validation;

import javax.validation.Payload;
import javax.validation.Constraint;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {ExistsIdValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface ExistsId {

    String message() default "existing id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}
