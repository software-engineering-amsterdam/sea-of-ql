package ast;

import java.util.Map;

import ast.types.Ident;
import ast.types.Type;
import ast.visitor.Visitor;

public abstract class Expression implements ASTNode {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	public abstract Type typeOf(Map<Ident, Type> typeEnv);

}
