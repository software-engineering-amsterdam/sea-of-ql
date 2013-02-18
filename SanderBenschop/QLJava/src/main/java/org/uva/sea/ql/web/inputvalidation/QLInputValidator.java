package org.uva.sea.ql.web.inputvalidation;

import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.web.IdentifierValuePair;

public interface QLInputValidator {

    QLInputValidationResult validateInputForType(IdentifierValuePair identifierValuePair, Type expectedType);

    QLInputValidationResult validateInput(IdentifierValuePair[] identifierValuePairs);

    QLInputValidationResult validateInput(IdentifierValuePair identifierValuePair);
}
