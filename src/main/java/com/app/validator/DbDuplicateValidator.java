package com.app.validator;

import com.app.repository.UserRepository;
import com.app.validator.custom.DbDuplicate;
import com.app.validator.custom.PreferenceType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/***
 *  validator for DbDuplicate annotation
 *  here we are checking the logic for preference type
 *  we can provide our custom logic here
 *  this validator will get executed when we use @PreferenceType annotation on any field with @Valid
 */
public class DbDuplicateValidator implements ConstraintValidator<DbDuplicate, Long>  {

    // we can use autowired here to inject the dependency , no need to do component on class as spring will take care and inject when this validator is called
    @Autowired
    private UserRepository userRepository;

    // custom logic for validating preference type
    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        if (id == null) return true;
        return !userRepository.existsById(id);
    }

}
