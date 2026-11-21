package com.rpl.SmartLibrary.CustomExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BukuNotFoundException extends RuntimeException {
    public BukuNotFoundException(Long id) { super("Book " + id + " not found"); }
}
