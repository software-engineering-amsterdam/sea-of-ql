package ast.statement;

import ast.Statement;
import ast.expression.value.Str;
import ast.visitor.Visitor;

public class Question extends Statement {
	
	private final Str question;
	private final Var var;
	
	public Question(Str yysv, Var var){
		this.question = yysv;
		this.var = var;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	public Str getQuestion() {
		return question;
	}

	public Var getVar() {
		return var;
	}

}
