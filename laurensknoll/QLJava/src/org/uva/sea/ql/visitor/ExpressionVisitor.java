package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.expr.type.BoolExprType;
import org.uva.sea.ql.ast.expr.type.IdentExprType;
import org.uva.sea.ql.ast.expr.type.IntExprType;
import org.uva.sea.ql.ast.expr.type.MoneyExprType;
import org.uva.sea.ql.ast.expr.type.StringExprType;

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
