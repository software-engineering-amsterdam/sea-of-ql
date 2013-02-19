package org.uva.sea.ql.ast.expression.binary;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.SourceCodeInformation;

public abstract class BinaryOperation extends Expression {

    private final Expression leftHandSide;
    private final Expression rightHandSide;

    public BinaryOperation(Expression leftHandSide, Expression rightHandSide, SourceCodeInformation sourceInfo) {
        super(sourceInfo);
        this.leftHandSide = leftHandSide;
        this.rightHandSide = rightHandSide;
    }

    public Expression getLeftHandSide() {
        return leftHandSide;
    }

    public Expression getRightHandSide() {
        return rightHandSide;
    }
}
