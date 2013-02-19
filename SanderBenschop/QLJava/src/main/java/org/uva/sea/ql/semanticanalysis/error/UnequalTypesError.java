package org.uva.sea.ql.semanticanalysis.error;

import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.ast.sourcecodeinformation.SourceCodeInformation;

public class UnequalTypesError extends SemanticQLError {

    private static final String ERROR_MESSAGE_TEMPLATE = "Error: binary operation on line '%d' column position '%d' contains unequal types of respectively %s and %s.";

    private final Type leftHandSideType;
    private final Type rightHandSideType;

    public UnequalTypesError(SourceCodeInformation sourceCodeInformation, Type leftHandSideType, Type rightHandSideType) {
        super(sourceCodeInformation);
        this.leftHandSideType = leftHandSideType;
        this.rightHandSideType = rightHandSideType;
    }

    @Override
    public String getErrorMessage() {
        int lineNumber = getSourceCodeInformation().getLineNumber(), columnPosition = getSourceCodeInformation().getColumnPosition();
        return String.format(ERROR_MESSAGE_TEMPLATE, lineNumber, columnPosition, leftHandSideType.getObjectLiteralSimpleClassName(), rightHandSideType.getObjectLiteralSimpleClassName());
    }
}
