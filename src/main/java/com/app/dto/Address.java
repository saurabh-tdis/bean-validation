package com.app.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Author saurabh vaish
 * @Date 27-03-2022
 */

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Address Line 1 is mandatory")
    private String addressLine1;

    private String addressLine2;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "State is mandatory")
    private String state;

    @NotBlank(message = "Country is mandatory")
    private String country;

    @Size(min = 6, max = 6, message = "Zip code must be 6 digits")
    @NotNull(message = "Zip code is mandatory")
    private String zipCode;
}
