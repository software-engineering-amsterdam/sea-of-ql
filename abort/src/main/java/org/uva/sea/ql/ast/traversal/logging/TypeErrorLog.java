package org.uva.sea.ql.ast.traversal.logging;

import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.form.Statement;
import org.uva.sea.ql.ast.operators.base.*;
import org.uva.sea.ql.ast.traversal.base.HandSide;
import org.uva.sea.ql.ast.types.Ident;

/**
 * Type checking error logger, which contains common errors.
 * 
 * @author J. Dijkstra
 */
public class TypeErrorLog extends Log {
	/**
	 * Add invalid reference error.
	 * 
	 * @param expression
	 *            expression that has an invalid reference
	 * @param reference
	 *            the name of the invalid reference
	 */
	public void addInvalidReference(final Expression expression) {
		add(new TypeMessage(expression, "Invalid reference"));
	}

	/**
	 * Add type is not an integer or money error.
	 * 
	 * @param handSide
	 *            hand side that has the wrong type
	 * @param operator
	 *            operator that has a hand side of the wrong type
	 */
	public void addTypeIsNotIntegerOrMoney(final HandSide handSide, final Operator operator) {
		final String text = String.format("The %s is not of the type Integer or Money", getHandSideString(handSide));
		add(new TypeMessage(operator, text));
	}

	/**
	 * Add type is not a boolean error.
	 * 
	 * @param handSide
	 *            hand side that is not a boolean
	 * @param operator
	 *            operator that has one hand side of the wrong type
	 */
	public void addTypeIsNotBoolean(final HandSide handSide, final Operator operator) {
		final String text = String.format("The %s is not of the type boolean", getHandSideString(handSide));
		add(new TypeMessage(operator, text));
	}

	/**
	 * Add error that both sides are not of the same type.
	 * 
	 * @param operator
	 *            operator that causes the error
	 */
	public void addBothSidesAreDifferentTypes(final BinaryOperator operator) {
		add(new TypeMessage(operator, "Both sides have to be of the same type"));
	}

	/**
	 * Add ident redeclaration error.
	 * 
	 * @param statement
	 *            statement that redeclares an ident
	 * @param label
	 *            label that gets redeclarated
	 */
	public void addIdentRedeclaration(final Statement statement, final Ident ident) {
		add(new TypeMessage(statement, String.format("Redeclaration of ident \"%s\"", ident.getName())));
	}

	/**
	 * Retrieve a hand side of an operator as a string.
	 * 
	 * @param handSide
	 *            hand side
	 * @return hand side as a string
	 */
	private String getHandSideString(final HandSide handSide) {
		return String.format("%s handside", handSide.toString());
	}
}
