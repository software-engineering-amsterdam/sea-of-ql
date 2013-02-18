package org.uva.sea.ql.web.inputvalidation;

import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.web.IdentifierValuePair;

public interface QLInputValidator {

    String OK_MESSAGE = "Input ok.";
    String TYPED_ERROR_MESSAGE_TEMPLATE = "No valid %s input. ";
    String NAMED_ERROR_MESSAGE_TEMPLATE = "No valid input for passed identifier name '%s'. ";

    QLInputValidationResult validateInputForType(IdentifierValuePair identifierValuePair, Type expectedType);
    QLInputValidationResult validateInput(IdentifierValuePair identifierValuePair);
}
