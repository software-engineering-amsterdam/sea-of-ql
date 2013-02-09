package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.exp.Add;
import org.uva.sea.ql.ast.exp.And;
import org.uva.sea.ql.ast.exp.Divide;
import org.uva.sea.ql.ast.exp.Equals;
import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.ast.exp.GreaterOrEquals;
import org.uva.sea.ql.ast.exp.GreaterThan;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.exp.Multiply;
import org.uva.sea.ql.ast.exp.Negative;
import org.uva.sea.ql.ast.exp.Not;
import org.uva.sea.ql.ast.exp.NotEquals;
import org.uva.sea.ql.ast.exp.Or;
import org.uva.sea.ql.ast.exp.Positive;
import org.uva.sea.ql.ast.exp.SmallerOrEquals;
import org.uva.sea.ql.ast.exp.SmallerThan;
import org.uva.sea.ql.ast.exp.Substitute;
import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.ast.value.StringValue;

public class ExpressoinEvaluator implements ValuableVisitor<Expression> {

	@Override
	public Expression visit(final Add add) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final IntegerValue integerValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final And and) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final Divide divide) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final Equals equals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final GreaterOrEquals greaterOrEquals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final BooleanValue booleanValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final StringValue stringValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final GreaterThan greaterThan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final Identifier identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final Multiply multiply) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final Negative negative) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final Not not) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final NotEquals notEquals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final Or or) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final Positive positive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final SmallerOrEquals smallerOrEquals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final SmallerThan smallerThan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visit(final Substitute substitute) {
		// TODO Auto-generated method stub
		return null;
	}

}
