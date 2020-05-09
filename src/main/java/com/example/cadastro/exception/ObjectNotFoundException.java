package com.example.cadastro.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ObjectNotFoundException extends RuntimeException {
    String message ;
}
