package org.uva.sea.ql.ast.expression;

public interface Type {
	public Variable getVariable(Identifier id);
	public Primitive getPrimitive();
}
