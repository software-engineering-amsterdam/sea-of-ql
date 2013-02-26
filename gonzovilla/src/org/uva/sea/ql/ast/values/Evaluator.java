package org.uva.sea.ql.ast.values;

import java.util.Collections;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.visitor.VisitorExpressions;

public class Evaluator implements VisitorExpressions<Value> {
	
	private final Map<String, Value> env;
	
	public Evaluator(Map<String, Value> env) {
		this.env = Collections.unmodifiableMap(env);
	}
	
	public Value evaluate(Expr expr, Map<String, Value> env) {
		return expr.accept(this);
	}

	@Override
	public Value visit(Add add) {
		Value l = add.getLeft().accept(this);
		Value r = add.getRight().accept(this);
		return l.add(r);
	}

	@Override
	public Value visit(And and) {
		Value l = and.getLeft().accept(this);
		Value r = and.getRight().accept(this);
		return l.and(r);
	}

	@Override
	public Value visit(Div div) {
		Value l = div.getLeft().accept(this);
		Value r = div.getRight().accept(this);
		return l.div(r);
	}

	@Override
	public Value visit(Eq eq) {
		Value l = eq.getLeft().accept(this);
		Value r = eq.getRight().accept(this);
		return l.eq(r);
	}

	@Override
	public Value visit(GEq geq) {
		Value l = geq.getLeft().accept(this);
		Value r = geq.getRight().accept(this);
		return l.geq(r);
	}

	@Override
	public Value visit(GT gt) {
		Value l = gt.getLeft().accept(this);
		Value r = gt.getRight().accept(this);
		return l.gt(r);
	}

	@Override
	public Value visit(LEq leq) {
		Value l = leq.getLeft().accept(this);
		Value r = leq.getRight().accept(this);
		return l.leq(r);
	}

	@Override
	public Value visit(LT lt) {
		Value l = lt.getLeft().accept(this);
		Value r = lt.getRight().accept(this);
		return l.lt(r);
	}

	@Override
	public Value visit(Mul mul) {
		Value l = mul.getLeft().accept(this);
		Value r = mul.getRight().accept(this);
		return l.mul(r);
	}

	@Override
	public Value visit(Neg neg) {
		Value value = neg.getExpression().accept(this);
		return value.neg();
	}

	@Override
	public Value visit(NEq neq) {
		Value l = neq.getLeft().accept(this);
		Value r = neq.getRight().accept(this);
		return l.neq(r);
	}

	@Override
	public Value visit(Not not) {
		Value value = not.getExpression().accept(this);
		return value.not();
	}

	@Override
	public Value visit(Or or) {
		Value l = or.getLeft().accept(this);
		Value r = or.getRight().accept(this);
		return l.or(r);
	}

	@Override
	public Value visit(Pos pos) {
		Value value = pos.getExpression().accept(this);
		return value.pos();
	}

	@Override
	public Value visit(Sub sub) {
		Value l = sub.getLeft().accept(this);
		Value r = sub.getRight().accept(this);
		return l.sub(r);
	}

	@Override
	public Value visit(Ident ident) {
		if (env.containsKey(ident.getName())) {
			return env.get(ident.getName());
			}
			return null;
	}

	@Override
	public Value visit(BoolValue bool) {
		return new BoolValue(bool.getValue());
	}

	@Override
	public Value visit(Int integer) {
		return new Int(integer.getValue());
	}

	@Override
	public Value visit(StringValue stringValue) {
		return new StringValue(stringValue.getValue());
	}
}
