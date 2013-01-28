package org.uva.sea.ql.visitor.print;

import org.uva.sea.ql.ast.expr.atom.Bool;
import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.expr.atom.Int;
import org.uva.sea.ql.ast.expr.atom.Money;
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
import org.uva.sea.ql.visitor.IExpression;

public class Expression implements IExpression<String> {

	@Override
	public String visit(Add add) {
		String left = add.getLeftHandSide().accept(this);
		String right = add.getRightHandSide().accept(this);

		return String.format("(%s + %s)", left, right);
	}

	@Override
	public String visit(And and) {
		String left = and.getLeftHandSide().accept(this);
		String right = and.getRightHandSide().accept(this);

		return String.format("(%s && %s)", left, right);
	}

	@Override
	public String visit(Div div) {
		String left = div.getLeftHandSide().accept(this);
		String right = div.getRightHandSide().accept(this);

		return String.format("(%s / %s)", left, right);
	}

	@Override
	public String visit(Eq eq) {
		String left = eq.getLeftHandSide().accept(this);
		String right = eq.getRightHandSide().accept(this);

		return String.format("(%s == %s)", left, right);
	}

	@Override
	public String visit(GEq geq) {
		String left = geq.getLeftHandSide().accept(this);
		String right = geq.getRightHandSide().accept(this);

		return String.format("(%s >= %s)", left, right);
	}

	@Override
	public String visit(GT gt) {
		String left = gt.getLeftHandSide().accept(this);
		String right = gt.getRightHandSide().accept(this);

		return String.format("(%s > %s)", left, right);
	}

	@Override
	public String visit(LEq leq) {
		String left = leq.getLeftHandSide().accept(this);
		String right = leq.getRightHandSide().accept(this);

		return String.format("(%s <= %s)", left, right);
	}

	@Override
	public String visit(LT lt) {
		String left = lt.getLeftHandSide().accept(this);
		String right = lt.getRightHandSide().accept(this);

		return String.format("(%s < %s)", left, right);
	}

	@Override
	public String visit(Mul mul) {
		String left = mul.getLeftHandSide().accept(this);
		String right = mul.getRightHandSide().accept(this);

		return String.format("(%s * %s)", left, right);
	}

	@Override
	public String visit(Neg neg) {
		String expr = neg.getExpression().accept(this);

		return String.format("(-%s)", expr);
	}

	@Override
	public String visit(NEq neq) {
		String left = neq.getLeftHandSide().accept(this);
		String right = neq.getRightHandSide().accept(this);

		return String.format("(%s <> %s)", left, right);
	}

	@Override
	public String visit(Not not) {
		String expr = not.getExpression().accept(this);

		return String.format("(!%s)", expr);
	}

	@Override
	public String visit(Or or) {
		String left = or.getLeftHandSide().accept(this);
		String right = or.getRightHandSide().accept(this);

		return String.format("(%s || %s)", left, right);
	}

	@Override
	public String visit(Pos pos) {
		String expr = pos.getExpression().accept(this);

		return String.format("(+%s)", expr);
	}

	@Override
	public String visit(Sub sub) {
		String left = sub.getLeftHandSide().accept(this);
		String right = sub.getRightHandSide().accept(this);

		return String.format("(%s - %s)", left, right);
	}

	@Override
	public String visit(Bool bool) {
		return String.format("%b", bool.getValue());
	}

	@Override
	public String visit(Ident ident) {
		return String.format("%s", ident.getName());
	}

	@Override
	public String visit(Int intType) {
		return String.format("%d", intType.getValue());
	}

	@Override
	public String visit(Money money) {
		return String.format("%.2f", money.getValue());
	}

	@Override
	public String visit(org.uva.sea.ql.ast.expr.atom.String string) {
		return String.format("%s", string.getValue());
	}

}
