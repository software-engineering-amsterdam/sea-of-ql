package org.uva.sea.ql.visitor.semantic;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.expr.atom.Int;
import org.uva.sea.ql.ast.expr.atom.Money;
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
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.ast.type.AbstractType;
import org.uva.sea.ql.visitor.IExpression;

public class Expression implements IExpression<ValidationResult> {

	private final Environment environment;

	public Expression(Environment environment) {
		this.environment = environment;
	}

	private Boolean isOfBooleanType(AbstractExpr expr) {
		AbstractType type = expr.typeOf(this.environment);
		return type.accept(new BooleanType());
	}

	private Boolean isOfNumericType(AbstractExpr expr) {
		AbstractType type = expr.typeOf(this.environment);
		return type.accept(new NumericType());
	}

	private Boolean isOfSameType(AbstractExpr left, AbstractExpr right) {
		AbstractType typeOfLeft = left.typeOf(this.environment);
		AbstractType typeOfRight = right.typeOf(this.environment);
		return typeOfLeft.getClass() == typeOfRight.getClass();
	}

	private void addUnexpectedTypeError(ValidationResult result,
			AbstractExpr visited, AbstractExpr given, String expected) {
		String unexpectedType = String.format(
				"Error in expression \"%s\": %s is no %s", visited.toString(),
				given.toString(), expected);
		result.addError(unexpectedType);
	}

	private void addDifferentTypeError(ValidationResult result,
			AbstractExpr visited, AbstractExpr left, AbstractExpr right) {
		String differentType = String
				.format("Error in expression \"%s\": %s and %s are of different types.",
						visited.toString(), left.toString(), right.toString());
		result.addError(differentType);
	}

	@Override
	public ValidationResult visit(Add add) {
		ValidationResult result = new ValidationResult();

		AbstractExpr left = add.getLeftHandSide();
		result.addValidationResult(left.accept(this));

		AbstractExpr right = add.getRightHandSide();
		result.addValidationResult(right.accept(this));

		Boolean isLeftNumeric = this.isOfNumericType(left);
		if (!isLeftNumeric) {
			this.addUnexpectedTypeError(result, add, left, "Numeric");
		}

		Boolean isRightNumeric = this.isOfNumericType(right);
		if (!isRightNumeric) {
			this.addUnexpectedTypeError(result, add, right, "Numeric");
		}

		return result;
	}

	@Override
	public ValidationResult visit(And and) {
		ValidationResult result = new ValidationResult();

		AbstractExpr left = and.getLeftHandSide();
		result.addValidationResult(left.accept(this));

		AbstractExpr right = and.getRightHandSide();
		result.addValidationResult(right.accept(this));

		Boolean isLeftBool = this.isOfBooleanType(left);
		if (!isLeftBool) {
			this.addUnexpectedTypeError(result, and, left, "Bool");
		}

		Boolean isRightBool = this.isOfBooleanType(right);
		if (!isRightBool) {
			this.addUnexpectedTypeError(result, and, right, "Bool");
		}

		return result;
	}

	@Override
	public ValidationResult visit(Div div) {
		ValidationResult result = new ValidationResult();

		AbstractExpr left = div.getLeftHandSide();
		result.addValidationResult(left.accept(this));

		AbstractExpr right = div.getRightHandSide();
		result.addValidationResult(right.accept(this));

		Boolean isLeftNumeric = this.isOfNumericType(left);
		if (!isLeftNumeric) {
			this.addUnexpectedTypeError(result, div, left, "Numeric");
		}

		Boolean isRightNumeric = this.isOfNumericType(right);
		if (!isRightNumeric) {
			this.addUnexpectedTypeError(result, div, right, "Numeric");
		}

		return result;
	}

	@Override
	public ValidationResult visit(Eq eq) {
		ValidationResult result = new ValidationResult();

		AbstractExpr left = eq.getLeftHandSide();
		result.addValidationResult(left.accept(this));

		AbstractExpr right = eq.getRightHandSide();
		result.addValidationResult(right.accept(this));

		Boolean isOfSameType = this.isOfSameType(left, right);
		if (!isOfSameType) {
			this.addDifferentTypeError(result, eq, left, right);
		}

		return result;
	}

	@Override
	public ValidationResult visit(GEq geq) {
		ValidationResult result = new ValidationResult();

		AbstractExpr left = geq.getLeftHandSide();
		result.addValidationResult(left.accept(this));

		AbstractExpr right = geq.getRightHandSide();
		result.addValidationResult(right.accept(this));

		Boolean isLeftNumeric = this.isOfNumericType(left);
		if (!isLeftNumeric) {
			this.addUnexpectedTypeError(result, geq, left, "Numeric");
		}

		Boolean isRightNumeric = this.isOfNumericType(right);
		if (!isRightNumeric) {
			this.addUnexpectedTypeError(result, geq, right, "Numeric");
		}

		return result;
	}

	@Override
	public ValidationResult visit(GT gt) {
		ValidationResult result = new ValidationResult();

		AbstractExpr left = gt.getLeftHandSide();
		result.addValidationResult(left.accept(this));

		AbstractExpr right = gt.getRightHandSide();
		result.addValidationResult(right.accept(this));

		Boolean isLeftNumeric = this.isOfNumericType(left);
		if (!isLeftNumeric) {
			this.addUnexpectedTypeError(result, gt, left, "Numeric");
		}

		Boolean isRightNumeric = this.isOfNumericType(right);
		if (!isRightNumeric) {
			this.addUnexpectedTypeError(result, gt, right, "Numeric");
		}

		return result;
	}

