package org.uva.sea.ql.ast.conditionals;

import java.util.List;

import org.uva.sea.ql.ast.base.*;
import org.uva.sea.ql.ast.form.Statement;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Represents an If Then statement in QL.
 * 
 * @author J. Dijkstra
 */
public class IfThen extends IfStatement {
	/**
	 * Constructor.
	 * 
	 * @param conditions
	 *            conditions
	 * @param successStatments
	 *            form statements to display on success
	 * @param syntaxPosition
	 *            the original position of the expression in the input syntax
	 */
	public IfThen(final Expression conditions, final List<Statement> successStatements,
			final SyntaxPosition syntaxPosition) {
		super(conditions, successStatements, syntaxPosition);
	}

	@Override
	public <T> T accept(final IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
