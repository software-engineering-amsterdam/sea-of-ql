package ast.type;

import ast.Type;
import ast.visitor.Visitor;

public class Undefined<T> extends Type {
	private final T ast;
	private final String str;

	public Undefined(T ast, String str) {
		this.ast = ast;
		this.str = str;
	}

	public Undefined(T ast) {
		this.ast = ast;
		this.str = null;
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

	public T getAst() {
		return ast;
	}

	public String getStr() {
		return str;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return null;
	}
}
