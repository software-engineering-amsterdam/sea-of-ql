package org.uva.sea.ql.visitor.semantic;

import java.util.ArrayList;
import java.util.List;

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
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Numeric;

public class Expression implements org.uva.sea.ql.visitor.Expression<Boolean> {

	private final Environment environment;
	private final List<String> errors;

	public Expression(Environment env) {
		this.environment = env;
		this.errors = new ArrayList<String>();
	}

	private <T extends AbstractType> Boolean isOfType(AbstractExpr expr,
			Class<T> expected) {
		AbstractType typeOfExpr = expr.typeOf(this.environment);
		return expected.isInstance(typeOfExpr);
	}

	private Boolean isOfSameType(AbstractExpr left, AbstractExpr right) {
		AbstractType typeOfLeft = left.typeOf(this.environment);
		AbstractType typeOfRight = right.typeOf(this.environment);
		return typeOfLeft.getClass() == typeOfRight.getClass();
	}

	private void addUnexpectedTypeError(AbstractExpr visited,
			AbstractExpr given, Class<? extends AbstractType> expected) {
		String unexpectedType = String.format(
				"Error in expression \"%s\": %s is no %s", visited.toString(),
				given.toString(), expected.toString());
		this.errors.add(unexpectedType);
	}

	private void addDifferentTypeError(AbstractExpr visited, AbstractExpr left,
			AbstractExpr right) {
		String differentType = String
				.format("Error in expression \"%s\": %s and %s are of different types.",
						visited.toString(), left.toString(), right.toString());
		this.errors.add(differentType);
	}

	@Override
	public Boolean visit(Add add) {
		AbstractExpr left = add.getLeftHandSide();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = add.getRightHandSide();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftNumeric = this.isOfType(left, Numeric.class);
		if (!isLeftNumeric) {
			this.addUnexpectedTypeError(add, left, Numeric.class);
		}

		Boolean isRightNumeric = this.isOfType(right, Numeric.class);
		if (!isRightNumeric) {
			this.addUnexpectedTypeError(add, right, Numeric.class);
		}

		return isLeftValid && isRightValid && isLeftNumeric && isRightNumeric;
	}

	@Override
	public Boolean visit(And and) {
		AbstractExpr left = and.getLeftHandSide();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = and.getRightHandSide();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftBool = this.isOfType(left, Bool.class);
		;
		if (!isLeftBool) {
			this.addUnexpectedTypeError(and, left, Bool.class);
		}

		Boolean isRightBool = this.isOfType(right, Bool.class);
		if (!isRightBool) {
			this.addUnexpectedTypeError(and, right, Bool.class);
		}

		return isLeftValid && isRightValid && isLeftBool && isRightBool;
	}

	@Override
	public Boolean visit(Div div) {
		AbstractExpr left = div.getLeftHandSide();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = div.getRightHandSide();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftNumeric = this.isOfType(left, Numeric.class);
		if (!isLeftNumeric) {
			this.addUnexpectedTypeError(div, left, Numeric.class);
		}

		Boolean isRightNumeric = this.isOfType(right, Numeric.class);
		if (!isRightNumeric) {
			this.addUnexpectedTypeError(div, right, Numeric.class);
		}

		return isLeftValid && isRightValid && isLeftNumeric && isRightNumeric;
	}

	@Override
	public Boolean visit(Eq eq) {
		AbstractExpr left = eq.getLeftHandSide();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = eq.getRightHandSide();
		Boolean isRightValid = right.accept(this);

		Boolean isOfSameType = this.isOfSameType(left, right);
		if (!isOfSameType) {
			this.addDifferentTypeError(eq, left, right);
		}

		return isLeftValid && isRightValid && isOfSameType;
	}

	@Override
	public Boolean visit(GEq geq) {
		AbstractExpr left = geq.getLeftHandSide();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = geq.getRightHandSide();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftNumeric = this.isOfType(left, Numeric.class);
		if (!isLeftNumeric) {
			this.addUnexpectedTypeError(geq, left, Numeric.class);
		}

		Boolean isRightNumeric = this.isOfType(right, Numeric.class);
		if (!isRightNumeric) {
			this.addUnexpectedTypeError(geq, right, Numeric.class);
		}

		return isLeftValid && isRightValid && isLeftNumeric && isRightNumeric;
	}

	@Override
	public Boolean visit(GT gt) {
		AbstractExpr left = gt.getLeftHandSide();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = gt.getRightHandSide();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftNumeric = this.isOfType(left, Numeric.class);
		if (!isLeftNumeric) {
			this.addUnexpectedTypeError(gt, left, Numeric.class);
		}

		Boolean isRightNumeric = this.isOfType(right, Numeric.class);
		if (!isRightNumeric) {
			this.addUnexpectedTypeError(gt, right, Numeric.class);
		}

		return isLeftValid && isRightValid && isLeftNumeric && isRightNumeric;
	}

