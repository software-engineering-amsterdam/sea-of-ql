package ast.statement;

import ast.Type;
import ast.expression.Ident;
import ast.expression.value.Str;

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
