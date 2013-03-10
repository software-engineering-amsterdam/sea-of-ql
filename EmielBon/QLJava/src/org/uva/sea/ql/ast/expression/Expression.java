package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;

/**
 * Class that represents an expression
 * @author emiel.bon
 */
public abstract class Expression extends Node {
	
	/**
	 * Computes the type of the expression, in the specified type environment
	 * @param env The type environment 
	 * @return The type of the expression
	 */
	public abstract Type typeOf(TypeEnvironment env);
	
	/**
	 * Calls the visit method on the visitor parameter
	 * @param visitor An object implementing the ExpressionVisitor interface
	 * @return An object specified in the visitor parameter
	 */
	public abstract <T> T accept(ExpressionVisitor<T> visitor);
	
	/**
	 * The textual representation of this expression
	 * @return A string containing the textual representation of this expression
	 */
	public abstract String getRepresentation();
	
}
