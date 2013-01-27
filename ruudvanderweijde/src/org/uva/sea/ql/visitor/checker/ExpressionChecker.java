package org.uva.sea.ql.visitor.checker;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
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
import org.uva.sea.ql.ast.expr.primary.Bool;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.expr.primary.Int;
import org.uva.sea.ql.ast.expr.primary.StringLiteral;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class ExpressionChecker implements ExpressionVisitor<Boolean> {
	private final Map<Ident, Type> typeEnv;
	private final List<String> errors;

	public ExpressionChecker(Map<Ident, Type> tenv, List<String> errors) {
		this.typeEnv = tenv;
		this.errors = errors;
	}

	public static boolean check(Expr expr, Map<Ident, Type> typeEnv,
			List<String> errs) {
		ExpressionChecker check = new ExpressionChecker(typeEnv, errs);
		return expr.accept(check);
	}

	@Override
	public Boolean visit(Add ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}

		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);

		if (!(lhsType.isCompatibleToNumericType() && rhsType
				.isCompatibleToNumericType())) {

			addErrorMessage("invalid Numeric operater for + ");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(And ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToBooleanType() && rhsType
				.isCompatibleToBooleanType())) {

			addErrorMessage("invalid boolean operator for &&.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Div ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumericType() && rhsType
				.isCompatibleToNumericType())) {

			addErrorMessage("invalid Numeric operator for /.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Eq ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToBooleanType() && rhsType.isCompatibleToBooleanType()) 
				&& !(lhsType.isCompatibleToNumericType() && rhsType.isCompatibleToNumericType())) {

			addErrorMessage("invalid Boolean or Numeric operator for ==.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(GEq ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumericType() && rhsType
				.isCompatibleToNumericType())) {

			addErrorMessage("invalid Numeric operator for <=.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(GT ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumericType() && rhsType
				.isCompatibleToNumericType())) {

			addErrorMessage("invalid Numeric operator for >.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(LEq ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumericType() && rhsType
				.isCompatibleToNumericType())) {

			addErrorMessage("invalid Numeric operator for <=.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(LT ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumericType() && rhsType
				.isCompatibleToNumericType())) {

			addErrorMessage("invalid Numeric operator for <.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Mul ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumericType() && rhsType
				.isCompatibleToNumericType())) {

			addErrorMessage("invalid Numeric operator for *.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(NEq ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToBooleanType() && rhsType.isCompatibleToBooleanType()) 
			&& !(lhsType.isCompatibleToNumericType() && rhsType.isCompatibleToNumericType())) {

			addErrorMessage("invalid Boolean or Numeric operator for !=.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Or ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToBooleanType() && rhsType
				.isCompatibleToBooleanType())) {

			addErrorMessage("invalid Boolean operator for ||.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Sub ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumericType() && rhsType
				.isCompatibleToNumericType())) {

			addErrorMessage("invalid Numeric operator for /.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Neg ast) {
		boolean checkArg = ast.getArg().accept(this);
		
		if (!checkArg) {
			return false;
		}

		Type argType = ast.getArg().typeOf(typeEnv);
		if (!argType.isCompatibleToNumericType()) {
			addErrorMessage("invalid Numeric operator for -.");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Not ast) {
		boolean checkArg = ast.getArg().accept(this);
		
		if (!checkArg) {
			return false;
		}

		Type argType = ast.getArg().typeOf(typeEnv);
		if (!argType.isCompatibleToBooleanType()) {
			addErrorMessage("invalid Numeric operator for !.");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Pos ast) {
		boolean checkArg = ast.getArg().accept(this);
		
		if (!checkArg) {
			return false;
		}

		Type argType = ast.getArg().typeOf(typeEnv);
		if (!argType.isCompatibleToNumericType()) {
			addErrorMessage("invalid Numeric operator for +.");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Bool ast) {
		Type astType = ast.typeOf(typeEnv);
		if (!astType.isCompatibleToBooleanType()) {
			addErrorMessage("Not a valid Boolean.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Ident ast) {
		return true;
	}

	@Override
	public Boolean visit(Int ast) {
		Type astType = ast.typeOf(typeEnv);
		if (!astType.isCompatibleToNumericType()) {
			addErrorMessage("Not a valid Int.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(StringLiteral ast) {
		Type astType = ast.typeOf(typeEnv);
		if (!astType.isCompatibleToStringType()) {
			addErrorMessage("Not a valid String.");
			return false;
		}
		return true;
	}

	public void addErrorMessage(String message) {
		errors.add(message);
	}
	
	public List<String> getMessages() {
		return errors;
	}
}
