package ast.statement;

import ast.*;
import ast.expression.value.Ident;
import ast.visitor.Visitor;

public class Assignment extends Statement {
	
	private final Ident ident;
	private final Expression expression;
	
	public Assignment(Ident ident, Expression expression){
		this.ident = ident;
		this.expression = expression;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		System.out.println("ASSIGNMENT");
		return visitor.visit(this);
	}

	public Ident getIdent() {
		return ident;
	}

	public Expression getExpression() {
		return expression;
	}

}
