package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.primaryexpr.Ident;
import org.uva.sea.ql.ast.primaryexpr.Str;
import org.uva.sea.ql.ast.statements.types.*;
import org.uva.sea.ql.ast.value.BoolValue;
import org.uva.sea.ql.ast.value.IntValue;
import org.uva.sea.ql.ast.value.StrValue;
import org.uva.sea.ql.visitor.IFormVisitor;

public class AnswerableQuestion extends Question {

	public AnswerableQuestion(Ident id, Str q, Type t) {
		super(id, q, t);
		
		if (t.equals(new IntType()))
			value = new IntValue(0);
		else if (t.equals(new BoolType()))
			value = new BoolValue(false);
		else 
			value = new StrValue("");
	}
	
	@Override
	public <T> T accept(IFormVisitor<T> v){
		return v.visit(this);
	}

}
