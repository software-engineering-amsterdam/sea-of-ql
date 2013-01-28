package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.BoolLiteral;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.Int;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.StringLiteral;
import org.uva.sea.ql.ast.expr.Sub;

public interface IASTVisitor {
	
	void visit(Add node);
	void visit(And node);
	//void visit(Binary node);
	void visit(Div node);
	void visit(Eq node);
	void visit(GEq node);
	void visit(GT node);
	void visit(Ident node);
	void visit(Int node);
	void visit(LEq node);
	void visit(LT node);
	void visit(Mul node);
	void visit(Neg node);
	void visit(NEq node);
	void visit(Not node);
	void visit(Or node);
	void visit(Pos node);
	void visit(Sub node);
	void visit(BoolLiteral node);
	void visit(StringLiteral node);
	
}
