package org.uva.sea.ql.visitor;

import static julius.validation.Assertions.state;

import org.jpatterns.gof.VisitorPattern.Visitor;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.Computed;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IfStatement;
import org.uva.sea.ql.ast.Question;
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
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.ast.value.StringValue;
import org.uva.sea.ql.ast.value.Value;

@Visitor
public class TypeCheckVisitor extends AbstractBaseVisitor {

	@Override
	public void visit(final Question question) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(final Add add) {
		Value left = add.getLeft().evaluate();
		Value right = add.getRight().evaluate();

		state.assertTrue(IntegerValue.class == left.getClass(),
				"Left of expression is not as expected");
		state.assertTrue(IntegerValue.class == right.getClass(),
				"Right of expression is not as expected");

	}

	@Override
	public void visit(final And and) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final Divide divide) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final Equals equals) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final GreaterOrEquals greaterOrEquals) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final GreaterThan greaterThan) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final Multiply multiply) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final Negative negative) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final Not not) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final NotEquals notEquals) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final Or or) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final Positive positive) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final SmallerOrEquals smallerOrEquals) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final SmallerThan smallerThan) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final Substitute substitute) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final Identifier identifier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final Computed computed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final StringValue stringValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final IntegerValue integerValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final StringType stringType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final MoneyType moneyType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final IntegerType integerType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final BooleanType booleanType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final CompoundStatement compoundStatement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final IfStatement ifStatement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final Form form) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final BooleanValue booleanValue) {
		// TODO Auto-generated method stub

	}

}
