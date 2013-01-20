package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.binary.Binary;
import org.uva.sea.ql.ast.expr.primary.Bool;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.expr.primary.Int;
import org.uva.sea.ql.ast.expr.primary.StringLiteral;
import org.uva.sea.ql.ast.expr.unary.Unary;
import org.uva.sea.ql.ast.stmt.IfThenElse;
import org.uva.sea.ql.ast.stmt.Question;

public interface Visitor {
	void visit(Form form);
//	void visit(Statement statement);
	void visit(IfThenElse ifThenElse);
	void visit(Question question);
	void visit(Unary unary);
	void visit(Binary binary);
	void visit(Ident ident);
	void visit(Bool bool);
	void visit(Int integer);
	void visit(StringLiteral stringLiteral);
}
