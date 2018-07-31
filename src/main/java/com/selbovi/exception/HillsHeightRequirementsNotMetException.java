package com.selbovi.exception;

/**
 * There is a requirement:
 * Height should be between 0 and 32000.
 */
public class HillsHeightRequirementsNotMetException extends Exception {

    public static final String MESSAGE = "There is a requirement: Height should be between 0 and 32000.";

    public HillsHeightRequirementsNotMetException() {
        super(MESSAGE);
    }
}
