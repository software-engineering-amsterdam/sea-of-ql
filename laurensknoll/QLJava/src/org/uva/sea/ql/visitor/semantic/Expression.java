package org.uva.sea.ql.visitor.semantic;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.ast.expr.atom.Bool;
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

public class Expression implements org.uva.sea.ql.visitor.Expression<Boolean> {

	private final Environment environment;

	private final List<String> errors;

	public Expression(Environment context) {
		this.environment = context;
		this.errors = new ArrayList<String>();
	}

	@Override
	public Boolean visit(Add add) {
		AbstractExpr left = add.getLeftHandSideExpression();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = add.getRightHandSideExpression();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftNumeric = left.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Numeric;
		if (!isLeftNumeric) {
			String unexpectedType = String.format(
					"Error in Add expression: %s is no Numeric.",
					left.toString());
			this.errors.add(unexpectedType);
		}

		Boolean isRightNumeric = right.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Numeric;
		if (!isRightNumeric) {
			String unexpectedType = String.format(
					"Error in Add expression: %s is no Numeric.",
					right.toString());
			this.errors.add(unexpectedType);
		}

		return isLeftValid && isRightValid && isLeftNumeric && isRightNumeric;
	}

	@Override
	public Boolean visit(And and) {
		AbstractExpr left = and.getLeftHandSideExpression();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = and.getRightHandSideExpression();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftBool = left.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Bool;
		if (!isLeftBool) {
			String unexpectedType = String.format(
					"Error in And expression: %s is no Boolean.",
					left.toString());
			this.errors.add(unexpectedType);
		}

		Boolean isRightBool = right.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Bool;
		if (!isRightBool) {
			String unexpectedType = String.format(
					"Error in And expression: %s is no Boolean.",
					right.toString());
			this.errors.add(unexpectedType);
		}

		return isLeftValid && isRightValid && isLeftBool && isRightBool;
	}

	@Override
	public Boolean visit(Div div) {
		AbstractExpr left = div.getLeftHandSideExpression();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = div.getRightHandSideExpression();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftNumeric = left.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Numeric;
		if (!isLeftNumeric) {
			String unexpectedType = String.format(
					"Error in Div expression: %s is no Numeric.",
					left.toString());
			this.errors.add(unexpectedType);
		}

		Boolean isRightNumeric = right.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Numeric;
		if (!isRightNumeric) {
			String unexpectedType = String.format(
					"Error in Div expression: %s is no Numeric.",
					right.toString());
			this.errors.add(unexpectedType);
		}

		return isLeftValid && isRightValid && isLeftNumeric && isRightNumeric;
	}

	@Override
	public Boolean visit(Eq eq) {
		AbstractExpr left = eq.getLeftHandSideExpression();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = eq.getRightHandSideExpression();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftBool = left.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Bool;
		if (!isLeftBool) {
			String unexpectedType = String.format(
					"Error in Eq expression: %s is no Boolean.",
					left.toString());
			this.errors.add(unexpectedType);
		}

		Boolean isRightBool = right.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Bool;
		if (!isRightBool) {
			String unexpectedType = String.format(
					"Error in Eq expression: %s is no Boolean.",
					right.toString());
			this.errors.add(unexpectedType);
		}

		return isLeftValid && isRightValid && isLeftBool && isRightBool;
	}

	@Override
	public Boolean visit(GEq geq) {
		AbstractExpr left = geq.getLeftHandSideExpression();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = geq.getRightHandSideExpression();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftBool = left.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Bool;
		if (!isLeftBool) {
			String unexpectedType = String.format(
					"Error in GEq expression: %s is no Boolean.",
					left.toString());
			this.errors.add(unexpectedType);
		}

		Boolean isRightBool = right.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Bool;
		if (!isRightBool) {
			String unexpectedType = String.format(
					"Error in GEq expression: %s is no Boolean.",
					right.toString());
			this.errors.add(unexpectedType);
		}

		return isLeftValid && isRightValid && isLeftBool && isRightBool;
	}

	@Override
	public Boolean visit(GT gt) {
		AbstractExpr left = gt.getLeftHandSideExpression();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = gt.getRightHandSideExpression();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftBool = left.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Bool;
		if (!isLeftBool) {
			String unexpectedType = String.format(
					"Error in GT expression: %s is no Boolean.",
					left.toString());
			this.errors.add(unexpectedType);
		}

		Boolean isRightBool = right.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Bool;
		if (!isRightBool) {
			String unexpectedType = String.format(
					"Error in GT expression: %s is no Boolean.",
					right.toString());
			this.errors.add(unexpectedType);
		}

		return isLeftValid && isRightValid && isLeftBool && isRightBool;
	}

	@Override
	public Boolean visit(LEq leq) {
		AbstractExpr left = leq.getLeftHandSideExpression();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = leq.getRightHandSideExpression();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftBool = left.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Bool;
		if (!isLeftBool) {
			String unexpectedType = String.format(
					"Error in LEq expression: %s is no Boolean.",
					left.toString());
			this.errors.add(unexpectedType);
		}

		Boolean isRightBool = right.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Bool;
		if (!isRightBool) {
			String unexpectedType = String.format(
					"Error in LEq expression: %s is no Boolean.",
					right.toString());
			this.errors.add(unexpectedType);
		}

		return isLeftValid && isRightValid && isLeftBool && isRightBool;
	}

