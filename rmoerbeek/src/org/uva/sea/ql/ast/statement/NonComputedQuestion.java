package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.visitors.StatementVisitor;

public class NonComputedQuestion extends Question {

	public NonComputedQuestion(Ident id, String l, Type t) {
		super(id, l, t);
	}
	
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
		
}
