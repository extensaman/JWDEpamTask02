package com.epam.jwd.task02.dao;

public class DAOTextException extends Exception {
    public DAOTextException() {
    }

    public DAOTextException(String message) {
        super(message);
    }

    public DAOTextException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOTextException(Throwable cause) {
        super(cause);
    }
}
