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

public interface ExpressionVisitor {

	public VisitorResult visit(Add add);

	public VisitorResult visit(And and);

	public VisitorResult visit(Div div);

	public VisitorResult visit(Eq eq);

	public VisitorResult visit(GEq geq);

	public VisitorResult visit(GT gt);

	public VisitorResult visit(LEq leq);

	public VisitorResult visit(LT lt);

	public VisitorResult visit(Mul mul);

	public VisitorResult visit(Neg neg);

	public VisitorResult visit(NEq neq);

	public VisitorResult visit(Not not);

	public VisitorResult visit(Or or);

	public VisitorResult visit(Pos pos);

	public VisitorResult visit(Sub sub);

	public VisitorResult visit(BoolExprType bool);

	public VisitorResult visit(IdentExprType ident);

	public VisitorResult visit(IntExprType intType);

	public VisitorResult visit(MoneyExprType money);

	public VisitorResult visit(StringExprType string);
}
