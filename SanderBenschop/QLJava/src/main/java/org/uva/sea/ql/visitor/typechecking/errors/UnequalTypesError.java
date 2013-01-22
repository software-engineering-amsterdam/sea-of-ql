package org.uva.sea.ql.visitor.typechecking.errors;

import org.uva.sea.ql.ast.binary.BinaryOperation;
import org.uva.sea.ql.visitor.QLError;

public class UnequalTypesError extends QLError {

    private static final String ERROR_MESSAGE_TEMPLATE = "Error: binary operation on line %d contains unequal types of respectively %s and %s.";

    private final Class<?> leftHandSideType;
    private final Class<?> rightHandSideType;

    public UnequalTypesError(int line, BinaryOperation binaryOperation) {
        super(line);
        this.leftHandSideType = binaryOperation.getLeftHandSide().getClass();
        this.rightHandSideType = binaryOperation.getRightHandSide().getClass();
    }

    @Override
    public String getErrorMessage() {
        return String.format(ERROR_MESSAGE_TEMPLATE, getLine(), leftHandSideType.getSimpleName(), rightHandSideType.getSimpleName());
    }
}
