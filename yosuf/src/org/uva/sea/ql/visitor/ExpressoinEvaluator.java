package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.exp.Add;
import org.uva.sea.ql.ast.exp.And;
import org.uva.sea.ql.ast.exp.Divide;
import org.uva.sea.ql.ast.exp.Equals;
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
import org.uva.sea.ql.ast.value.Value;

public class ExpressoinEvaluator implements ValuableVisitor<Value> {

	@Override
	public Value visit(final Add add) {
		IntegerValue leftValue = (IntegerValue) add.getLeft().accept(this);
		IntegerValue rightValue = (IntegerValue) add.getRight().accept(this);

		return new IntegerValue(leftValue.getValue() + rightValue.getValue());
	}

	@Override
	public Value visit(final And and) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(final Divide divide) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(final Equals equals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(final GreaterOrEquals greaterOrEquals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(final GreaterThan greaterThan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(final Identifier identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(final Multiply multiply) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(final Negative negative) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(final Not not) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(final NotEquals notEquals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(final Or or) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(final Positive positive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(final SmallerOrEquals smallerOrEquals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(final SmallerThan smallerThan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(final Substitute substitute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(final IntegerValue integerValue) {
		return integerValue;
	}

	@Override
	public Value visit(final BooleanValue booleanValue) {
		return booleanValue;
	}

	@Override
	public Value visit(final StringValue stringValue) {
		return stringValue;
	}
}
