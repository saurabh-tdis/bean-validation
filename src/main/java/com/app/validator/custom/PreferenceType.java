package com.app.validator.custom;


import com.app.validator.PreferenceTypeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

/***
 * This annotation is used to validate the preference type of field .
 * The logic will be get checked in the PreferenceTypeValidator class.
 *
 *
 */

@NotBlank(message = "Preference Type is required")
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {PreferenceTypeValidator.class})
public @interface PreferenceType {

    String message() default "Preference type must be email or mobilePhone.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}