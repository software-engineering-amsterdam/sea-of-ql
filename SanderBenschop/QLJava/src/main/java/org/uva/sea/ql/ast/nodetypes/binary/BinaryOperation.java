package org.uva.sea.ql.ast.nodetypes.binary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.parser.visitor.ASTNodeVisitor;

public abstract class BinaryOperation extends QLExpression {
	
	private final QLExpression leftHandSide;
	private final QLExpression rightHandSide;
	
	public BinaryOperation(QLExpression leftHandSide, QLExpression rightHandSide) {
		this.leftHandSide = leftHandSide;
		this.rightHandSide = rightHandSide;
	}

	public QLExpression getLeftHandSide() {
		return leftHandSide;
	}

	public QLExpression getRightHandSide() {
		return rightHandSide;
	}

    @Override
    public void accept(ASTNodeVisitor visitor) {
        getLeftHandSide().accept(visitor);
        getRightHandSide().accept(visitor);
    }

}
