package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.IfThenElse;
import org.uva.sea.ql.ast.stmt.NormalQuestion;
import org.uva.sea.ql.ast.type.Type;

public interface FormVisitor {
	void visit(Form form);
	void visit(IfThenElse ifThenElse);
	void visit(NormalQuestion question);
	void visit(ComputedQuestion computedQuestion);
	void visit(Type type);
	void visit(Expr expr);
}
