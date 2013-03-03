package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.value.Str;


public class QuestionVar extends Question {

	private final Var var;

	public QuestionVar(Str label, Var var) {
		super(label);
		this.var = var;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Ident getIdent() {
		return this.var.getIdent();
	}
	
	public Type getType(){
		return this.var.getType();
	}

	public Var getVar() {
		return var;
	}

}
