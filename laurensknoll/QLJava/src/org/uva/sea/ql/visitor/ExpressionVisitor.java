package org.uva.sea.ql.visitor;

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
import org.uva.sea.ql.ast.expr.type.BoolExprType;
import org.uva.sea.ql.ast.expr.type.IdentExprType;
import org.uva.sea.ql.ast.expr.type.IntExprType;
import org.uva.sea.ql.ast.expr.type.MoneyExprType;
import org.uva.sea.ql.ast.expr.type.StringExprType;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;

public interface ExpressionVisitor<T> {

	public T visit(Add add);

	public T visit(And and);

	public T visit(Div div);

	public T visit(Eq eq);

	public T visit(GEq geq);

	public T visit(GT gt);

	public T visit(LEq leq);

	public T visit(LT lt);

	public T visit(Mul mul);

	public T visit(Neg neg);

	public T visit(NEq neq);

	public T visit(Not not);

	public T visit(Or or);

	public T visit(Pos pos);

	public T visit(Sub sub);

	public T visit(BoolExprType bool);

	public T visit(IdentExprType ident);

	public T visit(IntExprType intType);

	public T visit(MoneyExprType money);

	public T visit(StringExprType string);
}
