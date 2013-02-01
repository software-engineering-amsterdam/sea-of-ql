package ast;

import java.util.Map;

import ast.type.Ident;

public abstract class Expression implements ASTNode {

	public abstract Type typeOf(Map<Ident, Type> typeEnv);

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
