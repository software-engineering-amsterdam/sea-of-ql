package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.form.BoolType;
import org.uva.sea.ql.ast.form.IntType;
import org.uva.sea.ql.ast.form.StrType;

public interface TypeVisitor<T> {
	T visit(BoolType type);
	T visit(StrType type);
	T visit(IntType type);
}
