package ast.statement;

import ast.*;
import ast.expression.Ident;

public class Assignment extends Statement {
	
	private final Ident ident;
	private final Expression expression;
	
	public Assignment(Ident ident, Expression expression){
		this.ident = ident;
		this.expression = expression;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	public Ident getIdent() {
		return ident;
	}

	public Expression getExpression() {
		return expression;
	}

}
