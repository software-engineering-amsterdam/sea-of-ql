package org.uva.sea.ql.ast.traversal.logging;

import java.util.List;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Label;
import org.uva.sea.ql.ast.traversal.base.HandSide;

/**
 * Type checking error logger, which contains common errors
 */
public class TypeErrorLog extends Log {
	public void addEmptyFlow(final Node node) {
		add(new Line(node, "Empty flow"));
	}
	
	public void addInvalidReference(final Node node, final String reference) {
		add(new Line(node, String.format("Invalid reference to \"%s\"", reference)));
	}
	
	public void addTypeIsNotIntegerOrMoney(final HandSide handSide, final Node node) {
		final String text = String.format("The %s is not of the type Integer or Money", getHandSideString(handSide), node);
		add(new Line(node, text));
	}
	
	public void addTypeIsNotBoolean(final HandSide handSide, final Node node) {
		final String text = String.format("The %s is not of the type boolean", getHandSideString(handSide), node);
		add(new Line(node, text));
	}
	
	public void addBothSidesAreDifferentTypes(final Node node) {
		add(new Line(node, "Both sides have to be of the same type"));
	}
	
	public void addLabelRedeclaration(final Node node, final Label label) {
		add(new Line(node, String.format("Redeclaration of label \"%s\"", label.getIdentifier())));
	}
	
	public void addExpectedDifferentTypes(final Node node, final List<Class<? extends Node>> expectedTypes) {
		// Create a representable list of the expected types
		final StringBuffer buffer = new StringBuffer();
		for (Class<? extends Node> expectedType : expectedTypes) {
			buffer.append(expectedType.getName() + ", ");
		}
		
		// Remove the last divider of the expected type list
		final String expectedTypesRepresentation = buffer.substring(0, buffer.length() - 2);
		
		add(new Line(node, String.format("Expected one of the following types: %s", expectedTypesRepresentation)));		
	}
	
	public void addExpectedDifferentType(final Node node, final Class<? extends Node> expectedType) {
		add(new Line(node, String.format("Expected the following type: " + expectedType.getName())));
	}
	
	// Get the hand-side of an operator as a string, to represent it in the log 
	private String getHandSideString(final HandSide handSide) {
		return String.format("%s handside", handSide.toString());
	}
}
