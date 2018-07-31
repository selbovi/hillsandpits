package com.selbovi.exception;

/**
 * If we have small amount of hills or even none, then we can not form a pit.
 */
public class NotEnoughHillsForPitFormationException extends Exception {

    public static final String MESSAGE = "If we have small amount of hills or even none, then we can not form a pit.";

    public NotEnoughHillsForPitFormationException() {
        super(MESSAGE);
    }
}
