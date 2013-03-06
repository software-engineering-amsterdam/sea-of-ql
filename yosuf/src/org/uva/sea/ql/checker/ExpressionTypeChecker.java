package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.jpatterns.gof.VisitorPattern.Visitor;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.exp.Add;
import org.uva.sea.ql.ast.exp.And;
import org.uva.sea.ql.ast.exp.Bools;
import org.uva.sea.ql.ast.exp.Divide;
import org.uva.sea.ql.ast.exp.Equals;
import org.uva.sea.ql.ast.exp.GreaterOrEquals;
import org.uva.sea.ql.ast.exp.GreaterThan;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.exp.Multiply;
import org.uva.sea.ql.ast.exp.Negative;
import org.uva.sea.ql.ast.exp.Not;
import org.uva.sea.ql.ast.exp.NotEquals;
import org.uva.sea.ql.ast.exp.Numeric;
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
import org.uva.sea.ql.ast.value.NumericValue;
import org.uva.sea.ql.ast.value.StringValue;

/**
 * Use {@link #isValid()} and {@link #getTypeErrors()} to validate at the end.
 */
@Visitor
public class ExpressionTypeChecker implements TypeCheckerVisitor<Type> {

	private final List<TypeCheckError> typeErrors;
	private final Map<Identifier, Type> environment;

	public ExpressionTypeChecker(final Map<Identifier, Type> environment) {
		typeErrors = new ArrayList<TypeCheckError>();
		this.environment = environment;
	}

	@Override
	public Type visit(final Add add) {
		checkNumeric(add.getRight().accept(this));
		checkNumeric(add.getLeft().accept(this));

		return add.getType();
	}

	@Override
	public Type visit(final NumericValue integerValue) {
		return integerValue.getType();
	}

	@Override
	public Type visit(final And and) {
		checkBoolean(and.getLeft().accept(this));
		checkBoolean(and.getRight().accept(this));

		return and.getType();
	}

	@Override
	public Type visit(final Divide divide) {
		checkNumeric(divide.getRight().accept(this));
		checkNumeric(divide.getLeft().accept(this));

		return divide.getType();
	}

	@Override
	public Type visit(final Equals equals) {
		// Only numeric equals supported right now.
		checkNumeric(equals.getRight().accept(this));
		checkNumeric(equals.getLeft().accept(this));

		return equals.getType();
	}

	@Override
	public Type visit(final GreaterOrEquals greaterOrEquals) {
		checkNumeric(greaterOrEquals.getRight().accept(this));
		checkNumeric(greaterOrEquals.getLeft().accept(this));

		return greaterOrEquals.getType();
	}

	@Override
	public Type visit(final BooleanValue booleanValue) {
		return booleanValue.getType();
	}

	@Override
	public Type visit(final StringValue stringValue) {
		return stringValue.getType();
	}

	@Override
	public Type visit(final GreaterThan greaterThan) {
		checkNumeric(greaterThan.getRight().accept(this));
		checkNumeric(greaterThan.getLeft().accept(this));

		return greaterThan.getType();
	}

	@Override
	public Type visit(final Identifier identifier) {
		if (environment.get(identifier) == null) {
			return identifier.getType();
		} else {
			return environment.get(identifier);
		}
	}

	@Override
	public Type visit(final Multiply multiply) {

		checkNumeric(multiply.getRight().accept(this));
		checkNumeric(multiply.getLeft().accept(this));

		return multiply.getType();
	}

	@Override
	public Type visit(final Negative negative) {
		checkNumeric(negative.getOperation().accept(this));

		return negative.getType();
	}

	@Override
	public Type visit(final Not not) {
		checkBoolean(not.getOperation().accept(this));

		return not.getType();
	}

	@Override
	public Type visit(final NotEquals notEquals) {
		checkNumeric(notEquals.getRight().accept(this));
		checkNumeric(notEquals.getLeft().accept(this));

		return notEquals.getType();
	}

	@Override
	public Type visit(final Or or) {

		checkBoolean(or.getRight().accept(this));
		checkBoolean(or.getLeft().accept(this));

		return or.getType();
	}

	@Override
	public Type visit(final Positive positive) {
		checkNumeric(positive.getOperation().accept(this));

		return positive.getType();
	}

	@Override
	public Type visit(final SmallerOrEquals smallerOrEquals) {
		checkNumeric(smallerOrEquals.getRight().accept(this));
		checkNumeric(smallerOrEquals.getLeft().accept(this));

		return smallerOrEquals.getType();
	}

	@Override
	public Type visit(final SmallerThan smallerThan) {

		checkNumeric(smallerThan.getRight().accept(this));
		checkNumeric(smallerThan.getLeft().accept(this));

		return smallerThan.getType();
	}

	@Override
	public Type visit(final Substitute substitute) {

		checkNumeric(substitute.getRight().accept(this));
		checkNumeric(substitute.getLeft().accept(this));

		return substitute.getType();
	}

	private void checkNumeric(final Type type) {
		checkType(type, new Numeric());
	}

	private void checkBoolean(final Type type) {
		checkType(type, new Bools());
	}

	private void checkType(final Type type1, final Type type2) {
		if (!type1.equals(type2)) {
			typeErrors.add(new TypeCheckError(type2 + " is incompatible with " + type1));
		}
	}

	@Override
	public Type visit(final BooleanType booleanType) {
		return booleanType.getType();
	}

	@Override
	public Type visit(final IntegerType integerType) {
		return integerType.getType();
	}

	@Override
	public Type visit(final MoneyType moneyType) {
		return moneyType.getType();
	}

	@Override
	public Type visit(final StringType stringType) {
		return stringType.getType();
	}

	/**
	 * 
	 * @return type errors
	 */
	public Collection<TypeCheckError> getTypeErrors() {
		return new ArrayList<TypeCheckError>(typeErrors);
	}

	/**
	 * 
	 * @return true if no errors were found after the checking. It is otherwise always true if
	 *         checking has not started yet.
	 */
	public boolean isValid() {
		return typeErrors.isEmpty();
	}

}
