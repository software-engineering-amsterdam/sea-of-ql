package org.uva.sea.ql.web.inputvalidation;

import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.visitor.semanticanalysis.SymbolTable;
import org.uva.sea.ql.web.IdentifierValuePair;

import javax.inject.Inject;

public class QuestionValidator implements QLInputValidator{

    private static final String OK_MESSAGE = "Input ok.";
    private static final String ERROR_MESSAGE_TEMPLATE = "No valid %s input.";

    @Inject
    private SymbolTable symbolTable;

    @Override
    public QLInputValidationResult validateIdentifierIsOfType(IdentifierValuePair identifierValuePair, Type expectedType) {
        String identifierName = identifierValuePair.getIdentifierName(), value = identifierValuePair.getValue();
        if (identifierName != null && identifierIsOfType(identifierName, expectedType) && expectedType.canBeAssignedFromValue(value)) {
            return new QLInputValidationResultImpl(true, OK_MESSAGE);
        } else {
            return new QLInputValidationResultImpl(false, String.format(ERROR_MESSAGE_TEMPLATE, expectedType.getObjectLiteralSimpleClassName()));
        }
    }

    private boolean identifierIsOfType(String identName, Type type) {
        Ident ident = new Ident(identName);
        Type reduceableType = symbolTable.getReduceableType(ident);
        if (reduceableType == null) {
            return false;
        }
        return reduceableType.isCompatibleTo(type);
    }
}
