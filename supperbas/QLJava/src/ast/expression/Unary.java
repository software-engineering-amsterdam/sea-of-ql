package ast.expression;

import java.util.ArrayList;

import ast.Expression;


public abstract class Unary extends Expression {
	
	private final Expression expression;

	public Unary(Expression expression) {
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}
	
	public ArrayList<Ident> getIdents(){
		ArrayList<Ident> tmp = new ArrayList<Ident>();
		tmp.addAll(expression.getIdents());
		return tmp;		
	}

}
