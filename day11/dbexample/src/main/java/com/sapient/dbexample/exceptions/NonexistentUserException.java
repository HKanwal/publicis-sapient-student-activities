package com.sapient.dbexample.exceptions;

public class NonexistentUserException extends Exception {
    public NonexistentUserException() {
        super();
    }

    public  NonexistentUserException(String msg) {
        super(msg);
    }
}
