package com.rpl.SmartLibrary.CustomExceptions;

public class DuplicateIsbnException extends RuntimeException {
    public DuplicateIsbnException(String isbn) {
        super("ISBN already exists: " + isbn);
    }
}
