package com.example.cadastro.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class MessageException {
    private String message;
    private int  httpCode ;
    private String httpMessage;
}
