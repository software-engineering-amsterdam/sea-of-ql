package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.type.Type;

/**
 * Represents a question of which the value is computed using the values of other questions.
 */
public class ComputedQuestion extends Question {

	protected final Expression expression;
	
	public ComputedQuestion(Identifier id, StringLiteral label, Type type, Expression expr) {
		super(id, label, type);
		this.expression = expr;
	}

	/**
	 * Returns the expression used to compute the value of this question
	 * @return The expression
	 */
	public Expression getExpression() {
		return expression;
	}
	
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}
	
}
