package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.eval.Context;
import org.uva.sea.ql.eval.value.Value;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents an assignment.
 */
public class Assignment extends Statement {
	/**
	 * Holds the left-hand side.
	 */
	private final Ident ident;

	/**
	 * Holds the right-hand side.
	 */
	private final Expression expression;

	/**
	 * Constructs a new Assignment instance.
	 *
	 * @param ident The left-hand side to assign a value to.
	 * @param expression The right-hand side that evaluates to the value.
	 */
	public Assignment( Ident ident, Expression expression ) {
		this.ident = ident;
		this.expression = expression;
	}

	/**
	 * Retrieves the identifier.
	 *
	 * @return The left-hand side.
	 */
	public Ident getIdent() {
		return this.ident;
	}

	/**
	 * Retrieves the right-hand side expression.
	 *
	 * @return The right-hand side.
	 */
	public Expression getExpression() {
		return this.expression;
	}

	@Override
	public Value<?> accept( INodeVisitor visitor, Context context ) {
		return visitor.visit( this, context );
	}
}
