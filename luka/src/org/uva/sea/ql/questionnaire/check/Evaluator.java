package org.uva.sea.ql.questionnaire.check;

import java.util.Collections;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
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
import org.uva.sea.ql.ast.nodes.values.Bool;
import org.uva.sea.ql.ast.nodes.values.Doub;
import org.uva.sea.ql.ast.nodes.values.Int;
import org.uva.sea.ql.ast.nodes.values.Money;
import org.uva.sea.ql.ast.nodes.values.Str;
import org.uva.sea.ql.ast.nodes.values.UndefinedValue;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Evaluator implements Visitor<Value> {

	private final Map<Ident, Value> env;

	// evaluates if expression is true or not
	public Evaluator(Map<Ident, Value> env) {
		this.env = Collections.unmodifiableMap(env);
	}

	@Override
	public Value visit(Ident var) {
		if (this.env.containsKey(var)) {
			return this.env.get(var);
		}
		return new UndefinedValue();
	}

	// VALUES
	@Override
	public Value visit(Bool bool) {
		return bool;
	}

	@Override
	public Value visit(Str str) {
		return str;
	}

	@Override
	public Value visit(Money mon) {
		return mon;
	}

	@Override
	public Value visit(Int i) {
		return i;
	}

	@Override
	public Value visit(Doub i) {
		return i;
	}

	// OPERATIONS
	@Override
	public Value visit(Mul exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.mul(r);
	}

	@Override
	public Value visit(Add exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.add(r);
	}

	@Override
	public Value visit(And exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.and(r);
	}

	@Override
	public Value visit(Div exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.div(r);
	}

	@Override
	public Value visit(Eq exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.equ(r);
	}

	@Override
	public Value visit(GEq exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.gEq(r);
	}

	@Override
	public Value visit(GT exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.gt(r);
	}

	@Override
	public Value visit(LEq exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.lEq(r);
	}

	@Override
	public Value visit(LT exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.lt(r);
	}

	@Override
	public Value visit(Neg exp) {
		Value l = exp.getExpr().accept(this);
		return l.neg();
	}

	@Override
	public Value visit(NEq exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.nEqu(r);
	}

	@Override
	public Value visit(Not exp) {
		Value l = exp.getExpr().accept(this);
		return l.not();
	}

	@Override
	public Value visit(Or exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.or(r);
	}

	@Override
	public Value visit(Pos exp) {
		Value l = exp.getExpr().accept(this);
		return l.pos();
	}

	@Override
	public Value visit(Sub exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.sub(r);
	}

}
