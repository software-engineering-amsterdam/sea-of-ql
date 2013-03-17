package org.uva.sea.ql.visitor;

import java.util.Collections;
import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Primary;
import org.uva.sea.ql.ast.alg.Add;
import org.uva.sea.ql.ast.alg.And;
import org.uva.sea.ql.ast.alg.Bool;
import org.uva.sea.ql.ast.alg.Div;
import org.uva.sea.ql.ast.alg.Eq;
import org.uva.sea.ql.ast.alg.GEq;
import org.uva.sea.ql.ast.alg.GT;
import org.uva.sea.ql.ast.alg.Int;
import org.uva.sea.ql.ast.alg.LEq;
import org.uva.sea.ql.ast.alg.LT;
import org.uva.sea.ql.ast.alg.Money;
import org.uva.sea.ql.ast.alg.Mul;
import org.uva.sea.ql.ast.alg.NEq;
import org.uva.sea.ql.ast.alg.Neg;
import org.uva.sea.ql.ast.alg.Not;
import org.uva.sea.ql.ast.alg.Or;
import org.uva.sea.ql.ast.alg.Pos;
import org.uva.sea.ql.ast.alg.Str;
import org.uva.sea.ql.ast.alg.Sub;
import org.uva.sea.ql.gen.Undefined;

public class Eval implements AlgebricElementVisitor<Value> {
	private final Map<Ident, Value> env;

	public Eval(Map<Ident, Value> env) {
		this.env = Collections.unmodifiableMap(env);
	}

	@Override
	public Value visit(Add add) {
		Value l = add.getLhs().accept(this);
		Value r = add.getRhs().accept(this);
		return l.add(r);
	}

	@Override
	public Value visit(And and) {
		return null;
	}

	@Override
	public Value visit(Div div) {
		Value l = div.getLhs().accept(this);
		Value r = div.getRhs().accept(this);
		return l.div(r);
	}

	@Override
	public Value visit(Eq eq) {
		Value l = eq.getLhs().accept(this);
		Value r = eq.getRhs().accept(this);
		return l.equals(r);
	}

	@Override
	public Value visit(GEq geq) {
		return null;
	}

	@Override
	public Value visit(GT gt) {
		return null;
	}

	@Override
	public Value visit(Int val) {
		return null;
	}

	@Override
	public Value visit(LEq leq) {
		return null;
	}

	@Override
	public Value visit(LT lt) {
		return null;
	}

	@Override
	public Value visit(Mul mul) {
		Value l = mul.getLhs().accept(this);
		Value r = mul.getRhs().accept(this);
		return l.mul(r);
	}

	@Override
	public Value visit(Neg neg) {
		return null;
	}

	@Override
	public Value visit(NEq neq) {
		return null;
	}

	@Override
	public Value visit(Not not) {
		return null;
	}

	@Override
	public Value visit(Or or) {
		return null;
	}

	@Override
	public Value visit(Pos pos) {
		return null;
	}

	@Override
	public Value visit(Sub sub) {
		Value l = sub.getLhs().accept(this);
		Value r = sub.getRhs().accept(this);
		return l.sub(r);
	}

	@Override
	public Value visit(Ident var) {
		if (env.containsKey(var)) {
			return env.get(var);
		}
		return Undefined.UNDEF;
	}

	@Override
	public Value visit(Primary ast) {
		return null;
	}

	@Override
	public Value visit(Bool bool) {
		return null;
	}

	@Override
	public Value visit(Str str) {
		return null;
	}

	@Override
	public Value visit(Money money) {
		return null;
	}

}
