package ast.statement;

import java.util.Map;

import ast.Statement;
import ast.type.Type;
import ast.expression.value.Ident;
import ast.visitor.Visitor;

public class Var extends Statement {
	
	private final Ident ident;
	private final Type type;

	public Var(Ident ident, Type type){
		this.ident = ident;
		this.type = type;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return null; //visitor.visit(this);
	}

	public Ident getIdent() {
		return ident;
	}

	public Type getType() {
		return type;
	}

	@Override
	public Type typeOf(Map<ast.type.Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

}
