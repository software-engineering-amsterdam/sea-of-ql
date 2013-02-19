package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.stmt.IfThen;
import org.uva.sea.ql.ast.stmt.IfThenElse;
import org.uva.sea.ql.ast.stmt.question.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.question.NormalQuestion;

public interface IFormVisitor {
	void visit(ComputedQuestion computedQuestion);
	void visit(NormalQuestion question);
	void visit(IfThenElse ifThenElse);
	void visit(Form form);
	void visit(IfThen ifThen);
}