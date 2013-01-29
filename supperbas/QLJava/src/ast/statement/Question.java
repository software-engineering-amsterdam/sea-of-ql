package ast.statement;

import java.util.Map;

import ast.Statement;
import ast.type.Ident;
import ast.type.Type;
import ast.visitor.Visitor;

public class Question extends Statement {
	
	private final String question;
	private final Var var;
	
	public Question(String question, Var var){
		this.question = question;
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

	public String getQuestion() {
		return question;
	}

	public Var getVar() {
		return var;
	}

}
