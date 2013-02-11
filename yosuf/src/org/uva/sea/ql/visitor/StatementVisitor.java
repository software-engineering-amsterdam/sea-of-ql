package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.stm.CompoundStatement;
import org.uva.sea.ql.ast.stm.Computed;
import org.uva.sea.ql.ast.stm.Form;
import org.uva.sea.ql.ast.stm.IfElseStatement;
import org.uva.sea.ql.ast.stm.IfStatement;
import org.uva.sea.ql.ast.stm.Question;

public interface StatementVisitor<T> {

	T visit(Form form);

	T visit(CompoundStatement compoundStatement);

	T visit(Computed computed);

	T visit(IfStatement ifStatement);

	T visit(IfElseStatement ifElseStatement);

	T visit(Question question);

}
