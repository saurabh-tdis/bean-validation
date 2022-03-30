package com.app.validator;

import com.app.validator.custom.PreferenceType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/***
 *  validator for PreferenceType annotation
 *  here we are checking the logic for preference type
 *  we can provide our custom logic here
 *  this validator will get executed when we use @PreferenceType annotation on any field with @Valid
 */
public class PreferenceTypeValidator implements ConstraintValidator<PreferenceType, String>  {

    List<String> preferences = List.of("email", "sms");

    // custom logic for validating preference type
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return  value!=null && preferences.contains(value);
    }
}
