package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.form.types.BoolType;
import org.uva.sea.ql.ast.form.types.IntType;
import org.uva.sea.ql.ast.form.types.StrType;

public interface TypeVisitor<T> {
	T visit(BoolType type);
	T visit(StrType type);
	T visit(IntType type);
}
