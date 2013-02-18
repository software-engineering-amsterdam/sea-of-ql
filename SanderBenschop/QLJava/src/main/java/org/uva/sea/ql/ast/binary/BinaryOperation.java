package org.uva.sea.ql.ast.binary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.SourceCodeInformation;

public abstract class BinaryOperation extends QLExpression {

    private final QLExpression leftHandSide;
    private final QLExpression rightHandSide;

    public BinaryOperation(QLExpression leftHandSide, QLExpression rightHandSide, SourceCodeInformation sourceInfo) {
        super(sourceInfo);
        this.leftHandSide = leftHandSide;
        this.rightHandSide = rightHandSide;
    }

    public QLExpression getLeftHandSide() {
        return leftHandSide;
    }

    public QLExpression getRightHandSide() {
        return rightHandSide;
    }
}
