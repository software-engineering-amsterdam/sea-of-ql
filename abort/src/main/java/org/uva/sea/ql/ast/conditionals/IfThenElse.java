package org.uva.sea.ql.ast.conditionals;

import java.util.List;

import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.base.SyntaxPosition;
import org.uva.sea.ql.ast.form.Statement;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Represents an if then else statement in the QL language.
 * 
 * @author J. Dijkstra
 */
public class IfThenElse extends IfStatement {
	/**
	 * Form statements to display when the conditions fail.
	 */
	private final List<Statement> elseStatements;

	/**
	 * Constructor.
	 * 
	 * @param conditions
	 *            conditions
	 * @param successStatements
	 *            form statements to display on a successful condition
	 * @param elseStatements
	 *            form statements to display on an unsuccessful condition
	 * @param syntaxPosition
	 * 			  the original position of the expression in the input syntax
	 */
	public IfThenElse(final Expression conditions,
			final List<Statement> successStatements,
			final List<Statement> elseStatements,
			final SyntaxPosition syntaxPosition) {
		super(conditions, successStatements, syntaxPosition);
		this.elseStatements = elseStatements;
	}

	@Override
	public <T> T accept(final IVisitor<T> visitor) {
		return visitor.visit(this);
	}

	/**
	 * Retrieve the form statements to display on an unsuccessful condition.
	 * 
	 * @return form statements
	 */
	public List<Statement> getElseStatements() {
		return elseStatements;
	}
}
