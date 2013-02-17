package ast;

import java.util.Map;

import ast.type.Ident;
import ast.visitor.Visitor;

public abstract class Expression implements ASTNode {

	public abstract <T> T accept(Visitor<T> visitor);
	public abstract Type typeOf(Map<Ident, Type> typeEnv);

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
