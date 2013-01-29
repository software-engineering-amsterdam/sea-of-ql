package org.uva.sea.ql.evaluation;

import org.uva.sea.ql.ast.expressions.Add;
import org.uva.sea.ql.ast.expressions.And;
import org.uva.sea.ql.ast.expressions.BooleanLiteral;
import org.uva.sea.ql.ast.expressions.Div;
import org.uva.sea.ql.ast.expressions.Eq;
import org.uva.sea.ql.ast.expressions.ExprVisitor;
import org.uva.sea.ql.ast.expressions.GEq;
import org.uva.sea.ql.ast.expressions.GT;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.expressions.Int;
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
import org.uva.sea.ql.evaluation.values.Value;

public class ExprEvaluationVisitor implements ExprVisitor<Value> {

	@Override
	public Value visit(StringLiteral stringLiteral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Add add) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(And and) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Div div) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Eq eq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(GEq gEq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(GT gt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Ident ident) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Int int1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(LEq lEq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(LT lt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Mul mul) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Neg neg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(NEq nEq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Not not) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Or or) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Pos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Sub sub) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(BooleanLiteral booleanLiteral) {
		// TODO Auto-generated method stub
		return null;
	}

}
