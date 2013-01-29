package ast.statement;

import java.util.Map;

import ast.Statement;
import ast.type.*;
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
		return null; //visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

	public Str getQuestion() {
		return question;
	}

	public Var getVar() {
		return var;
	}

}
