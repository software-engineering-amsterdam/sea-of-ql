package org.uva.sea.ql.ast.traversal;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.operators.base.BinaryOperator;
import org.uva.sea.ql.ast.operators.base.UnaryOperator;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;

/**
 * Stores result types in a table/map of nodes while traversing the tree, required for semantical type checking
 */
class ResultTypeTable extends TypeTable {
	// Only usable the current package
	protected ResultTypeTable() { }
	
	// Check the left and right hand side to be of equal types
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

	// Check for a numeric value
	public boolean isMoneyOrIntegerType(final Class<? extends Node> nodeType) {
		return (Int.class.equals(nodeType) || Money.class.equals(nodeType));
	}

	// Check if either the left or right (or both) hand sides are of the money type
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
