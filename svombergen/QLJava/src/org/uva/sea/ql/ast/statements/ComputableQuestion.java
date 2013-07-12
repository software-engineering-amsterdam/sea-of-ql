package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.primaryexpr.Ident;
import org.uva.sea.ql.ast.primaryexpr.Str;
import org.uva.sea.ql.ast.statements.types.BoolType;
import org.uva.sea.ql.ast.statements.types.IntType;
import org.uva.sea.ql.ast.statements.types.Type;
import org.uva.sea.ql.ast.value.BoolValue;
import org.uva.sea.ql.ast.value.IntValue;
import org.uva.sea.ql.ast.value.StrValue;
import org.uva.sea.ql.visitor.gui.IFormVisitor;

public class ComputableQuestion extends Question {
	protected Expr expr;

	public ComputableQuestion(Ident id, Str q, Type t, Expr e) {
		super(id, q, t);
		expr = e;
		
		if (t.equals(new IntType()))
			value = new IntValue(0);
		else if (t.equals(new BoolType()))
			value = new BoolValue(false);
		else 
			value = new StrValue("");
	}
	
	public Expr getExpression(){
		return expr;
	}

	@Override
	public <T> T accept(IFormVisitor<T> v){
		return v.visit(this);
	}

}
