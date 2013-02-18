package org.uva.sea.ql.web.inputvalidation;

public interface QLInputValidator {

    QLInputValidationResult validate(String identifierName, String value);
}
