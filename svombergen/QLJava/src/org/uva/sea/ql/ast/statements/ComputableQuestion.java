package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.primaryexpr.Ident;
import org.uva.sea.ql.ast.primaryexpr.Str;
import org.uva.sea.ql.ast.statements.types.Type;
import org.uva.sea.ql.visitor.Visitor;

public class ComputableQuestion extends Question {
	protected Expr expr;

	public ComputableQuestion(Ident id, Str q, Type t, Expr e) {
		super(id, q, t);
		expr = e;
	}
	
	public Expr getExpression(){
		return expr;
	}

	@Override
	public void accept(Visitor v){
		v.visit(this);
	}

}