	@Override
	public ValidationResult visit(LEq leq) {
		ValidationResult result = new ValidationResult();

		AbstractExpr left = leq.getLeftHandSide();
		result.addValidationResult(left.accept(this));

		AbstractExpr right = leq.getRightHandSide();
		result.addValidationResult(right.accept(this));

		Boolean isLeftNumeric = this.isOfNumericType(left);
		if (!isLeftNumeric) {
			this.addUnexpectedTypeError(result, leq, left, "Numeric");
		}

		Boolean isRightNumeric = this.isOfNumericType(right);
		if (!isRightNumeric) {
			this.addUnexpectedTypeError(result, leq, right, "Numeric");
		}

		return result;
	}

	@Override
	public ValidationResult visit(LT lt) {
		ValidationResult result = new ValidationResult();

		AbstractExpr left = lt.getLeftHandSide();
		result.addValidationResult(left.accept(this));

		AbstractExpr right = lt.getRightHandSide();
		result.addValidationResult(right.accept(this));

		Boolean isLeftNumeric = this.isOfNumericType(left);
		if (!isLeftNumeric) {
			this.addUnexpectedTypeError(result, lt, left, "Numeric");
		}

		Boolean isRightNumeric = this.isOfNumericType(right);
		if (!isRightNumeric) {
			this.addUnexpectedTypeError(result, lt, right, "Numeric");
		}

		return result;
	}

	@Override
	public ValidationResult visit(Mul mul) {
		ValidationResult result = new ValidationResult();

		AbstractExpr left = mul.getLeftHandSide();
		result.addValidationResult(left.accept(this));

		AbstractExpr right = mul.getRightHandSide();
		result.addValidationResult(right.accept(this));

		Boolean isLeftNumeric = this.isOfNumericType(left);
		if (!isLeftNumeric) {
			this.addUnexpectedTypeError(result, mul, left, "Numeric");
		}

		Boolean isRightNumeric = this.isOfNumericType(right);
		if (!isRightNumeric) {
			this.addUnexpectedTypeError(result, mul, right, "Numeric");
		}

		return result;
	}

	@Override
	public ValidationResult visit(Neg neg) {
		ValidationResult result = new ValidationResult();

		AbstractExpr expr = neg.getExpression();
		result.addValidationResult(expr.accept(this));

		Boolean isExprNumeric = this.isOfNumericType(expr);
		if (!isExprNumeric) {
			this.addUnexpectedTypeError(result, neg, expr, "Numeric");
		}

		return result;
	}

	@Override
	public ValidationResult visit(NEq neq) {
		ValidationResult result = new ValidationResult();

		AbstractExpr left = neq.getLeftHandSide();
		result.addValidationResult(left.accept(this));

		AbstractExpr right = neq.getRightHandSide();
		result.addValidationResult(right.accept(this));

		Boolean isOfSameType = this.isOfSameType(left, right);
		if (!isOfSameType) {
			this.addDifferentTypeError(result, neq, left, right);
		}

		return result;
	}

	@Override
	public ValidationResult visit(Not not) {
		ValidationResult result = new ValidationResult();

		AbstractExpr expr = not.getExpression();
		result.addValidationResult(expr.accept(this));

		Boolean isExprNumeric = this.isOfBooleanType(expr);
		if (!isExprNumeric) {
			this.addUnexpectedTypeError(result, not, expr, "Bool");
		}

		return result;
	}

	@Override
	public ValidationResult visit(Or or) {
		ValidationResult result = new ValidationResult();

		AbstractExpr left = or.getLeftHandSide();
		result.addValidationResult(left.accept(this));

		AbstractExpr right = or.getRightHandSide();
		result.addValidationResult(right.accept(this));

		Boolean isLeftBool = this.isOfBooleanType(left);
		if (!isLeftBool) {
			this.addUnexpectedTypeError(result, or, left, "Bool");
		}

		Boolean isRightBool = this.isOfBooleanType(right);
		if (!isRightBool) {
			this.addUnexpectedTypeError(result, or, right, "Bool");
		}

		return result;
	}

	@Override
	public ValidationResult visit(Pos pos) {
		ValidationResult result = new ValidationResult();

		AbstractExpr expr = pos.getExpression();
		result.addValidationResult(expr.accept(this));

		Boolean isExprNumeric = this.isOfNumericType(expr);
		if (!isExprNumeric) {
			this.addUnexpectedTypeError(result, pos, expr, "Numeric");
		}

		return result;
	}

	@Override
	public ValidationResult visit(Sub sub) {
		ValidationResult result = new ValidationResult();

		AbstractExpr left = sub.getLeftHandSide();
		result.addValidationResult(left.accept(this));

		AbstractExpr right = sub.getRightHandSide();
		result.addValidationResult(right.accept(this));

		Boolean isLeftNumeric = this.isOfNumericType(left);
		if (!isLeftNumeric) {
			this.addUnexpectedTypeError(result, sub, left, "Numeric");
		}

		Boolean isRightNumeric = this.isOfNumericType(right);
		if (!isRightNumeric) {
			this.addUnexpectedTypeError(result, sub, right, "Numeric");
		}

		return result;
	}

	@Override
	public ValidationResult visit(org.uva.sea.ql.ast.expr.atom.Bool bool) {
		return new ValidationResult();
	}

	@Override
	public ValidationResult visit(Ident ident) {
		ValidationResult result = new ValidationResult();

		if (!this.environment.exists(ident)) {
			String identNotDefined = String.format(
					"Ident \"%s\" is not defined.", ident.getName());
			result.addError(identNotDefined);
		}

		return result;
	}

	@Override
	public ValidationResult visit(Int intType) {
		return new ValidationResult();
	}

	@Override
	public ValidationResult visit(Money money) {
		return new ValidationResult();
	}

	@Override
	public ValidationResult visit(org.uva.sea.ql.ast.expr.atom.String string) {
		return new ValidationResult();
	}

}
