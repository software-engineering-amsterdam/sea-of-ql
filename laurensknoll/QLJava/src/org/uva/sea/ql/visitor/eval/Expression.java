package org.uva.sea.ql.visitor.eval;

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
import org.uva.sea.ql.visitor.eval.value.AbstractValue;
import org.uva.sea.ql.visitor.eval.value.Bool;
import org.uva.sea.ql.visitor.eval.value.Int;
import org.uva.sea.ql.visitor.eval.value.Money;
import org.uva.sea.ql.visitor.eval.value.String;

public class Expression implements IExpression<AbstractValue> {

	private final Environment environment;

	public Expression(Environment env) {
		this.environment = env;
	}

	@Override
	public AbstractValue visit(Add add) {
		AbstractValue left = add.getLeftHandSide().accept(this);
		AbstractValue right = add.getRightHandSide().accept(this);

		return left.add(right);
	}

	@Override
	public AbstractValue visit(And and) {
		AbstractValue left = and.getLeftHandSide().accept(this);
		AbstractValue right = and.getRightHandSide().accept(this);

		return left.and(right);
	}

	@Override
	public AbstractValue visit(Div div) {
		AbstractValue left = div.getLeftHandSide().accept(this);
		AbstractValue right = div.getRightHandSide().accept(this);

		return left.div(right);
	}

	@Override
	public AbstractValue visit(Eq eq) {
		AbstractValue left = eq.getLeftHandSide().accept(this);
		AbstractValue right = eq.getRightHandSide().accept(this);

		return left.eq(right);
	}

	@Override
	public AbstractValue visit(GEq geq) {
		AbstractValue left = geq.getLeftHandSide().accept(this);
		AbstractValue right = geq.getRightHandSide().accept(this);

		return left.geq(right);
	}

	@Override
	public AbstractValue visit(GT gt) {
		AbstractValue left = gt.getLeftHandSide().accept(this);
		AbstractValue right = gt.getRightHandSide().accept(this);

		return left.gt(right);
	}

	@Override
	public AbstractValue visit(LEq leq) {
		AbstractValue left = leq.getLeftHandSide().accept(this);
		AbstractValue right = leq.getRightHandSide().accept(this);

		return left.leq(right);
	}

	@Override
	public AbstractValue visit(LT lt) {
		AbstractValue left = lt.getLeftHandSide().accept(this);
		AbstractValue right = lt.getRightHandSide().accept(this);

		return left.lt(right);
	}

	@Override
	public AbstractValue visit(Mul mul) {
		AbstractValue left = mul.getLeftHandSide().accept(this);
		AbstractValue right = mul.getRightHandSide().accept(this);

		return left.mul(right);
	}

	@Override
	public AbstractValue visit(Neg neg) {
		AbstractValue value = neg.getExpression().accept(this);

		return value.neg();
	}

	@Override
	public AbstractValue visit(NEq neq) {
		AbstractValue left = neq.getLeftHandSide().accept(this);
		AbstractValue right = neq.getRightHandSide().accept(this);

		return left.neq(right);
	}

	@Override
	public AbstractValue visit(Not not) {
		AbstractValue value = not.getExpression().accept(this);

		return value.not();
	}

	@Override
	public AbstractValue visit(Or or) {
		AbstractValue left = or.getLeftHandSide().accept(this);
		AbstractValue right = or.getRightHandSide().accept(this);

		return left.or(right);
	}

	@Override
	public AbstractValue visit(Pos pos) {
		AbstractValue value = pos.getExpression().accept(this);

		return value.pos();
	}

	@Override
	public AbstractValue visit(Sub sub) {
		AbstractValue left = sub.getLeftHandSide().accept(this);
		AbstractValue right = sub.getRightHandSide().accept(this);

		return left.sub(right);
	}

	@Override
	public AbstractValue visit(org.uva.sea.ql.ast.expr.atom.Bool bool) {
		return new Bool(bool.getValue());
	}

	@Override
	public AbstractValue visit(Ident ident) {
		return this.environment.valueOfIdent(ident);
	}

	@Override
	public AbstractValue visit(org.uva.sea.ql.ast.expr.atom.Int intType) {
		return new Int(intType.getValue());
	}

	@Override
	public AbstractValue visit(org.uva.sea.ql.ast.expr.atom.Money money) {
		return new Money(money.getValue());
	}

	@Override
	public AbstractValue visit(org.uva.sea.ql.ast.expr.atom.String string) {
		return new String(string.getValue());
	}

}
