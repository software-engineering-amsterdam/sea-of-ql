package ast.statement;

import java.util.Map;

import ast.*;
import ast.type.Ident;
import ast.type.Type;
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
		return null; //visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

	public Ident getIdent() {
		return ident;
	}

	public Expression getExpression() {
		return expression;
	}

}
