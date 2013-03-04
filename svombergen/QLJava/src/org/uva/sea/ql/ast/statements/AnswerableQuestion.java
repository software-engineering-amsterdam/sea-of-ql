package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.primaryexpr.Ident;
import org.uva.sea.ql.ast.primaryexpr.Str;
import org.uva.sea.ql.ast.statements.types.Type;
import org.uva.sea.ql.visitor.Visitor;

public class AnswerableQuestion extends Question {

	public AnswerableQuestion(Ident id, Str q, Type t) {
		super(id, q, t);
	}

	@Override
	public void accept(Visitor v){
		v.visit(this);
	}

}
