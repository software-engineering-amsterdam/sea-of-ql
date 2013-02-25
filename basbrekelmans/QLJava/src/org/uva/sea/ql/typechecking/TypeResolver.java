package org.uva.sea.ql.typechecking;

import org.uva.sea.ql.ast.expressions.Addition;
import org.uva.sea.ql.ast.expressions.And;
import org.uva.sea.ql.ast.expressions.Arithmetic;
import org.uva.sea.ql.ast.expressions.BooleanLiteral;
import org.uva.sea.ql.ast.expressions.Division;
import org.uva.sea.ql.ast.expressions.EqualityComparison;
import org.uva.sea.ql.ast.expressions.Equals;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.GreaterThan;
import org.uva.sea.ql.ast.expressions.GreaterThanOrEquals;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.IntegerLiteral;
import org.uva.sea.ql.ast.expressions.LessThan;
import org.uva.sea.ql.ast.expressions.LessThanOrEquals;
import org.uva.sea.ql.ast.expressions.Logical;
import org.uva.sea.ql.ast.expressions.MoneyLiteral;
import org.uva.sea.ql.ast.expressions.Multiplication;
import org.uva.sea.ql.ast.expressions.NotEquals;
import org.uva.sea.ql.ast.expressions.NumericComparison;
import org.uva.sea.ql.ast.expressions.Or;
import org.uva.sea.ql.ast.expressions.StringLiteral;
import org.uva.sea.ql.ast.expressions.Subtraction;
import org.uva.sea.ql.ast.expressions.UnaryMinus;
import org.uva.sea.ql.ast.expressions.UnaryNot;
import org.uva.sea.ql.ast.expressions.UnaryNumeric;
import org.uva.sea.ql.ast.expressions.UnaryPlus;
import org.uva.sea.ql.ast.expressions.Xor;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;

/* internal */class TypeResolver implements IExpressionVisitor<Type>,
		ITypeResolver {

	private final TypeContext context;

	public TypeResolver(final TypeContext context) {
		this.context = context;
	}

	/*
	 * This implementation checks the left and right type of the arithmetic
	 * expression. Both types should be a number and money has the precedence if
	 * both integer and money type are provided.
	 */
	private Type checkAndFindArithmeticType(final Arithmetic element) {
		final Type leftType = element.getLeft().accept(this);
		final Type rightType = element.getRight().accept(this);
		if (!leftType.isNumber() || !rightType.isNumber()) {
			return Type.UNKNOWN;
		} else if (leftType == Type.INTEGER && rightType == Type.INTEGER) {
			return Type.INTEGER;
		} else {
			return Type.MONEY;
		}
	}

	private Type checkAndFindEqualityComparisonType(
			final EqualityComparison element) {
		final Type leftType = element.getLeft().accept(this);
		final Type rightType = element.getRight().accept(this);
		if (leftType == rightType || leftType.isNumber()
				&& rightType.isNumber()) {
			return Type.BOOLEAN;
		} else {
			this.context.addError(element, String.format(
					"Invalid equality comparison, cannot compare %s and %s",
					leftType, rightType));
			return Type.UNKNOWN;
		}
	}

	private Type checkAndFindLogicalExpressionType(final Logical element) {
		final Type leftType = element.getLeft().accept(this);
		final Type rightType = element.getRight().accept(this);
		if (leftType.isBoolean() && rightType.isBoolean()) {
			return Type.BOOLEAN;
		} else {
			this.context.addError(element, String.format(
					"Invalid logical expression, cannot compare %s and %s",
					leftType, rightType));
			return Type.UNKNOWN;
		}
	}

	/*
	 * Type returned by a comparison expression is driven by the following
	 * rules: 1: type equality 2: money over integer precedence
	 */
	private Type checkAndFindNumericComparisonType(
			final NumericComparison element) {
		final Type leftType = element.getLeft().accept(this);
		final Type rightType = element.getRight().accept(this);
		if (leftType.isNumber() && rightType.isNumber()) {
			return Type.BOOLEAN;
		} else {
			this.context.addError(element, String.format(
					"Invalid numeric comparison, cannot compare %s and %s",
					leftType, rightType));
			return Type.UNKNOWN;
		}
	}

	private Type checkAndFindUnaryNumericType(final UnaryNumeric element) {
		final Type operandType = element.getOperand().accept(this);
		if (operandType.isNumber()) {
			return operandType;
		} else {
			this.context.addError(element, String.format(
					"Invalid expression, cannot apply unary numeric to '%s'",
					operandType));
			return Type.UNKNOWN;
		}
	}

	@Override
	public Type getType(final Expression expression) {
		return expression.accept(this);
	}

	@Override
	public Type visit(final Addition element) {
		return this.checkAndFindArithmeticType(element);
	}

	@Override
	public Type visit(final And element) {
		return this.checkAndFindLogicalExpressionType(element);
	}

	@Override
	public Type visit(final BooleanLiteral element) {
		return Type.BOOLEAN;
	}

	@Override
	public Type visit(final Division element) {
		return this.checkAndFindArithmeticType(element);
	}

	@Override
	public Type visit(final Equals element) {
		return this.checkAndFindEqualityComparisonType(element);
	}

	@Override
	public Type visit(final GreaterThan element) {
		return this.checkAndFindNumericComparisonType(element);
	}

	@Override
	public Type visit(final GreaterThanOrEquals element) {
		return this.checkAndFindNumericComparisonType(element);
	}

	@Override
	public Type visit(final Identifier element) {
		if (!this.context.getSymbolTable().containsKey(element)) {
			this.context.addError(element,
					String.format("Unknown identifier: %s", element.getName()));
			return Type.UNKNOWN;
		} else {
			return this.context.getSymbolTable().get(element);
		}
	}

	@Override
	public Type visit(final IntegerLiteral element) {
		return Type.INTEGER;
	}

	@Override
	public Type visit(final LessThan element) {
		return this.checkAndFindNumericComparisonType(element);
	}

	@Override
	public Type visit(final LessThanOrEquals element) {
		return this.checkAndFindNumericComparisonType(element);
	}

	@Override
	public Type visit(final MoneyLiteral element) {
		return Type.MONEY;
	}

	@Override
	public Type visit(final Multiplication element) {
		return this.checkAndFindArithmeticType(element);
	}

	@Override
	public Type visit(final NotEquals element) {
		return this.checkAndFindEqualityComparisonType(element);
	}

	@Override
	public Type visit(final Or element) {
		return this.checkAndFindLogicalExpressionType(element);
	}

	@Override
	public Type visit(final StringLiteral element) {
		return Type.STRING;
	}

	@Override
	public Type visit(final Subtraction element) {
		return this.checkAndFindArithmeticType(element);
	}

	@Override
	public Type visit(final UnaryMinus element) {
		return this.checkAndFindUnaryNumericType(element);
	}

	@Override
	public Type visit(final UnaryNot element) {
		final Type operandType = element.getOperand().accept(this);
		if (operandType.isBoolean()) {
			return operandType;
		} else {
			this.context.addError(element, String.format(
					"Invalid expression, cannot apply unary not ('!') to '%s'",
					operandType));
			return Type.UNKNOWN;
		}
	}

	@Override
	public Type visit(final UnaryPlus element) {
		return this.checkAndFindUnaryNumericType(element);
	}

	@Override
	public Type visit(final Xor element) {
		return this.checkAndFindLogicalExpressionType(element);
	}

}
