package org.uva.sea.ql.visitor.semantic;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.expr.atom.Int;
import org.uva.sea.ql.ast.expr.atom.Money;
import org.uva.sea.ql.ast.expr.binary.AbstractBinary;
import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
import org.uva.sea.ql.ast.expr.binary.Arithmetic;
import org.uva.sea.ql.ast.expr.binary.Div;
import org.uva.sea.ql.ast.expr.binary.Eq;
import org.uva.sea.ql.ast.expr.binary.Equality;
import org.uva.sea.ql.ast.expr.binary.GEq;
import org.uva.sea.ql.ast.expr.binary.GT;
import org.uva.sea.ql.ast.expr.binary.LEq;
import org.uva.sea.ql.ast.expr.binary.LT;
import org.uva.sea.ql.ast.expr.binary.Mul;
import org.uva.sea.ql.ast.expr.binary.NEq;
import org.uva.sea.ql.ast.expr.binary.Or;
import org.uva.sea.ql.ast.expr.binary.Relational;
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
		return typeOfLeft.equals(typeOfRight);
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

	private ValidationResult validateBinary(Arithmetic expr) {
		ValidationResult result = new ValidationResult();

		result.addValidationResult(this.validateChildren(expr));

		AbstractExpr left = expr.getLeftHandSide();
		Boolean isLeftNumeric = this.isOfNumericType(left);
		if (!isLeftNumeric) {
			this.addUnexpectedTypeError(result, expr, left, "Numeric");
		}

		AbstractExpr right = expr.getRightHandSide();
		Boolean isRightNumeric = this.isOfNumericType(right);
		if (!isRightNumeric) {
			this.addUnexpectedTypeError(result, expr, right, "Numeric");
		}

		return result;
	}

	private ValidationResult validateBinary(Relational expr) {
		ValidationResult result = new ValidationResult();

		result.addValidationResult(this.validateChildren(expr));

		AbstractExpr left = expr.getLeftHandSide();
		Boolean isLeftBool = this.isOfBooleanType(left);
		if (!isLeftBool) {
			this.addUnexpectedTypeError(result, expr, left, "Bool");
		}

		AbstractExpr right = expr.getRightHandSide();
		Boolean isRightBool = this.isOfBooleanType(right);
		if (!isRightBool) {
			this.addUnexpectedTypeError(result, expr, right, "Bool");
		}

		return result;
	}

	private ValidationResult validateBinary(Equality expr) {
		ValidationResult result = new ValidationResult();

		result.addValidationResult(this.validateChildren(expr));

		AbstractExpr left = expr.getLeftHandSide();
		AbstractExpr right = expr.getRightHandSide();
		Boolean isOfSameType = this.isOfSameType(left, right);
		if (!isOfSameType) {
			this.addDifferentTypeError(result, expr, left, right);
		}

		return result;
	}

	private ValidationResult validateChildren(AbstractBinary expr) {
		ValidationResult result = new ValidationResult();

		AbstractExpr left = expr.getLeftHandSide();
		result.addValidationResult(left.accept(this));

		AbstractExpr right = expr.getRightHandSide();
		result.addValidationResult(right.accept(this));

		return result;
	}

	@Override
	public ValidationResult visit(Add add) {
		return this.validateBinary(add);
	}

	@Override
	public ValidationResult visit(And and) {
		return this.validateBinary(and);
	}

	@Override
	public ValidationResult visit(Div div) {
		return this.validateBinary(div);
	}

	@Override
	public ValidationResult visit(Eq eq) {
		return this.validateBinary(eq);
	}

	@Override
	public ValidationResult visit(GEq geq) {
		return this.validateBinary(geq);
	}

	@Override
	public ValidationResult visit(GT gt) {
		return this.validateBinary(gt);
	}

	@Override
	public ValidationResult visit(LEq leq) {
		return this.validateBinary(leq);
	}

	@Override
	public ValidationResult visit(LT lt) {
		return this.validateBinary(lt);
	}

	@Override
	public ValidationResult visit(Mul mul) {
		return this.validateBinary(mul);
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
		return this.validateBinary(neq);
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
		return this.validateBinary(or);
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
		return this.validateBinary(sub);
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
