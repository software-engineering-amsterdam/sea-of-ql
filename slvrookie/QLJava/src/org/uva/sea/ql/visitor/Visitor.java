package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.*;


public interface Visitor {
	
	void visit(Add add);
	void visit(And and);
	void visit(Div div);
	void visit(Eq eq);
	void visit(GEq geq);
	void visit(GT gt);
	void visit(LEq leq);
	void visit(LT lt);
	void visit(Mul mul);
	void visit(Neg neg);
	void visit(NEq neq);
	void visit(Not not);
	void visit(Or or);
	void visit(Pos pos);
	void visit(Sub sub);
	void visit(BoolLiteral bool);
	void visit(IntLiteral intl);
	void visit(MoneyLiteral money);
	void visit(StringLiteral stringl);
	void visit(Ident ident);
	void visit(Form form);
	void visit(FormBlock fblock);
	void visit(Question question);
	void visit(IfBody ifbody);
	void visit(UnaryExpr unExpr);
	void visit(BinaryExpr binExpr);
	
}
