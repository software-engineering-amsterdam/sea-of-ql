package ast.statement;

import ast.Type;
import ast.expression.value.Ident;
import ast.expression.value.Str;
import ast.visitor.Visitor;

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