	@Override
	public Boolean visit(LT lt) {
		AbstractExpr left = lt.getLeftHandSideExpression();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = lt.getRightHandSideExpression();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftBool = left.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Bool;
		if (!isLeftBool) {
			String unexpectedType = String.format(
					"Error in LT expression: %s is no Boolean.",
					left.toString());
			this.errors.add(unexpectedType);
		}

		Boolean isRightBool = right.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Bool;
		if (!isRightBool) {
			String unexpectedType = String.format(
					"Error in LT expression: %s is no Boolean.",
					right.toString());
			this.errors.add(unexpectedType);
		}

		return isLeftValid && isRightValid && isLeftBool && isRightBool;
	}

	@Override
	public Boolean visit(Mul mul) {
		AbstractExpr left = mul.getLeftHandSideExpression();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = mul.getRightHandSideExpression();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftNumeric = left.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Numeric;
		if (!isLeftNumeric) {
			String unexpectedType = String.format(
					"Error in Mul expression: %s is no Numeric.",
					left.toString());
			this.errors.add(unexpectedType);
		}

		Boolean isRightNumeric = right.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Numeric;
		if (!isRightNumeric) {
			String unexpectedType = String.format(
					"Error in Mul expression: %s is no Numeric.",
					right.toString());
			this.errors.add(unexpectedType);
		}

		return isLeftValid && isRightValid && isLeftNumeric && isRightNumeric;
	}

	@Override
	public Boolean visit(Neg neg) {
		AbstractExpr expr = neg.getExpression();
		Boolean isExprValid = expr.accept(this);

		Boolean isExprNumeric = expr.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Numeric;
		if (!isExprNumeric) {
			String unexpectedType = String.format(
					"Error in Neg expression: %s is no Numeric.",
					expr.toString());
			this.errors.add(unexpectedType);
		}

		return isExprValid && isExprNumeric;
	}

	@Override
	public Boolean visit(NEq neq) {
		AbstractExpr left = neq.getLeftHandSideExpression();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = neq.getRightHandSideExpression();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftBool = left.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Bool;
		if (!isLeftBool) {
			String unexpectedType = String.format(
					"Error in NEq expression: %s is no Boolean.",
					left.toString());
			this.errors.add(unexpectedType);
		}

		Boolean isRightBool = right.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Bool;
		if (!isRightBool) {
			String unexpectedType = String.format(
					"Error in NEq expression: %s is no Boolean.",
					right.toString());
			this.errors.add(unexpectedType);
		}

		return isLeftValid && isRightValid && isLeftBool && isRightBool;
	}

	@Override
	public Boolean visit(Not not) {
		AbstractExpr expr = not.getExpression();
		Boolean isExprValid = expr.accept(this);

		Boolean isExprNumeric = expr.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Bool;
		if (!isExprNumeric) {
			String unexpectedType = String.format(
					"Error in Not expression: %s is no Boolean.",
					expr.toString());
			this.errors.add(unexpectedType);
		}

		return isExprValid && isExprNumeric;
	}

	@Override
	public Boolean visit(Or or) {
		AbstractExpr left = or.getLeftHandSideExpression();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = or.getRightHandSideExpression();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftBool = left.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Bool;
		if (!isLeftBool) {
			String unexpectedType = String.format(
					"Error in Or expression: %s is no Boolean.",
					left.toString());
			this.errors.add(unexpectedType);
		}

		Boolean isRightBool = right.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Bool;
		if (!isRightBool) {
			String unexpectedType = String.format(
					"Error in Or expression: %s is no Boolean.",
					right.toString());
			this.errors.add(unexpectedType);
		}

		return isLeftValid && isRightValid && isLeftBool && isRightBool;
	}

	@Override
	public Boolean visit(Pos pos) {
		AbstractExpr expr = pos.getExpression();
		Boolean isExprValid = expr.accept(this);

		Boolean isExprNumeric = expr.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Numeric;
		if (!isExprNumeric) {
			String unexpectedType = String.format(
					"Error in Pos expression: %s is no Numeric.",
					expr.toString());
			this.errors.add(unexpectedType);
		}

		return isExprValid && isExprNumeric;
	}

	@Override
	public Boolean visit(Sub sub) {
		AbstractExpr left = sub.getLeftHandSideExpression();
		Boolean isLeftValid = left.accept(this);

		AbstractExpr right = sub.getRightHandSideExpression();
		Boolean isRightValid = right.accept(this);

		Boolean isLeftNumeric = left.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Numeric;
		if (!isLeftNumeric) {
			String unexpectedType = String.format(
					"Error in Add expression: %s is no Numeric.",
					left.toString());
			this.errors.add(unexpectedType);
		}

		Boolean isRightNumeric = right.typeOf(this.environment) instanceof org.uva.sea.ql.ast.type.Numeric;
		if (!isRightNumeric) {
			String unexpectedType = String.format(
					"Error in Add expression: %s is no Numeric.",
					right.toString());
			this.errors.add(unexpectedType);
		}

		return isLeftValid && isRightValid && isLeftNumeric && isRightNumeric;
	}

	@Override
	public Boolean visit(Bool bool) {
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
