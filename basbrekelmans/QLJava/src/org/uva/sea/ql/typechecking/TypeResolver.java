package org.uva.sea.ql.typechecking;

import org.uva.sea.ql.ast.IExpressionVisitor;
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

/* internal */ class TypeResolver implements IExpressionVisitor<Type>, ITypeResolver {

	private TypeContext context;

	public TypeResolver(TypeContext context) {
		this.context = context;
	}

	@Override
	public Type visit(Addition element) {
		return checkAndFindArithmeticType(element);
	}

	@Override
	public Type visit(Division element) {
		return checkAndFindArithmeticType(element);
	}

	@Override
	public Type visit(Multiplication element) {
		return checkAndFindArithmeticType(element);
	}

	@Override
	public Type visit(Subtraction element) {
		return checkAndFindArithmeticType(element);
	}

	@Override
	public Type visit(GreaterThan element) {
		return checkAndFindNumericComparisonType(element);
	}

	@Override
	public Type visit(GreaterThanOrEquals element) {
		return checkAndFindNumericComparisonType(element);
	}

	@Override
	public Type visit(LessThan element) {
		return checkAndFindNumericComparisonType(element);
	}

	@Override
	public Type visit(LessThanOrEquals element) {
		return checkAndFindNumericComparisonType(element);
	}

	@Override
	public Type visit(NotEquals element) {
		return checkAndFindEqualityComparisonType(element);
	}

	@Override
	public Type visit(Equals element) {
		return checkAndFindEqualityComparisonType(element);
	}


	@Override
	public Type visit(And element) {
		return checkAndFindLogicalExpressionType(element);
	}

	@Override
	public Type visit(Or element) {
		return checkAndFindLogicalExpressionType(element);
	}

	@Override
	public Type visit(Xor element) {
		return checkAndFindLogicalExpressionType(element);
	}

	@Override
	public Type visit(BooleanLiteral element) {
		return Type.BOOLEAN;
	}

	@Override
	public Type visit(IntegerLiteral element) {
		return Type.INTEGER;
	}

	@Override
	public Type visit(MoneyLiteral element) {
		return Type.MONEY;
	}

	@Override
	public Type visit(StringLiteral element) {
		return Type.STRING;
	}

	@Override
	public Type visit(UnaryNot element) {
		Type operandType = element.getOperand().accept(this);
		if (operandType.isBoolean()) {
			return operandType;
		} else {
			context.getErrors().put(element, String.format("Invalid expression, cannot apply unary not ('!') to '%s'", operandType));
			return Type.UNKNOWN;
		}
	}

	@Override
	public Type visit(UnaryMinus element) {
		return checkAndFindUnaryNumericType(element);
	}

	private Type checkAndFindUnaryNumericType(UnaryNumeric element) {
		Type operandType = element.getOperand().accept(this);
		if (operandType.isNumber()) {
			return operandType;
		} else {
			context.getErrors().put(element, String.format("Invalid expression, cannot apply unary numeric to '%s'", operandType));
			return Type.UNKNOWN;
		}
	}

	@Override
	public Type visit(UnaryPlus element) {
		return checkAndFindUnaryNumericType(element);
	}
	
	@Override
	public Type visit(Identifier element) {
		if (!context.getSymbolTable().containsKey(element)) {
			context.getErrors().put(element, String.format("Unknown identifier: %s", element.getName()));
			return Type.UNKNOWN;
		} else {
			return context.getSymbolTable().get(element); 
		}
	}
	
	/* This implementation checks the left and right type of 
	 * the arithmetic expression. Both types should be a number
	 * and money has the precedence if both integer and money type
	 * are provided.
	 */
	private Type checkAndFindArithmeticType(Arithmetic element) {
		Type leftType = element.getLeft().accept(this);
		Type rightType = element.getRight().accept(this);
		if (!leftType.isNumber() || !rightType.isNumber()) {
			return Type.UNKNOWN;
		} else if (leftType == Type.INTEGER && rightType == Type.INTEGER) {
			return Type.INTEGER;
		} else {
			return Type.MONEY;
		}
	}

	/* Type returned by a comparison expression is driven 
	 * by the following rules:
	 * 1: type equality
	 * 2: money over integer precedence
	 */
	private Type checkAndFindNumericComparisonType(NumericComparison element) {
		Type leftType = element.getLeft().accept(this);
		Type rightType = element.getRight().accept(this);
		if (leftType.isNumber() && rightType.isNumber()) {
			return Type.BOOLEAN;
		} else {
			context.getErrors().put(element, String.format("Invalid numeric comparison, cannot compare %s and %s", leftType, rightType));
			return Type.UNKNOWN;
		}
	}
	
	private Type checkAndFindEqualityComparisonType(EqualityComparison element) {
		Type leftType = element.getLeft().accept(this);
		Type rightType = element.getRight().accept(this);
		if (leftType == rightType || leftType.isNumber() && rightType.isNumber()) {
			return Type.BOOLEAN;
		} else {
			context.getErrors().put(element, String.format("Invalid equality comparison, cannot compare %s and %s", leftType, rightType));
			return Type.UNKNOWN;
		}
	}
	
	private Type checkAndFindLogicalExpressionType(Logical element) {
		Type leftType = element.getLeft().accept(this);
		Type rightType = element.getRight().accept(this);
		if (leftType.isBoolean() && rightType.isBoolean()) {
			return Type.BOOLEAN;
		} else {
			context.getErrors().put(element, String.format("Invalid logical expression, cannot compare %s and %s", leftType, rightType));
			return Type.UNKNOWN;
		}
	}

	@Override
	public Type getType(Expression expression) {
		return expression.accept(this);
	}

}
