package org.uva.sea.ql.ast.conditionals;

import java.util.List;

import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.base.SyntaxPosition;
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
	 * @param successElements
	 *            form elements to display on success
	 * @param syntaxPosition
	 * 			  the original position of the expression in the input syntax
	 */
	public IfThen(final Expression conditions,
			final List<Statement> successElements, final SyntaxPosition syntaxPosition) {
		super(conditions, successElements, syntaxPosition);
	}

	@Override
	public <T> T accept(final IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
