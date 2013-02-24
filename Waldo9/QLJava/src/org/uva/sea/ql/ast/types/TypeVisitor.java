package org.uva.sea.ql.ast.types;

public interface TypeVisitor<T> {
	
	public T visit(IntType intType);
	
	public T visit(StringType stringType);
	
	public T visit(BoolType boolType);
	
	public T visit(ErrorType errorType);

}
