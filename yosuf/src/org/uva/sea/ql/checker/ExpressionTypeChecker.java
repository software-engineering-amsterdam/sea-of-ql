package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.jpatterns.gof.VisitorPattern.Visitor;
import org.uva.sea.ql.ast.Natural;
import org.uva.sea.ql.ast.exp.Add;
import org.uva.sea.ql.ast.exp.And;
import org.uva.sea.ql.ast.exp.Bools;
import org.uva.sea.ql.ast.exp.Divide;
import org.uva.sea.ql.ast.exp.Equals;
import org.uva.sea.ql.ast.exp.ExpressionVisitor;
import org.uva.sea.ql.ast.exp.GreaterOrEquals;
import org.uva.sea.ql.ast.exp.GreaterThan;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.exp.Multiply;
import org.uva.sea.ql.ast.exp.Nature;
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
import org.uva.sea.ql.ast.type.DataTypeVisitor;
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
public class ExpressionTypeChecker implements ExpressionVisitor<Natural>, DataTypeVisitor<Natural> {

	private final List<TypeCheckError> typeErrors;
	private final Map<Identifier, Natural> environment;

	public ExpressionTypeChecker(final Map<Identifier, Natural> environment) {
		typeErrors = new ArrayList<TypeCheckError>();
		this.environment = environment;
	}

	@Override
	public Natural visit(final Add add) {
		checkNumeric(add.getRight().accept(this));
		checkNumeric(add.getLeft().accept(this));

		return add;
	}

	@Override
	public Natural visit(final NumericValue integerValue) {
		return integerValue;
	}

	@Override
	public Natural visit(final And and) {
		checkBoolean(and.getLeft().accept(this));
		checkBoolean(and.getRight().accept(this));

		return and;
	}

	@Override
	public Natural visit(final Divide divide) {
		checkNumeric(divide.getRight().accept(this));
		checkNumeric(divide.getLeft().accept(this));

		return divide;
	}

	@Override
	public Natural visit(final Equals equals) {
		// Only numeric equals supported right now.
		checkNumeric(equals.getRight().accept(this));
		checkNumeric(equals.getLeft().accept(this));

		return equals;
	}

	@Override
	public Natural visit(final GreaterOrEquals greaterOrEquals) {
		checkNumeric(greaterOrEquals.getRight().accept(this));
		checkNumeric(greaterOrEquals.getLeft().accept(this));

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
		checkNumeric(greaterThan.getRight().accept(this));
		checkNumeric(greaterThan.getLeft().accept(this));

		return greaterThan;
	}

	@Override
	public Natural visit(final Identifier identifier) {
		if (environment.get(identifier) == null) {
			return identifier;
		} else {
			return environment.get(identifier);
		}
	}

	@Override
	public Natural visit(final Multiply multiply) {

		checkNumeric(multiply.getRight().accept(this));
		checkNumeric(multiply.getLeft().accept(this));

		return multiply;
	}

	@Override
	public Natural visit(final Negative negative) {
		checkNumeric(negative.getOperation());

		return negative;
	}

	@Override
	public Natural visit(final Not not) {
		checkBoolean(not.getOperation().accept(this));

		return not;
	}

	@Override
	public Natural visit(final NotEquals notEquals) {
		checkNumeric(notEquals.getRight().accept(this));
		checkNumeric(notEquals.getLeft().accept(this));

		return notEquals;
	}

	@Override
	public Natural visit(final Or or) {

		checkBoolean(or.getRight().accept(this));
		checkBoolean(or.getLeft().accept(this));

		return or;
	}

	@Override
	public Natural visit(final Positive positive) {
		checkNumeric(positive.getOperation().accept(this));

		return positive;
	}

	@Override
	public Natural visit(final SmallerOrEquals smallerOrEquals) {
		checkNumeric(smallerOrEquals.getRight().accept(this));
		checkNumeric(smallerOrEquals.getLeft().accept(this));

		return smallerOrEquals;
	}

	@Override
	public Natural visit(final SmallerThan smallerThan) {

		checkNumeric(smallerThan.getRight().accept(this));
		checkNumeric(smallerThan.getLeft().accept(this));

		return smallerThan;
	}

	@Override
	public Natural visit(final Substitute substitute) {

		checkNumeric(substitute.getRight().accept(this));
		checkNumeric(substitute.getLeft().accept(this));

		return substitute;
	}

	private void checkNumeric(final Natural natural) {
		checkNature(natural, new Numeric());
	}

	private void checkBoolean(final Natural natural) {
		checkNature(natural, new Bools());
	}

	private void checkNature(final Natural natural, final Nature nature) {
		if (!natural.getNature().equals(nature)) {
			typeErrors.add(new TypeCheckError("A " + nature + " is incompatible with " + natural));
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
