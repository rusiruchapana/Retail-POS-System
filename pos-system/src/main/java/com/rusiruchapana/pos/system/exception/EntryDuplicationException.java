package com.rusiruchapana.pos.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class EntryDuplicationException extends RuntimeException {
    public EntryDuplicationException(String message){
        super(message);
    }

}