	@Override
	public Boolean visit(LEq leq) {
		AbstractExpr left = leq.getLeftHandSide();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = leq.getRightHandSide();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftNumeric = this.isOfType(left, Numeric.class);
		if (!isLeftNumeric) {
			this.addUnexpectedTypeError(leq, left, Numeric.class);
		}

		Boolean isRightNumeric = this.isOfType(right, Numeric.class);
		if (!isRightNumeric) {
			this.addUnexpectedTypeError(leq, right, Numeric.class);
		}

		return isLeftValid && isRightValid && isLeftNumeric && isRightNumeric;
	}

	@Override
	public Boolean visit(LT lt) {
		AbstractExpr left = lt.getLeftHandSide();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = lt.getRightHandSide();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftNumeric = this.isOfType(left, Numeric.class);
		if (!isLeftNumeric) {
			this.addUnexpectedTypeError(lt, left, Numeric.class);
		}

		Boolean isRightNumeric = this.isOfType(right, Numeric.class);
		if (!isRightNumeric) {
			this.addUnexpectedTypeError(lt, right, Numeric.class);
		}

		return isLeftValid && isRightValid && isLeftNumeric && isRightNumeric;
	}

	@Override
	public Boolean visit(Mul mul) {
		AbstractExpr left = mul.getLeftHandSide();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = mul.getRightHandSide();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftNumeric = this.isOfType(left, Numeric.class);
		if (!isLeftNumeric) {
			this.addUnexpectedTypeError(mul, left, Numeric.class);
		}

		Boolean isRightNumeric = this.isOfType(right, Numeric.class);
		if (!isRightNumeric) {
			this.addUnexpectedTypeError(mul, right, Numeric.class);
		}

		return isLeftValid && isRightValid && isLeftNumeric && isRightNumeric;
	}

	@Override
	public Boolean visit(Neg neg) {
		AbstractExpr expr = neg.getExpression();
		Boolean isExprValid = expr.accept(this);

		Boolean isExprNumeric = this.isOfType(expr, Numeric.class);
		if (!isExprNumeric) {
			this.addUnexpectedTypeError(neg, expr, Numeric.class);
		}

		return isExprValid && isExprNumeric;
	}

	@Override
	public Boolean visit(NEq neq) {
		AbstractExpr left = neq.getLeftHandSide();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = neq.getRightHandSide();
		Boolean isRightValid = right.accept(this);

		Boolean isOfSameType = this.isOfSameType(left, right);
		if (!isOfSameType) {
			this.addDifferentTypeError(neq, left, right);
		}

		return isLeftValid && isRightValid && isOfSameType;
	}

	@Override
	public Boolean visit(Not not) {
		AbstractExpr expr = not.getExpression();
		Boolean isExprValid = expr.accept(this);

		Boolean isExprNumeric = this.isOfType(expr, Bool.class);
		if (!isExprNumeric) {
			this.addUnexpectedTypeError(not, expr, Bool.class);
		}

		return isExprValid && isExprNumeric;
	}

	@Override
	public Boolean visit(Or or) {
		AbstractExpr left = or.getLeftHandSide();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = or.getRightHandSide();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftBool = this.isOfType(left, Bool.class);
		if (!isLeftBool) {
			this.addUnexpectedTypeError(or, left, Bool.class);
		}

		Boolean isRightBool = this.isOfType(right, Bool.class);
		if (!isRightBool) {
			this.addUnexpectedTypeError(or, right, Bool.class);
		}

		return isLeftValid && isRightValid && isLeftBool && isRightBool;
	}

	@Override
	public Boolean visit(Pos pos) {
		AbstractExpr expr = pos.getExpression();
		Boolean isExprValid = expr.accept(this);

		Boolean isExprNumeric = this.isOfType(expr, Numeric.class);
		if (!isExprNumeric) {
			this.addUnexpectedTypeError(pos, expr, Numeric.class);
		}

		return isExprValid && isExprNumeric;
	}

	@Override
	public Boolean visit(Sub sub) {
		AbstractExpr left = sub.getLeftHandSide();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = sub.getRightHandSide();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftNumeric = this.isOfType(left, Numeric.class);
		if (!isLeftNumeric) {
			this.addUnexpectedTypeError(sub, left, Numeric.class);
		}

		Boolean isRightNumeric = this.isOfType(right, Numeric.class);
		if (!isRightNumeric) {
			this.addUnexpectedTypeError(sub, right, Numeric.class);
		}

		return isLeftValid && isRightValid && isLeftNumeric && isRightNumeric;
	}

	@Override
	public Boolean visit(org.uva.sea.ql.ast.expr.atom.Bool bool) {
		return true;
	}

	@Override
	public Boolean visit(Ident ident) {
		if (!this.environment.exists(ident)) {
			String identNotDefined = String.format(
					"Ident \"%s\" is not defined.", ident.getName());
			this.errors.add(identNotDefined);

			return false;
		}

		return true;
	}

	@Override
	public Boolean visit(Int intType) {
		return true;
	}

	@Override
	public Boolean visit(Money money) {
		return true;
	}

	@Override
	public Boolean visit(org.uva.sea.ql.ast.expr.atom.String string) {
		return true;
	}

	public List<String> getErrors() {
		return this.errors;
	}

}
