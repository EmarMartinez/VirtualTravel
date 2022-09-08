package com.virtualtravelappback.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdNoEncontrada extends RuntimeException {
    public IdNoEncontrada(String message){
        super(message);
    }
}
