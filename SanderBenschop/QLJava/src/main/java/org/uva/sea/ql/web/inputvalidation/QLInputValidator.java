package org.uva.sea.ql.web.inputvalidation;

import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.web.IdentifierValuePair;

public interface QLInputValidator {

    QLInputValidationResult validateIdentifierIsOfType(IdentifierValuePair identifierValuePair, Type expectedType);
}
