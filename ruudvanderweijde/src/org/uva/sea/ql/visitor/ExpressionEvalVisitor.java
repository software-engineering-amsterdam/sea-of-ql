package org.uva.sea.ql.visitor;

import java.util.Collections;
import java.util.Map;

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
import org.uva.sea.ql.ast.expr.primary.Bool;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.expr.primary.Int;
import org.uva.sea.ql.ast.expr.primary.StringLiteral;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.StringValue;
import org.uva.sea.ql.value.UndefinedValue;
import org.uva.sea.ql.value.Value;

public class ExpressionEvalVisitor implements IExpressionVisitor<Value> {
	private final Map<Ident, Value> valueEnv;

	public ExpressionEvalVisitor(Map<Ident, Value> valueEnv) {
		this.valueEnv = Collections.unmodifiableMap(valueEnv);
	}

	public Value visit(Add exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.add(r);
	}

	@Override
	public Value visit(And ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Div ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Eq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(GEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(GT ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(LEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(LT ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Mul ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(NEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Or ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Sub ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Neg ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Not ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Pos ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Bool ast) {
		return new BooleanValue(ast.getValue());
	}

	@Override
	public Value visit(Ident ast) {
		if (valueEnv.containsKey(ast)) {
			return valueEnv.get(ast);
		}
		return new UndefinedValue();
	}
	
	@Override
	public Value visit(Int ast) {
		return new IntegerValue(ast.getValue());
	}

	@Override
	public Value visit(StringLiteral ast) {
		return new StringValue(ast.getValue());
	}
}
