package org.uva.sea.ql.visitor.checker;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
import org.uva.sea.ql.ast.expr.binary.Binary;
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
import org.uva.sea.ql.ast.expr.unary.Unary;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class ExpressionVisitor implements IExpressionVisitor<Boolean> {
	private final Map<Ident, Type> typeEnv;
	private final List<String> errors;

	public ExpressionVisitor(Map<Ident, Type> tenv, List<String> errors) {
		this.typeEnv = tenv;
		this.errors = errors;
	}

	public static boolean check(Expr expr, Map<Ident, Type> typeEnv,
			List<String> errs) {
		ExpressionVisitor check = new ExpressionVisitor(typeEnv, errs);
		return expr.accept(check);
	}

	@Override
	public Boolean visit(Add ast) {
		if (!checkBinaryNode(ast)) {
			return false;
		}
		return bothSidesAreNumeric(ast);
	}

	@Override
	public Boolean visit(And ast) {
		if (!checkBinaryNode(ast)) {
			return false;
		}

		return bothSidesAreBoolean(ast);
	}

	@Override
	public Boolean visit(Div ast) {
		if (!checkBinaryNode(ast)) {
			return false;
		}

		return bothSidesAreNumeric(ast);
	}

	@Override
	public Boolean visit(Eq ast) {
		if (!checkBinaryNode(ast)) {
			return false;
		}

		return bothSidesAreBooleanOrNumeric(ast);
	}

	@Override
	public Boolean visit(GEq ast) {
		if (!checkBinaryNode(ast)) {
			return false;
		}

		return bothSidesAreNumeric(ast);
	}

	@Override
	public Boolean visit(GT ast) {
		if (!checkBinaryNode(ast)) {
			return false;
		}

		return bothSidesAreNumeric(ast);
	}

	@Override
	public Boolean visit(LEq ast) {
		if (!checkBinaryNode(ast)) {
			return false;
		}

		return bothSidesAreNumeric(ast);
	}

	@Override
	public Boolean visit(LT ast) {
		if (!checkBinaryNode(ast)) {
			return false;
		}

		return bothSidesAreNumeric(ast);
	}

	@Override
	public Boolean visit(Mul ast) {
		if (!checkBinaryNode(ast)) {
			return false;
		}

		return bothSidesAreNumeric(ast);
	}

	@Override
	public Boolean visit(NEq ast) {
		if (!checkBinaryNode(ast)) {
			return false;
		}

		return bothSidesAreBooleanOrNumeric(ast);
	}

	@Override
	public Boolean visit(Or ast) {
		if (!checkBinaryNode(ast)) {
			return false;
		}

		return bothSidesAreBoolean(ast);
	}

	@Override
	public Boolean visit(Sub ast) {
		if (!checkBinaryNode(ast)) {
			return false;
		}

		return bothSidesAreNumeric(ast);
	}

	@Override
	public Boolean visit(Neg ast) {
		if (!ast.getArg().accept(this)) {
			return false;
		}

		return isCompatibleToNumeric(ast);
	}

	@Override
	public Boolean visit(Not ast) {
		if (!ast.getArg().accept(this)) {
			return false;
		}

		return isCompatibleToBoolean(ast);
	}

	@Override
	public Boolean visit(Pos ast) {
		if (!ast.getArg().accept(this)) {
			return false;
		}

		return isCompatibleToNumeric(ast);
	}

	@Override
	public Boolean visit(Bool ast) {
		Type astType = ast.typeOf(typeEnv);
		if (!astType.isCompatibleToBooleanType()) {
			addErrorMessage(String.format("%s is not a valid Boolean.", ast.toString()));
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
			addErrorMessage(String.format("%s is not a valid Int.", ast.toString()));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(StringLiteral ast) {
		Type astType = ast.typeOf(typeEnv);
		if (!astType.isCompatibleToStringType()) {
			addErrorMessage(String.format("%s is not a valid String.", ast.toString()));
			return false;
		}
		return true;
	}

	private boolean checkBinaryNode(Binary ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}
		return true;
	}

	private boolean bothSidesAreNumeric(Binary ast) {
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);

		if (!(lhsType.isCompatibleToNumericType() && rhsType
				.isCompatibleToNumericType())) {

			addErrorMessage(String.format("Invalid Numeric types (%s '%s' %s).",
					lhsType.toString(), ast.toString(), rhsType.toString()));
			return false;
		}
		return true;
	}

	private boolean bothSidesAreBoolean(Binary ast) {
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);

		if (!(lhsType.isCompatibleToBooleanType() && rhsType
				.isCompatibleToBooleanType())) {

			addErrorMessage(String.format("Invalid Boolean types (%s '%s' %s).",
					lhsType.toString(), ast.toString(), rhsType.toString()));
			return false;
		}
		return true;
	}
	
	private boolean bothSidesAreBooleanOrNumeric(Binary ast) {
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBooleanType() && rhsType.isCompatibleToBooleanType()) 
				&& !(lhsType.isCompatibleToNumericType() && rhsType.isCompatibleToNumericType())) {

			addErrorMessage(String.format("Invalid Boolean/Numeric types (%s '%s' %s).",
					lhsType.toString(), ast.toString(), rhsType.toString()));
			return false;
		}
		return true;
	}
	
	private boolean isCompatibleToNumeric(Unary ast) {
		Type argType = ast.getArg().typeOf(typeEnv);
		if (!argType.isCompatibleToNumericType()) {
			addErrorMessage(String.format("Invalid Numeric type for %s.", 
					ast.toString()));
			return false;
		}
		return true;
	}
	
	private boolean isCompatibleToBoolean(Unary ast) {
		Type argType = ast.getArg().typeOf(typeEnv);
		if (!argType.isCompatibleToBooleanType()) {
			addErrorMessage(String.format("Invalid Boolean type for %s.", 
					ast.toString()));
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
