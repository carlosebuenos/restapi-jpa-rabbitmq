package br.com.carlos.restapijparabbitmq.exception;

public class DuplicatedException extends Exception {

    public DuplicatedException(String message) {
        super(message);
    }
}
