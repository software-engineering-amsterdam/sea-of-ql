package ast.expression;

import java.util.ArrayList;

import ast.Expression;


public abstract class Binary extends Expression {
	
	private final Expression lhs;
	private final Expression rhs;

	public Binary(Expression lhs, Expression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expression getRhs() {
		return rhs;
	}

	public Expression getLhs() {
		return lhs;
	}
	
	public ArrayList<Ident> getIdents(){
		ArrayList<Ident> tmp = new ArrayList<Ident>();
		tmp.addAll(lhs.getIdents());
		tmp.addAll(rhs.getIdents());
		return tmp;		
	}

}
