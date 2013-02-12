package org.uva.sea.ql.visitor;

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

public class ExpressionRenderer<T> implements IExpressionVisitor<T> {

	@Override
	public T visit(Add ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(And ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(Div ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(Eq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(GEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(GT ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(LEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(LT ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(Mul ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(NEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(Or ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(Sub ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(Neg ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(Not ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(Pos ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(Bool ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(Int ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(StringLiteral ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(Ident ast) {
		// TODO Auto-generated method stub
		return null;
	}

}
