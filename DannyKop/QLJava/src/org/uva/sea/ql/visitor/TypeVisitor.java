package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.NullType;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.ast.types.Type;

public interface TypeVisitor <T> {
	
	public T visit(Type t);
	public T visit(StrType s);
	public T visit(IntType i);
	public T visit(BoolType b);
	public T visit(NullType n);

}
