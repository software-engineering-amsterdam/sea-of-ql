package org.uva.sea.ql.visitor.eval.observer;

import org.uva.sea.ql.ast.expr.atom.Ident;
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

public class Dependency implements IExpression<DependencySet> {

	@Override
	public DependencySet visit(Add add) {
		DependencySet left = add.getLeftHandSide().accept(this);
		DependencySet right = add.getRightHandSide().accept(this);

		return left.addAll(right);
	}

	@Override
	public DependencySet visit(And and) {
		DependencySet left = and.getLeftHandSide().accept(this);
		DependencySet right = and.getRightHandSide().accept(this);

		return left.addAll(right);
	}

	@Override
	public DependencySet visit(Div div) {
		DependencySet left = div.getLeftHandSide().accept(this);
		DependencySet right = div.getRightHandSide().accept(this);

		return left.addAll(right);
	}

	@Override
	public DependencySet visit(Eq eq) {
		DependencySet left = eq.getLeftHandSide().accept(this);
		DependencySet right = eq.getRightHandSide().accept(this);

		return left.addAll(right);
	}

	@Override
	public DependencySet visit(GEq geq) {
		DependencySet left = geq.getLeftHandSide().accept(this);
		DependencySet right = geq.getRightHandSide().accept(this);

		return left.addAll(right);
	}

	@Override
	public DependencySet visit(GT gt) {
		DependencySet left = gt.getLeftHandSide().accept(this);
		DependencySet right = gt.getRightHandSide().accept(this);

		return left.addAll(right);
	}

	@Override
	public DependencySet visit(LEq leq) {
		DependencySet left = leq.getLeftHandSide().accept(this);
		DependencySet right = leq.getRightHandSide().accept(this);

		return left.addAll(right);
	}

	@Override
	public DependencySet visit(LT lt) {
		DependencySet left = lt.getLeftHandSide().accept(this);
		DependencySet right = lt.getRightHandSide().accept(this);

		return left.addAll(right);
	}

	@Override
	public DependencySet visit(Mul mul) {
		DependencySet left = mul.getLeftHandSide().accept(this);
		DependencySet right = mul.getRightHandSide().accept(this);

		return left.addAll(right);
	}

	@Override
	public DependencySet visit(Neg neg) {
		DependencySet value = neg.getExpression().accept(this);

		return value;
	}

	@Override
	public DependencySet visit(NEq neq) {
		DependencySet left = neq.getLeftHandSide().accept(this);
		DependencySet right = neq.getRightHandSide().accept(this);

		return left.addAll(right);
	}

	@Override
	public DependencySet visit(Not not) {
		DependencySet value = not.getExpression().accept(this);

		return value;
	}

	@Override
	public DependencySet visit(Or or) {
		DependencySet left = or.getLeftHandSide().accept(this);
		DependencySet right = or.getRightHandSide().accept(this);

		return left.addAll(right);
	}

	@Override
	public DependencySet visit(Pos pos) {
		DependencySet value = pos.getExpression().accept(this);

		return value;
	}

	@Override
	public DependencySet visit(Sub sub) {
		DependencySet left = sub.getLeftHandSide().accept(this);
		DependencySet right = sub.getRightHandSide().accept(this);

		return left.addAll(right);
	}

	@Override
	public DependencySet visit(org.uva.sea.ql.ast.expr.atom.Bool bool) {
		return new DependencySet();
	}

	@Override
	public DependencySet visit(Ident ident) {
		return new DependencySet(ident);
	}

	@Override
	public DependencySet visit(org.uva.sea.ql.ast.expr.atom.Int intType) {
		return new DependencySet();
	}

	@Override
	public DependencySet visit(org.uva.sea.ql.ast.expr.atom.Money money) {
		return new DependencySet();
	}

	@Override
	public DependencySet visit(org.uva.sea.ql.ast.expr.atom.String string) {
		return new DependencySet();
	}

}
