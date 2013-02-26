package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.literals.StringLiteral;

public class ComputedValue extends Statement {

	private Identifier identifier;
	private StringLiteral text;
	private Expression expression;
	private Type type;

	public ComputedValue(Identifier identifier, StringLiteral text,
			Expression expression, Type type) {
		this.identifier = identifier;
		this.text = text;
		this.expression = expression;
		this.type = type;
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

	public Type getType() {
		return type;
	}

	public Expression getExpression() {
		return expression;
	}

	public StringLiteral getText() {
		return text;
	}

	public Identifier getIdentifier() {
		return identifier;
	}
}
