package org.uva.sea.ql.visitors;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
import org.uva.sea.ql.ast.expr.binary.Div;
import org.uva.sea.ql.ast.expr.binary.Eq;
import org.uva.sea.ql.ast.expr.binary.GEq;
import org.uva.sea.ql.ast.expr.binary.GT;
import org.uva.sea.ql.ast.expr.binary.LEq;
import org.uva.sea.ql.ast.expr.binary.LT;
import org.uva.sea.ql.ast.expr.binary.Mul;
import org.uva.sea.ql.ast.expr.binary.NEq;
import org.uva.sea.ql.ast.expr.binary.Or;
import org.uva.sea.ql.ast.expr.binary.Sub;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.ast.expr.value.BoolLiteral;
import org.uva.sea.ql.ast.expr.value.IntLiteral;
import org.uva.sea.ql.ast.expr.value.MoneyLiteral;
import org.uva.sea.ql.ast.expr.value.StringLiteral;

public interface IExprVisitor<T> {
	
	T visit(Add node);
	T visit(And node);
	T visit(Div node);
	T visit(Eq node);
	T visit(GEq node);
	T visit(GT node);
	T visit(LEq node);
	T visit(LT node);
	T visit(Mul node);
	T visit(NEq node);
	T visit(Or node);
	T visit(Pos node);
	T visit(Neg node);
	T visit(Not node);
	T visit(Sub node);
	T visit(Ident node);
	T visit(IntLiteral node);
	T visit(BoolLiteral node);
	T visit(MoneyLiteral node);
	T visit(StringLiteral node);
	
}
