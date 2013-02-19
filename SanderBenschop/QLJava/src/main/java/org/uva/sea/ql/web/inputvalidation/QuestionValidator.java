package org.uva.sea.ql.web.inputvalidation;

import org.uva.sea.ql.ast.expression.primary.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.general.SymbolTableImpl;
import org.uva.sea.ql.web.IdentifierValuePair;

import javax.inject.Inject;

public class QuestionValidator implements QLInputValidator {

    @Inject
    private SymbolTableImpl symbolTable;

    @Override
    public QLInputValidationResult validateInputForType(IdentifierValuePair identifierValuePair, Type expectedType) {
        Ident identifier = new Ident(identifierValuePair.getIdentifierName());
        if (identifier != null && identifierIsOfType(identifier, expectedType) && expectedType.canTakeValue(identifierValuePair.getValue())) {
            return new QLInputValidationResultImpl(true, QLInputValidationResult.OK_MESSAGE);
        } else {
            return new QLInputValidationResultImpl(false, String.format(QLInputValidationResult.TYPED_ERROR_MESSAGE_TEMPLATE, expectedType.getName()));
        }
    }

    @Override
    public QLInputValidationResult validateInput(IdentifierValuePair[] identifierValuePairs) {
        CompoundValidationResult compoundValidationResult = new CompoundValidationResult();
        for (IdentifierValuePair identifierValuePair : identifierValuePairs) {
            QLInputValidationResult result = validateInput(identifierValuePair);
            compoundValidationResult.addInputValidationResult(result);
        }
        return compoundValidationResult;
    }

    @Override
    public QLInputValidationResult validateInput(IdentifierValuePair identifierValuePair) {
        Ident identifier = new Ident(identifierValuePair.getIdentifierName());
        Type type = getTypeForIdentifierName(identifier);
        if (type != null && type.canTakeValue(identifierValuePair.getValue())) {
            return new QLInputValidationResultImpl(true, QLInputValidationResult.OK_MESSAGE);
        } else {
            return new QLInputValidationResultImpl(false, String.format(QLInputValidationResult.NAMED_ERROR_MESSAGE_TEMPLATE, identifier.getName()));
        }
    }

    private Type getTypeForIdentifierName(Ident identifier) {
        if (symbolTable.containsIdentifier(identifier)) {
            return symbolTable.getIdentifier(identifier);
        }
        return null;
    }

    private boolean identifierIsOfType(Ident identifier, Type type) {
        if (symbolTable.containsIdentifier(identifier)) {
            return symbolTable.getIdentifier(identifier).isCompatibleTo(type);
        }
        return false;
    }
}
