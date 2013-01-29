package ast.statement;

import java.util.Map;

import ast.Statement;
import ast.types.Ident;
import ast.types.Type;
import ast.visitors.Visitor;

public class If extends Statement {

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return null; //visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

}
