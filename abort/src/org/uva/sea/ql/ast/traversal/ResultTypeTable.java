package org.uva.sea.ql.ast.traversal;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.operators.base.BinaryOperator;
import org.uva.sea.ql.ast.operators.base.UnaryOperator;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;

class ResultTypeTable extends TypeTable {
	protected ResultTypeTable() { }
	
	public boolean hasOperationGotEqualTypes(final BinaryOperator operator) {
		final Class<? extends Node> leftHandSide = getLeftHandSideResultType(operator);
		final Class<? extends Node> rightHandSide = getRightHandSideResultType(operator);		
		
		if (leftHandSide == null || rightHandSide == null) {
			return false;
		}
		else {
			return leftHandSide.equals(rightHandSide);
		}
	}

	public boolean isBooleanType(final Class<? extends Node> nodeType) {
		return (Bool.class.equals(nodeType));
	}

	public boolean isMoneyOrIntegerType(final Class<? extends Node> nodeType) {
		return (Int.class.equals(nodeType) || Money.class.equals(nodeType));
	}

	public final boolean isMoneyTypeInvolved(final UnaryOperator operator) {
		final Class<? extends Node> type = getTypeOfNode(operator.getNode());
		
		return type.equals(Money.class);
	}
	
	public final boolean isMoneyTypeInvolved(final BinaryOperator operator) {
		final Class<? extends Node> leftHandSide = getLeftHandSideResultType(operator);
		final Class<? extends Node> rightHandSide = getRightHandSideResultType(operator);		
		
		return (leftHandSide.equals(Money.class) || rightHandSide.equals(Money.class));
	}

	public final Class<? extends Node> getLeftHandSideResultType(final BinaryOperator operator) {
		return getTypeOfNode(operator.getLeftHandSide());
	}

	public final Class<? extends Node> getRightHandSideResultType(final BinaryOperator operator) {
		return getTypeOfNode(operator.getRightHandSide());
	}

	public final Class<? extends Node> getUnaryResultType(final UnaryOperator operator) {
		return getTypeOfNode(operator.getNode());
	}
}
