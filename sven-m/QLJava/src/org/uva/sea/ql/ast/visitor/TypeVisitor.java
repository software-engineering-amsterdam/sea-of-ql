package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.IntType;
import org.uva.sea.ql.ast.type.StrType;

public interface TypeVisitor<T> {
	T visit(BoolType type);
	T visit(StrType type);
	T visit(IntType type);
}
