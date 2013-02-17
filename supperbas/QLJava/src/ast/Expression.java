package ast;

import java.util.Map;

import ast.expression.Visitor;
import ast.expression.value.Ident;

public abstract class Expression implements ASTNode {

	public abstract <T> T accept(Visitor<T> visitor);
	public abstract Type typeOf(Map<Ident, Type> typeEnv);

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	public abstract String typeStr();

}
