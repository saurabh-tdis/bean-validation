package com.app.dto;

import com.app.validator.custom.DbDuplicate;
import com.app.validator.custom.PreferenceType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Data
public class User {

    @Id
    @DbDuplicate
    @NotNull
    @Positive(message = "id must be positive")
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "name must not be empty")
    @Size(min = 2, max = 20, message = "name must be between {min} and {max} characters")
    private String name;

    @NotBlank(message = "description must not be blank")
    @Size(max = 100, message = "description must be less than 100 characters")
    private String description;

    @PreferenceType // custom annotation to check custom logic
    private String type;

    @NotNull
    @Min(value = 0, message = "Age must be greater than 0")
    @Max(value = 100, message = "Age must be less than 120")
    private Integer age;

    @NotNull(message = "status must not be null")
    private Boolean status;

    @NotNull
    @PastOrPresent(message = "date must be in past or present")
    private LocalDate beforeDate;

    @NotNull
    @FutureOrPresent(message = "date must be in future or present")
    private LocalDate afterDate;

    @NotNull
    @Email(message = "email must be valid")
    private String email;

    @Valid // will validate address object
    @NotNull(message = "address must not be null")
    @ManyToOne
    private Address address;



}
