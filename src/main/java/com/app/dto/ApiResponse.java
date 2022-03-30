package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> implements Serializable {

    private HttpStatus status;

    private String message;

    private T payload;

    public ApiResponse(T payload) {
        this.status = HttpStatus.OK;
        this.message = "Success";
        this.payload = payload;
    }
}
