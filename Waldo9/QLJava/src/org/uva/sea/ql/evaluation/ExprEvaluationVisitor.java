package org.uva.sea.ql.evaluation;

import java.util.Collections;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Add;
import org.uva.sea.ql.ast.expressions.And;
import org.uva.sea.ql.ast.expressions.BooleanLiteral;
import org.uva.sea.ql.ast.expressions.Div;
import org.uva.sea.ql.ast.expressions.Eq;
import org.uva.sea.ql.ast.expressions.ExprVisitor;
import org.uva.sea.ql.ast.expressions.GEq;
import org.uva.sea.ql.ast.expressions.GT;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.expressions.LEq;
import org.uva.sea.ql.ast.expressions.LT;
import org.uva.sea.ql.ast.expressions.Mul;
import org.uva.sea.ql.ast.expressions.NEq;
import org.uva.sea.ql.ast.expressions.Neg;
import org.uva.sea.ql.ast.expressions.Not;
import org.uva.sea.ql.ast.expressions.Or;
import org.uva.sea.ql.ast.expressions.Pos;
import org.uva.sea.ql.ast.expressions.StringLiteral;
import org.uva.sea.ql.ast.expressions.Sub;
import org.uva.sea.ql.evaluation.values.Bool;
import org.uva.sea.ql.evaluation.values.Int;
import org.uva.sea.ql.evaluation.values.String;
import org.uva.sea.ql.evaluation.values.Value;

public class ExprEvaluationVisitor implements ExprVisitor<Value> {
	
	private final Map<Ident, Value> identifierEnvironment;
	
	public ExprEvaluationVisitor(Map<Ident, Value> identifierEnvironment) {
		this.identifierEnvironment = Collections.unmodifiableMap(identifierEnvironment);
	}

	@Override
	public Value visit(StringLiteral stringLiteral) {
		return new String(stringLiteral.getValue());
	}

	@Override
	public Value visit(Add add) {
		Value lhs = add.getLhs().accept(this);
		Value rhs = add.getRhs().accept(this);
		return new Int(((Int)lhs).getValue() + ((Int)rhs).getValue());
	}

	@Override
	public Value visit(And and) {
		Value lhs = and.getLhs().accept(this);
		Value rhs = and.getRhs().accept(this);
		return new Bool(((Bool)lhs).getValue() && ((Bool)rhs).getValue());
	}

	@Override
	public Value visit(Div div) {
		Value lhs = div.getLhs().accept(this);
		Value rhs = div.getRhs().accept(this);
		return new Int(((Int)lhs).getValue() / ((Int)rhs).getValue());
	}

	@Override
	public Value visit(Eq eq) {
		Value lhs = eq.getLhs().accept(this);
		Value rhs = eq.getRhs().accept(this);		
		return new Bool(((Value)lhs).getValue().equals(((Value)rhs).getValue()));
	}

	@Override
	public Value visit(GEq gEq) {
		Value lhs = gEq.getLhs().accept(this);
		Value rhs = gEq.getRhs().accept(this);
		return new Bool(((Int)lhs).getValue() >= ((Int)rhs).getValue());
	}

	@Override
	public Value visit(GT gt) {
		Value lhs = gt.getLhs().accept(this);
		Value rhs = gt.getRhs().accept(this);
		return new Bool(((Int)lhs).getValue() >= ((Int)rhs).getValue());
	}

	@Override
	public Value visit(Ident ident) {
		return identifierEnvironment.get(ident);
	}

	@Override
	public Value visit(org.uva.sea.ql.ast.expressions.Int int1) {
		return new Int(int1.getValue());
	}

	@Override
	public Value visit(LEq lEq) {
		Value lhs = lEq.getLhs().accept(this);
		Value rhs = lEq.getRhs().accept(this);
		return new Bool(((Int)lhs).getValue() <= ((Int)rhs).getValue());
	}

	@Override
	public Value visit(LT lt) {
		Value lhs = lt.getLhs().accept(this);
		Value rhs = lt.getRhs().accept(this);
		return new Bool(((Int)lhs).getValue() < ((Int)rhs).getValue());
	}

	@Override
	public Value visit(Mul mul) {
		Value lhs = mul.getLhs().accept(this);
		Value rhs = mul.getRhs().accept(this);
		return new Int(((Int)lhs).getValue() * ((Int)rhs).getValue());
	}

	@Override
	public Value visit(Neg neg) {
		Value value = neg.getLhs().accept(this);
		return new Int(-((Int)value).getValue());
	}

	@Override
	public Value visit(NEq nEq) {
		Value lhs = nEq.getLhs().accept(this);
		Value rhs = nEq.getRhs().accept(this);		
		return new Bool(!((Value)lhs).getValue().equals(((Value)rhs).getValue()));
	}

	@Override
	public Value visit(Not not) {
		Value value = not.getLhs().accept(this);
		return new Bool(!((Bool)value).getValue());
	}

	@Override
	public Value visit(Or or) {
		Value lhs = or.getLhs().accept(this);
		Value rhs = or.getRhs().accept(this);
		return new Bool(((Bool)lhs).getValue() || ((Bool)rhs).getValue());
	}

	@Override
	public Value visit(Pos pos) {
		Value value = pos.getLhs().accept(this);
		return new Int(((Int)value).getValue());
	}

	@Override
	public Value visit(Sub sub) {
		Value lhs = sub.getLhs().accept(this);
		Value rhs = sub.getRhs().accept(this);
		return new Int(((Int)lhs).getValue() - ((Int)rhs).getValue());
	}

	@Override
	public Value visit(BooleanLiteral booleanLiteral) {
		return new Bool(booleanLiteral.getValue());
	}

}
