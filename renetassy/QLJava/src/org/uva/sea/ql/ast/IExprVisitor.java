package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.BoolLiteral;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.IntLiteral;
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

public interface IExprVisitor<T> {
	
	T visit(Add node);
	
	T visit(And node);
	
	T visit(Div node);
	
	T visit(Eq node);
	
	T visit(GEq node);
	
	T visit(GT node);
	
	T visit(Ident node);
	
	T visit(IntLiteral node);
	
	T visit(LEq node);
	
	T visit(LT node);
	
	T visit(Mul node);
	
	T visit(Neg node);
	
	T visit(NEq node);
	
	T visit(Not node);
	
	T visit(Or node);
	
	T visit(Pos node);
	
	T visit(Sub node);
	
	T visit(BoolLiteral node);
	
	T visit(StringLiteral node);
	
}
