package com.example.cadastro.exception;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class MessageException {
    private String message;
    private int  httpCode ;
    private String httpMessage;
}
