package com.example.course_master_api.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "No se encontro informacion")
public class NotFoundData  extends RuntimeException{

    public NotFoundData(String message) {
        super(message);
    }

    public NotFoundData(String message, Throwable cause) {
        super(message, cause);
    }
}
