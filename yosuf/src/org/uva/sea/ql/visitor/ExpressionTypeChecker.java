package org.uva.sea.ql.visitor;

import static julius.validation.Assertions.checked;

import java.util.ArrayList;
import java.util.List;

import julius.validation.ValidationException;

import org.jpatterns.gof.VisitorPattern.Visitor;
import org.uva.sea.ql.ast.Natural;
import org.uva.sea.ql.ast.exp.Add;
import org.uva.sea.ql.ast.exp.And;
import org.uva.sea.ql.ast.exp.Divide;
import org.uva.sea.ql.ast.exp.Equals;
import org.uva.sea.ql.ast.exp.Expression.Nature;
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

@Visitor
public class ExpressionTypeChecker implements NaturalVisitor<Natural> {

	private final List<TypeCheckException> typeErrors;

	public ExpressionTypeChecker() {
		typeErrors = new ArrayList<TypeCheckException>();
	}

	public List<TypeCheckException> getTypeErrors() {
		return typeErrors;
	}

	@Override
	public Natural visit(final Add add) {
		assertNumeric(add.getRight().accept(this));
		assertNumeric(add.getLeft().accept(this));

		return add;
	}

	@Override
	public Natural visit(final IntegerValue integerValue) {
		return integerValue;
	}

	@Override
	public Natural visit(final And and) {
		assertBoolean(and.getLeft().accept(this));
		assertBoolean(and.getRight().accept(this));

		return and;
	}

	@Override
	public Natural visit(final Divide divide) {
		assertNumeric(divide.getRight().accept(this));
		assertNumeric(divide.getLeft().accept(this));

		return divide;
	}

	@Override
	public Natural visit(final Equals equals) {
		// Only numeric equals supported right now.
		assertNumeric(equals.getRight().accept(this));
		assertNumeric(equals.getLeft().accept(this));

		return equals;
	}

	@Override
	public Natural visit(final GreaterOrEquals greaterOrEquals) {
		assertNumeric(greaterOrEquals.getRight().accept(this));
		assertNumeric(greaterOrEquals.getLeft().accept(this));

		return greaterOrEquals;
	}

	@Override
	public Natural visit(final BooleanValue booleanValue) {
		return booleanValue;
	}

	@Override
	public Natural visit(final StringValue stringValue) {
		return stringValue;
	}

	@Override
	public Natural visit(final GreaterThan greaterThan) {
		assertNumeric(greaterThan.getRight().accept(this));
		assertNumeric(greaterThan.getLeft().accept(this));

		return greaterThan;
	}

	@Override
	public Natural visit(final Identifier identifier) {
		return identifier;
	}

	@Override
	public Natural visit(final Multiply multiply) {

		assertNumeric(multiply.getRight().accept(this));
		assertNumeric(multiply.getLeft().accept(this));

		return multiply;
	}

	@Override
	public Natural visit(final Negative negative) {
		assertNumeric(negative.getOperation());

		return negative;
	}

	@Override
	public Natural visit(final Not not) {
		assertBoolean(not.getOperation().accept(this));

		return not;
	}

	@Override
	public Natural visit(final NotEquals notEquals) {
		assertNumeric(notEquals.getRight().accept(this));
		assertNumeric(notEquals.getLeft().accept(this));

		return notEquals;
	}

	@Override
	public Natural visit(final Or or) {

		assertBoolean(or.getRight().accept(this));
		assertBoolean(or.getLeft().accept(this));

		return or;
	}

	@Override
	public Natural visit(final Positive positive) {
		assertNumeric(positive.getOperation().accept(this));

		return positive;
	}

	@Override
	public Natural visit(final SmallerOrEquals smallerOrEquals) {
		assertNumeric(smallerOrEquals.getRight().accept(this));
		assertNumeric(smallerOrEquals.getLeft().accept(this));

		return smallerOrEquals;
	}

	@Override
	public Natural visit(final SmallerThan smallerThan) {

		assertNumeric(smallerThan.getRight().accept(this));
		assertNumeric(smallerThan.getLeft().accept(this));

		return smallerThan;
	}

	@Override
	public Natural visit(final Substitute substitute) {

		assertNumeric(substitute.getRight().accept(this));
		assertNumeric(substitute.getLeft().accept(this));

		return substitute;
	}

	private void assertNumeric(final Natural natural) {
		assertNature(natural, Nature.NUMERIC);
	}

	private void assertBoolean(final Natural natural) {
		assertNature(natural, Nature.BOOLEAN);
	}

	private void assertNature(final Natural natural, final Nature nature) {
		try {
			checked.assertTrue(nature == natural.getNature(), "A " + nature
					+ " is incompatible with " + natural);
		} catch (ValidationException e) {
			typeErrors.add(new TypeCheckException("A " + nature
					+ " is incompatible with " + natural, e));
		}
	}

	@Override
	public Natural visit(final BooleanType booleanType) {
		return booleanType;
	}

	@Override
	public Natural visit(final IntegerType integerType) {
		return integerType;
	}

	@Override
	public Natural visit(final MoneyType moneyType) {
		return moneyType;
	}

	@Override
	public Natural visit(final StringType stringType) {
		return stringType;
	}

}
