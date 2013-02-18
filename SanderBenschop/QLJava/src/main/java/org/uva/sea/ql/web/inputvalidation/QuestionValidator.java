package org.uva.sea.ql.web.inputvalidation;

import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.visitor.semanticanalysis.SymbolTable;
import org.uva.sea.ql.web.IdentifierValuePair;

import javax.inject.Inject;

public class QuestionValidator implements QLInputValidator {

    @Inject
    private SymbolTable symbolTable;

    @Override
    public QLInputValidationResult validateInputForType(IdentifierValuePair identifierValuePair, Type expectedType) {
        String identifierName = identifierValuePair.getIdentifierName(), value = identifierValuePair.getValue();
        if (identifierName != null && identifierIsOfType(identifierName, expectedType) && expectedType.canBeAssignedFrom(value)) {
            return new QLInputValidationResultImpl(true, OK_MESSAGE);
        } else {
            return new QLInputValidationResultImpl(false, String.format(TYPED_ERROR_MESSAGE_TEMPLATE, expectedType.getObjectLiteralSimpleClassName()));
        }
    }

    @Override
    public QLInputValidationResult validateInput(IdentifierValuePair identifierValuePair) {
        String identifierName = identifierValuePair.getIdentifierName(), value = identifierValuePair.getValue();
        Type type = getTypeForIdentifierName(identifierName);
        if (type != null && type.canBeAssignedFrom(value)) {
            return new QLInputValidationResultImpl(true, OK_MESSAGE);
        } else {
            return new QLInputValidationResultImpl(false, String.format(NAMED_ERROR_MESSAGE_TEMPLATE, identifierName));
        }
    }

    private Type getTypeForIdentifierName(String identifierName) {
        Ident ident = new Ident(identifierName);
        if (symbolTable.containsReductionFor(ident)) {
            return symbolTable.getReduceableType(ident);
        }
        return null;
    }

    private boolean identifierIsOfType(String identifierName, Type type) {
        Ident ident = new Ident(identifierName);
        if (symbolTable.containsReductionFor(ident)) {
            return symbolTable.getReduceableType(ident).isCompatibleTo(type);
        }
        return false;
    }
}
