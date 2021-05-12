package br.com.zupacademy.robson.ecommerce.validation;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    @PersistenceContext
    private EntityManager manager;
    private String domainAttribute;
    private Class<?> klass;

    @Override
    public void initialize(UniqueValue params) {
        domainAttribute = params.fieldName();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("SELECT 1 FROM " + klass.getName()
                + " WHERE " + domainAttribute + "=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        return list.isEmpty();
    }
}
