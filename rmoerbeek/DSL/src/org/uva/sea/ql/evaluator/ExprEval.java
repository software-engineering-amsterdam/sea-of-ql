package org.uva.sea.ql.evaluator;

import java.util.Collections;
import java.util.Map;

import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.Bool;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Int;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.NEq;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.Str;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.visitors.ExpressionVisitor;
import org.uva.sea.ql.evaluator.values.*;

public class ExprEval implements ExpressionVisitor<Value> {
	
	private final Map<Ident, Value> env;
	
	public ExprEval(Map<Ident, Value> env) {
		this.env = Collections.unmodifiableMap(env);
	}

	@Override
	public Value visit(Add ast) {
		Value l = ast.getLhs().accept(this);
		Value r = ast.getRhs().accept(this);
		return l.add(r);
	}

	@Override
	public Value visit(And ast) {
		Value l = ast.getLhs().accept(this);
		Value r = ast.getRhs().accept(this);
		return l.and(r);
	}

	@Override
	public Value visit(Bool ast) {
		return new BoolValue(ast.getValue());
	}

	@Override
	public Value visit(Div ast) {
		Value l = ast.getLhs().accept(this);
		Value r = ast.getRhs().accept(this);
		return l.div(r);
	}

	@Override
	public Value visit(Eq ast) {
		Value l = ast.getLhs().accept(this);
		Value r = ast.getRhs().accept(this);
		return l.eq(r);
	}

	@Override
	public Value visit(GT ast) {
		Value l = ast.getLhs().accept(this);
		Value r = ast.getRhs().accept(this);
		return l.gt(r);
	}

	@Override
	public Value visit(GEq ast) {
		Value l = ast.getLhs().accept(this);
		Value r = ast.getRhs().accept(this);
		return l.geq(r);
	}

	//@Override
	//public Value visit(Ident ast) {
	//	if (env.containsKey(ast)) {
	//		return env.get(ast);
	//	}
	//	return new UndefinedValue();
	//}


	@Override
	public Value visit(Ident exp) {
		for (Ident id : env.keySet()) {
			if (id.getValue().equals(exp.getValue())) {
				return env.get(id);
			}
		}
		return new UndefinedValue();
	}
	
	@Override
	public Value visit(Int ast) {
		return new IntValue(ast.getValue());
	}

	@Override
	public Value visit(LEq ast) {
		Value l = ast.getLhs().accept(this);
		Value r = ast.getRhs().accept(this);
		return l.leq(r);
	}

	@Override
	public Value visit(LT ast) {
		Value l = ast.getLhs().accept(this);
		Value r = ast.getRhs().accept(this);
		return l.lt(r);
	}

	@Override
	public Value visit(Mul ast) {
		Value l = ast.getLhs().accept(this);
		Value r = ast.getRhs().accept(this);
		return l.mul(r);
	}

	@Override
	public Value visit(Neg ast) {
		Value op = ast.getOp().accept(this);
		return op.neg();
	}

	@Override
	public Value visit(NEq ast) {
		Value l = ast.getLhs().accept(this);
		Value r = ast.getRhs().accept(this);
		return l.neq(r);
	}

	@Override
	public Value visit(Not ast) {
		Value op = ast.getOp().accept(this);
		return op.not();
	}

	@Override
	public Value visit(Or ast) {
		Value l = ast.getLhs().accept(this);
		Value r = ast.getRhs().accept(this);
		return l.or(r);
	}

	@Override
	public Value visit(Pos ast) {
		Value op = ast.getOp().accept(this);
		return op.pos();
	}

	@Override
	public Value visit(Str ast) {
		return new StringValue(ast.getValue());
	}

	@Override
	public Value visit(Sub ast) {
		Value l = ast.getLhs().accept(this);
		Value r = ast.getRhs().accept(this);
		return l.sub(r);
	}

}
