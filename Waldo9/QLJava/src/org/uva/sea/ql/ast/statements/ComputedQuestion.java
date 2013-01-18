package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.StringLiteral;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.Type;

public class ComputedQuestion extends Question {
	
	private Expr expression;
	
	public ComputedQuestion(Ident identifier, StringLiteral label, Type type, Expr expression) {
		super(identifier, label, type);
		this.expression = expression;
	}

}
