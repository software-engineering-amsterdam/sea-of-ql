package org.uva.sea.ql.ast.nodetypes.binary;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

import java.util.List;

public abstract class BinaryOperation implements QLExpression {

	private final ASTNode leftHandSide;
	private final ASTNode rightHandSide;

	public BinaryOperation(ASTNode leftHandSide, ASTNode rightHandSide) {
		this.leftHandSide = leftHandSide;
		this.rightHandSide = rightHandSide;
	}

	public ASTNode getLeftHandSide() {
		return leftHandSide;
	}

	public ASTNode getRightHandSide() {
		return rightHandSide;
	}

    @Override
    public void accept(ASTNodeVisitor visitor) {
        getLeftHandSide().accept(visitor);
        getRightHandSide().accept(visitor);
        visitor.visitBinaryOperation(this);
    }

    public abstract List<Class<?>> getSupportedTypes();
}
