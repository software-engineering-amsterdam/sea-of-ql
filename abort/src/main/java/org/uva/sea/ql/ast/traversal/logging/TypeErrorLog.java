package org.uva.sea.ql.ast.traversal.logging;

import java.util.List;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.operators.base.BinaryOperator;
import org.uva.sea.ql.ast.operators.base.Operator;
import org.uva.sea.ql.ast.traversal.base.HandSide;
import org.uva.sea.ql.ast.types.literals.Ident;

/**
 * Type checking error logger, which contains common errors.
 * 
 * @author J. Dijkstra
 */
public class TypeErrorLog extends Log {
	/**
	 * Add empty flow warning.
	 * 
	 * @param node
	 *            node that contains the empty flow
	 */
	public void addEmptyFlow(final Node node) {
		add(new Message(node, "Empty flow"));
	}

	/**
	 * Add invalid reference error.
	 * 
	 * @param node
	 *            node that has an invalid reference
	 * @param reference
	 *            the name of the invalid reference
	 */
	public void addInvalidReference(final Node node, final String reference) {
		add(new Message(node, String.format("Invalid reference to \"%s\"",
				reference)));
	}

	/**
	 * Add type is not an integer or money error.
	 * 
	 * @param handSide
	 *            hand side that has the wrong type
	 * @param operator
	 *            operator that has a hand side of the wrong type
	 */
	public void addTypeIsNotIntegerOrMoney(final HandSide handSide,
			final Operator operator) {
		final String text = String.format(
				"The %s is not of the type Integer or Money",
				getHandSideString(handSide));
		add(new Message(operator, text));
	}

	/**
	 * Add type is not a boolean error.
	 * 
	 * @param handSide
	 *            hand side that is not a boolean
	 * @param operator
	 *            operator that has one hand side of the wrong type
	 */
	public void addTypeIsNotBoolean(final HandSide handSide,
			final Operator operator) {
		final String text = String.format("The %s is not of the type boolean",
				getHandSideString(handSide));
		add(new Message(operator, text));
	}

	/**
	 * Add error that both sides are not of the same type.
	 * 
	 * @param operator
	 *            operator that causes the error
	 */
	public void addBothSidesAreDifferentTypes(final BinaryOperator operator) {
		add(new Message(operator, "Both sides have to be of the same type"));
	}

	/**
	 * Add ident redeclaration error.
	 * 
	 * @param node
	 *            node that redeclares an ident
	 * @param label
	 *            label that gets redeclarated
	 */
	public void addLabelRedeclaration(final Node node, final Ident ident) {
		add(new Message(node, String.format("Redeclaration of label \"%s\"",
				ident.getName())));
	}

	/**
	 * Add expected different types error.
	 * 
	 * @param node
	 * @param expectedTypes
	 */
	public void addExpectedDifferentTypes(final Node node,
			final List<Class<? extends Node>> expectedTypes) {
		// Create a representable list of the expected types
		final StringBuffer buffer = new StringBuffer();
		for (final Class<? extends Node> expectedType : expectedTypes) {
			buffer.append(expectedType.getName()).append(", ");
		}

		// Remove the last divider of the expected type list
		final String expectedTypesRepresentation = buffer.substring(0,
				buffer.length() - 2);

		add(new Message(node, String.format(
				"Expected one of the following types: %s",
				expectedTypesRepresentation)));
	}

	/**
	 * Add different type expectation error.
	 * 
	 * @param node
	 *            node that expects different types
	 * @param expectedType
	 *            expected type
	 */
	public void addExpectedDifferentType(final Node node,
			final Class<? extends Node> expectedType) {
		add(new Message(node, String.format("Expected the following type: %s ",
				expectedType.getName())));
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
