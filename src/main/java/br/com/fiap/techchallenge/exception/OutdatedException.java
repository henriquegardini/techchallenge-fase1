package br.com.fiap.techchallenge.exception;

public class OutdatedException extends RuntimeException{
    public OutdatedException(String message) {
        super(message);
    }
}
