package com.example.cadastro.controllerAdvice;

import com.example.cadastro.exception.MessageException;
import com.example.cadastro.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CadastroControllerAdvice {

    @ExceptionHandler(value = ObjectNotFoundException.class)
    public ResponseEntity<Object> exceptionNotFound(ObjectNotFoundException ex ){
        MessageException messageException = new MessageException(ex.getMessage(), HttpStatus.NOT_FOUND.value(),
                                                                    HttpStatus.NOT_FOUND.getReasonPhrase() );
        return new ResponseEntity<>(messageException, HttpStatus.NOT_FOUND );
    }


}
