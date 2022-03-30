package com.app.validator.custom;

import com.app.validator.DbDuplicateValidator;
import com.app.validator.PreferenceTypeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;

/**
 * @Author saura
 * @Date 27-03-2022
 */
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {DbDuplicateValidator.class})
public @interface DbDuplicate {

    String message() default "duplicate id found";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
