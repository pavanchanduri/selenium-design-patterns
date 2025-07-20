package com.selenium.designpatterns.command;

/**
 * Abstract class for validating elements in a web application.
 * This class defines a contract for subclasses to implement specific validation logic.
 */
public abstract class ElementValidator {

    /**
     * Validates the state of an element, typically by checking its visibility or interaction state.
     * 
     * @return true if the validation is successful, false otherwise.
     */
    public abstract boolean validate();
}
