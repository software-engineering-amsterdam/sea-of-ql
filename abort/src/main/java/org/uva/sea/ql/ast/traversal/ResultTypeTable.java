package org.uva.sea.ql.ast.traversal;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.operators.base.BinaryOperator;
import org.uva.sea.ql.ast.operators.base.UnaryOperator;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;

/**
 * Stores result types in a table/map of nodes while traversing the tree.
 * Required for semantical type checking.
 * @author J. Dijkstra
 */
class ResultTypeTable extends TypeTable {
	/**
	 * Constructor that limits the scope to the current package.
	 */
	protected ResultTypeTable() { }
	

	/**
	 * Check if both sides of a binary operation are of the same type.
	 * @param operator binary operation to check
	 * @return whether both sides are of the same type or not
	 */
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

	/**
	 * Check if a node or operation is of the boolean type.
	 * @param nodeType node or operation to check
	 * @return whether the node or operation is of the boolean type
	 */
	public boolean isBooleanType(final Class<? extends Node> nodeType) {
		return (Bool.class.equals(nodeType));
	}

	/**
	 * Check whether a node is of a numeric value (int or money) or not.
	 * @param nodeType node
	 * @return whether the node is of a numeric value or not
	 */
	public boolean isMoneyOrIntegerType(final Class<? extends Node> nodeType) {
		return (Int.class.equals(nodeType) || Money.class.equals(nodeType));
	}

	/**
	 * Check for the money type in at least one hand side of the operation.
	 * @param operator binary operation to check
	 * @return check whether the operation has to deal with the money type
	 */
	public final boolean isMoneyTypeInvolved(final BinaryOperator operator) {
		final Class<? extends Node> leftHandSide = getLeftHandSideResultType(operator);
		final Class<? extends Node> rightHandSide = getRightHandSideResultType(operator);		
		
		return (leftHandSide.equals(Money.class) || rightHandSide.equals(Money.class));
	}

	/**
	 * Get the result type of the left hand side of a binary operation.
	 * @param operator binary operation
	 * @return result type
	 */
	public final Class<? extends Node> getLeftHandSideResultType(final BinaryOperator operator) {
		return getTypeOfNode(operator.getLeftHandSide());
	}

	/**
	 * Get the result type of the right hand side of a binary operation.
	 * @param operator binary operation
	 * @return result type
	 */
	public final Class<? extends Node> getRightHandSideResultType(final BinaryOperator operator) {
		return getTypeOfNode(operator.getRightHandSide());
	}

	/**
	 * Get the result type of a unary operation.
	 * @param operator unary operation
	 * @return result type
	 */
	public final Class<? extends Node> getUnaryResultType(final UnaryOperator operator) {
		return getTypeOfNode(operator.getNode());
	}
}
