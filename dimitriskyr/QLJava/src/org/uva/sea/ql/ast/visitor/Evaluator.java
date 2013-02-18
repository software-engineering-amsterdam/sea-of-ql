package org.uva.sea.ql.ast.visitor;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.Value;
import org.uva.sea.ql.ast.expressions.Add;
import org.uva.sea.ql.ast.expressions.And;
import org.uva.sea.ql.ast.expressions.Div;
import org.uva.sea.ql.ast.expressions.Eq;
import org.uva.sea.ql.ast.expressions.GEq;
import org.uva.sea.ql.ast.expressions.GT;
import org.uva.sea.ql.ast.expressions.LEq;
import org.uva.sea.ql.ast.expressions.LT;
import org.uva.sea.ql.ast.expressions.Mul;
import org.uva.sea.ql.ast.expressions.NEq;
import org.uva.sea.ql.ast.expressions.Neg;
import org.uva.sea.ql.ast.expressions.Not;
import org.uva.sea.ql.ast.expressions.Or;
import org.uva.sea.ql.ast.expressions.Pos;
import org.uva.sea.ql.ast.expressions.Sub;
import org.uva.sea.ql.ast.values.Bool;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.Money;
import org.uva.sea.ql.ast.values.String_lit;

public class Evaluator implements ICheckExprVisitor<Value> {

	private final Map <Ident, Value> env;
	
	public Evaluator( Map <Ident,Value> env) {
		this.env= Collections.unmodifiableMap(env);
	}
	
	@Override
	public Value visit(Add add) {
		Value left=add.getLhs().accept(this);
		Value right=add.getRhs().accept(this);
		return left.add(right);
	}

	@Override
	public Value visit(And and) {
		Value left=and.getLhs().accept(this);
		Value right=and.getRhs().accept(this);
		return left.and(right);
	}

	@Override
	public Value visit(Div div) {
		Value left=div.getLhs().accept(this);
		Value right=div.getRhs().accept(this);
		return left.div(right);
	}

	@Override
	public Value visit(Eq eq) {
		Value left=eq.getLhs().accept(this);
		Value right=eq.getRhs().accept(this);
		return left.eq(right);
	}

	@Override
	public Value visit(GEq geq) {
		Value left=geq.getLhs().accept(this);
		Value right=geq.getRhs().accept(this);
		return left.geq(right);
	}

	@Override
	public Value visit(GT gt) {
		Value left=gt.getLhs().accept(this);
		Value right=gt.getRhs().accept(this);
		return left.gt(right);
	}

	@Override
	public Value visit(LEq leq) {
		Value left=leq.getLhs().accept(this);
		Value right=leq.getRhs().accept(this);
		return left.leq(right);
	}

	@Override
	public Value visit(LT lt) {
		Value left=lt.getLhs().accept(this);
		Value right=lt.getRhs().accept(this);
		return left.lt(right);
	}

	@Override
	public Value visit(Mul mul) {
		Value left=mul.getLhs().accept(this);
		Value right=mul.getRhs().accept(this);
		return left.mul(right);
	}

	@Override
	public Value visit(Neg neg) {
		Value val=neg.getValue().accept(this);
		return val.neg();
	}

	@Override
	public Value visit(NEq neq) {
		Value left=neq.getLhs().accept(this);
		Value right=neq.getRhs().accept(this);
		return left.neq(right);
	}

	@Override
	public Value visit(Not not) {
		Value val=not.getValue().accept(this);
		return val.pos();
	}

	@Override
	public Value visit(Or or) {
		Value left=or.getLhs().accept(this);
		Value right=or.getRhs().accept(this);
		return left.or(right);
	}

	@Override
	public Value visit(Pos pos) {
		Value val=pos.getValue().accept(this);
		return val.pos();
	}

	@Override
	public Value visit(Sub sub) {
		Value left=sub.getLhs().accept(this);
		Value right=sub.getRhs().accept(this);
		return left.sub(right);
	}

	@Override
	public Value visit(Ident ident) {
		if (env.containsKey(ident)) {
			return env.get(ident);
			}
			return Undefined.UNDEF;
	}
	
	@Override
	public Value visit(Bool bool) {
		return new Bool(bool.getValue());
	}

	@Override
	public Value visit(Int integer) {
		return new Int(integer.getValue());
	}

	@Override
	public Value visit(String_lit string_lit) {
		return new String_lit(string_lit.getValue());
	}

	@Override
	public Value visit(Money money) {
		return new Money(money.getValue());
	}

}
