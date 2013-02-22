package org.uva.sea.ql.web.inputvalidation;

public interface QLInputValidationResult {

    String OK_MESSAGE = "Input ok.";
    String TYPED_ERROR_MESSAGE_TEMPLATE = "No valid %s input. ";
    String NAMED_ERROR_MESSAGE_TEMPLATE = "No valid input for passed identifier name '%s'. ";

    boolean isCorrect();

    String getMessage();
}
