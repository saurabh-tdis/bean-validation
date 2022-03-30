package com.app.controller;


import com.app.dto.ApiResponse;
import com.app.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Optional;


@Validated
@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping(value = "/json", produces = "application/json")
    public String sample() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(new User());
    }

    @PostMapping("/test")
    public ResponseEntity<ApiResponse<User>> test(@Valid @RequestBody User user) {
        return ResponseEntity.ok(new ApiResponse<>(user));
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<ApiResponse<Long>> getSample(@PathVariable @Validated @Min(value = 1,message = "Id must be greater than one")  Long id) {
        return ResponseEntity.ok(new ApiResponse<>(id));
    }

    @GetMapping("/test/all")
    @Valid
    public Optional<User> checkReturnNotNull() {
        return Optional.of(new User());
    }


}
