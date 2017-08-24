package com.qualitest.demo.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/*
 * Created by UA C on 24.08.2017.
 */
@NoArgsConstructor
@Data
public class ErrorResponse {
    private String message;
    private HttpStatus httpStatus;
    public ErrorResponse(Exception e){
        if(e instanceof NullPointerException){
            httpStatus = HttpStatus.BAD_REQUEST;
        }
    }

}
