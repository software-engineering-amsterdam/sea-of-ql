package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.statements.CompoundStatement;
import org.uva.sea.ql.ast.statements.ConditionalStatement;
import org.uva.sea.ql.ast.statements.LineStatement;
import org.uva.sea.ql.ast.statements.QLProgram;
import org.uva.sea.ql.ast.types.Type;

public interface StatementVisitor<T> {
	T visit(QLProgram qlProgram);

	T visit(CompoundStatement compoundBlock);

	T visit(LineStatement lineStatement);

	T visit(ConditionalStatement conditionalStatement);

	T visit(Type typeDescription);
}
